import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ActionListenerExample3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Action Listener Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                JOptionPane.showMessageDialog(frame, "Button clicked: " + command);
            }
        };

        button1.addActionListener(listener);
        button2.addActionListener(listener);

        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
