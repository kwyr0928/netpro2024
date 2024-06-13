import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimerExample2 {
    public static void main(String[] args) {
        int timeLeft = 10; // タイマーの初期値（秒）

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    System.out.println("Time left: " + timeLeft-- + " seconds");
                } else {
                    System.out.println("Time's up!");
                    ((Timer) e.getSource()).stop(); // タイマーを停止
                }
            }
        });
        timer.start(); // タイマーを開始
    }
}
