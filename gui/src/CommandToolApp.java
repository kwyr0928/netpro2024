import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CommandToolApp extends JFrame implements ActionListener {

    private JTextArea outputTextArea;
    private JTextField inputTextField;

    public CommandToolApp() {
        setTitle("Command Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // テキストエリアを作成してコンテンツパネルに追加
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        // 入力用のテキストフィールドを作成してコンテンツパネルに追加
        inputTextField = new JTextField();
        inputTextField.addActionListener(this);

        // コンテンツパネルを作成してコンポーネントを配置
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(inputTextField, BorderLayout.SOUTH);
        setContentPane(contentPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ユーザーがコマンドを入力したときの処理
        String command = inputTextField.getText();
        executeCommand(command);
        inputTextField.setText(""); // 入力フィールドをクリア
    }

    private void executeCommand(String command) {
        try {
            // コマンドを実行し、結果を取得してテキストエリアに表示
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                outputTextArea.append(line + "\\n");
            }
            reader.close();
        } catch (IOException ex) {
            // コマンドの実行中にエラーが発生した場合の処理
            outputTextArea.append("Error executing command: " + ex.getMessage() + "\\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CommandToolApp app = new CommandToolApp();
            app.setVisible(true);
        });
    }
}
