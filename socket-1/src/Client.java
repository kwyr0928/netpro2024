import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // 1. サーバーに接続するためのSocketを作成
            Socket socket = new Socket("133.20.69.215", 5050);
            //大学とwifiは学生同士の通信を認めていないため
            //"サーバーのIPアドレス"は"localhost" //ポート番号は5050などを利用しよう

            // 2. サーバーにデータを送信するためのOutputStreamを取得
            OutputStream outputStream = socket.getOutputStream();
            // データを送信するためのラッパーを作成
            PrintWriter writer = new PrintWriter(outputStream, true);

            // 3. サーバーからデータを受信するためのInputStreamを取得
            InputStream inputStream = socket.getInputStream();
            // データを受信するためのラッパーを作成
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // 4. サーバーにデータを送信
            writer.println("🐰");

            // 5. サーバーからの応答を受信して表示
            String response = reader.readLine();
            System.out.println("Server response: " + response);

            // 6. 接続を閉じる
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}