import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ActionListenerExample2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Action Listener Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField(20);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Entered text: " + textField.getText());
            }
        });

        frame.getContentPane().add(textField);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
