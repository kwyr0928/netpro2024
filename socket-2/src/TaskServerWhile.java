import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TaskServerWhile {

    public static void main(String arg[]) {
        ServerSocket server = null;
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
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
                    socket = server.accept(); // クライアントからの接続要求を待ち、
                    // 要求があればソケットを取得し接続を行う
                    System.out.println("接続しました。相手の入力を待っています......");

                    ois = new ObjectInputStream(socket.getInputStream());

                    TaskObject task = (TaskObject) ois.readObject();// Integerクラスでキャスト
                    if (task.getResult() <= 1) { // 1以下の値が入力された場合に終了
                        break;
                    }
                    task.exec();
                    oos = new ObjectOutputStream(socket.getOutputStream());

                    oos.writeObject(task);
                    oos.flush();

                } catch (Exception e) {
                    System.err.println("クライアントとの通信でエラーが発生しました");
                    e.printStackTrace();
                } finally {
                    // close処理
                    try {
                        if (ois != null)
                            ois.close();
                        if (oos != null)
                            oos.close();
                        if (socket != null)
                            socket.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
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
