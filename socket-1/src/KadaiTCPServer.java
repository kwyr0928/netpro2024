import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class KadaiTCPServer {

    private static String serverProcess(String subject, String number, String kadai) {
        StringBuilder sb = new StringBuilder();
        sb.append(subject);
        sb.append("第" + number + "回の");
        sb.append(kadai + "を早めに終わらせよう！");
        sb.append("無理しないように！");
        return sb.toString();
    }

    public static void main(String[] args) {
        ServerSocket server = null;

        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in, "Shift-JIS");
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            while (true) {
                System.out.println("接続を待っています......");
                Socket socket = null;
                ObjectInputStream ois = null;
                ObjectOutputStream oos = null;

                try {
                    socket = server.accept(); // クライアントからの接続要求を待ち、要求があればソケットを取得し接続を行う
                    System.out.println("クライアントと接続しました。");

                    ois = new ObjectInputStream(socket.getInputStream());
                            KadaiRegister kadaiRegister = (KadaiRegister) ois.readObject(); // KadaiRegisterクラスでキャスト

                            String subject = kadaiRegister.getSubject();
                            System.out.println("講義名は " + subject);
                            String number = kadaiRegister.getNumber();
                            System.out.println("講義回は 第" + number + "回");
                            String kadai = kadaiRegister.getKadai();
                            System.out.println("課題名は " + kadai);

                            oos = new ObjectOutputStream(socket.getOutputStream());

                            KadaiRegister response = new KadaiRegister();
                            response.setSubject(kadai + "を登録しました！");
                            response.setKadai(serverProcess(subject, number, kadai));

                            oos.writeObject(response);
                            oos.flush();

                            if (kadai.equals("exit")) { // 課題名が"exit"の場合に終了
                                break;
                            }
                } catch (Exception e) {
                    System.err.println("クライアントとの通信でエラーが発生しました");
                    e.printStackTrace();
                } finally {
                    // close処理
                    try {
                        if (ois != null) ois.close();
                        if (oos != null) oos.close();
                        if (socket != null) socket.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
