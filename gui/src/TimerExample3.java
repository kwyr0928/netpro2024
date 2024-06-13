import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimerExample3 {
    public static void main(String[] args) {
        int counter = 0;
        int maxCount = 5; // タイマーの最大回数

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Timer fired! Count: " + (++counter));
                if (counter >= maxCount) {
                    System.out.println("Timer stopped.");
                    ((Timer) e.getSource()).stop(); // タイマーを停止
                }
            }
        });
        timer.start(); // タイマーを開始
    }
}
