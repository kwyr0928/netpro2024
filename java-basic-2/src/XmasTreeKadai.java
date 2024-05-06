import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XmasTreeKadai {
    String[] custom = new String[4];

    public static void main(String[] args) {
        XmasTreeKadai xmas = new XmasTreeKadai();
        xmas.tree();

    }

    public void tree() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("最大の葉の半分の横幅の数,");
            System.out.print("幹の幅列, 幹の長さ, 模様 を入力してください");
            String line = reader.readLine();
            custom = line.split(",");

        } catch (IOException e) {
            System.out.println(e);
        }

        for (int i = 0; i < Integer.parseInt(custom[0]); i++) {
            for (int j = i; j < Integer.parseInt(custom[0]); j++) {
                if (j % 2 == 0) {
                    System.out.print(custom[3]);
                } else {
                    System.out.print(" ");
                }
            }
            for (int k = 0; k < 2 * i; k++) {
                System.out.print("*");
            }
            for (int j = Integer.parseInt(custom[0]) * 2; j > i + Integer.parseInt(custom[0]); j--) {
                if (j % 2 == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(custom[3]);
                }
            }
            System.out.println();
        }
        for (int i = 0; i < Integer.parseInt(custom[2]); i++) {
            for (int l = 0; l < Integer.parseInt(custom[0]) * 2; l++) {
                if (l < Integer.parseInt(custom[0]) + Integer.parseInt(custom[1]) / 2
                        && l > Integer.parseInt(custom[0]) - Integer.parseInt(custom[1]) / 2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
// https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Integer.html