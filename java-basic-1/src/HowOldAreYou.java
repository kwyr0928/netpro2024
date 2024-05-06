
// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader というのは、データ読み込みのクラス(型)
		// クラスの変数を作るには、new を使う。

		// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
		// Java では、 try{ XXXXXXXX } catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
		int age; // 年齢を格納
		while (true) {
			try { // try-catch
				while (true) { // 条件を満たすまで繰り返し
					System.out.println("何歳ですか?");
					String line = reader.readLine(); // ユーザに入力させる
					if (line.equals("q") || line.equals("e")) { // qかeなら
						System.exit(0); // プログラムを終了
					} else {
					}
					try { // try-catch
						age = Integer.parseInt(line); // 文字列を数字に変換
					} catch (NumberFormatException e) { // 数字以外だったら
						continue; // 再入力を促す
					}
					if (age >= 0 && age < 120) { // 年齢が規定範囲内だったら
						break; // 繰り返しを終了する
					}
				}
				System.out.println("あなたは、" + (age) + "歳ですね");
				System.out.println("2030年のユーザの年齢は" + (age + 6) + "歳ですね"); // 2030年
				int year = 2024 - age;
				if (year <= 1911) {
					System.out.println("明治" + (year - 1867) + "年生まれ"); // 明治
				} else if (year <= 1925) {
					System.out.println("大正" + (year - 1911) + "年生まれ"); // 大正
				} else if (year <= 1988) {
					System.out.println("昭和" + (year - 1925) + "年生まれ"); // 昭和
				} else if (year <= 2018) {
					System.out.println("平成" + (year - 1988) + "年生まれ"); // 平成
				} else {
					System.out.println("令和" + (year - 2018) + "年生まれ"); // 令和
				}
			} catch (IOException e) { // エラーが起きたら
				System.out.println(e);
			}
		}
	}
}

// 課題 キーボードから数字を打ち込む
// その結果、 あなたは、???歳ですね、と画面に表示させる。
// その後、あなたは10年後、????歳ですね、と画面に表示させる。
