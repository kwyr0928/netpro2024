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
			//  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
			int age;
		try {
			while(true){
			System.out.println("何歳ですか?");
			String line = reader.readLine();
			if(line.equals("q") || line.equals("e")){
			System.exit(0);
			}else{
			}
			age = Integer.parseInt(line);
			if(age >= 0 && age < 120){
				break;
			}
		}
			System.out.println("2030年のユーザの年齢は" + ( age + 6 ) + "歳ですね。");
			if(( 2024-age ) <= 1894){
				System.out.println("明治" + ( 2024-age-1890+23 ) + "年生まれ");
			}else if(( 2024-age ) <= 1925){
				System.out.println("大正" + ( 2024-age-1895 ) + "年生まれ");
			}else if(( 2024-age ) <= 1988){
				System.out.println("昭和" + ( 2024-age-1925 ) + "年生まれ");
			}else if(( 2024-age ) <= 2018){
				System.out.println("平成" + ( 2024-age-1988 ) + "年生まれ");
			}else{
				System.out.println("令和" + ( 2024-age-2018 ) + "年生まれ");
			}
	}
		catch(IOException e) {
			System.out.println(e);
		}


	}
}

//  課題    キーボードから数字を打ち込む
//  その結果、 あなたは、???歳ですね、と画面に表示させる。
//  その後、あなたは10年後、????歳ですね、と画面に表示させる。

