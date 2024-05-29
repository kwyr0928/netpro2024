package networking.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastServer {
    public static void main(String[] args) {
        try {
            // マルチキャストグループのIPアドレスとポート番号を指定
            InetAddress group = InetAddress.getByName("239.0.0.1");
            int port = 12345;

            // マルチキャストソケットを作成し、指定したグループとポートに参加
            MulticastSocket multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(group);

            System.out.println("Server started. Waiting for commands...");

            // 受信用のバッファを作成
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);


            // コマンドを受信して永遠に待機
            while (true) {
                multicastSocket.receive(packet);
                String receivedCommand = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received command: " + receivedCommand);

                Scanner scanner = new Scanner(System.in);
                System.out.print("返信を入力してください: ");
                String repmessage = scanner.nextLine();
                byte[] bytesToSend = repmessage.getBytes();
                InetAddress repnetaddress=packet.getAddress();
                int  repportnum=packet.getPort();
                DatagramPacket repPacket2 = new DatagramPacket(bytesToSend, bytesToSend.length, repnetaddress, repportnum);
                multicastSocket.send(repPacket2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
