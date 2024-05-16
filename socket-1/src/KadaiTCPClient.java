import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class KadaiTCPClient {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in, "Shift_JIS");
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            System.out.println("課題を登録します！");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("講義名を入力してください！(例:ネットワークプログラミングとクラウド開発) ↓");
            String subject = scanner.next();
            System.out.println("講義回を入力してください！(例:1,2,3) ↓");
            String number = scanner.next();
            System.out.println("課題名を入力してください！(例:オリジナル通信プログラムの作成) ↓");
            String kadai = scanner.next();
            scanner.close();

            KadaiRegister present = new KadaiRegister();
            present.setSubject(subject);
            present.setNumber(number);
            present.setKadai(kadai);

            oos.writeObject(present);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            KadaiRegister kadaiRegister = (KadaiRegister) ois.readObject();
            String replaySub = kadaiRegister.getSubject();
            System.out.println("サーバからのメッセージは" + replaySub);
            String replayKdi = kadaiRegister.getKadai();
            System.out.println(replayKdi);

            ois.close();
            oos.close();
            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
