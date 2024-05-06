import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PrimeCheck {
    Map<Integer, ArrayList<Integer>> sosuu_group = new HashMap<>(); // 素数を下1桁でグループ分け
    Map<String, Integer> sosuu_chain = new HashMap<>(); // 連続の下1桁でグループ分け
    ArrayList<Integer> sosuuList = new ArrayList<>(); // 素数
    boolean isSosuu = true; // 素数かどうか判定

    public static void main(String[] args) {
        PrimeCheck check = new PrimeCheck();
        check.sosuuSearch(); // 素数を判定
        check.sosuuGroup(); // 素数をグループ分け
        check.ranking(); // ランキング付け
    }

    public void sosuuSearch() {
        for (int i = 3; i < 100000; i++) {
            for (int j = 1; j < 100000; j++) {
                if (i % j == 0 && j != 1 && j != i) {
                    isSosuu = false;
                    break; // 1かi以外で割れたら素数ではない
                }
            }
            if (isSosuu) {
                sosuuList.add(i); // 素数だったらリストに代入
            }
            isSosuu = true;
        }
        // System.out.println(sosuuList);
    }

    public void sosuuGroup() { // 素数をグループ分け
        for (int j = 0; j < 10; j++) { // 0-9まで
            ArrayList<Integer> list = new ArrayList<>(); // 専用のリストを作成
            for (int i = 0; i < sosuuList.size(); i++) { // 素数を順番に取り出す
                if (sosuuList.get(i) % 10 == j) { // 下1桁がjだったら
                    list.add(sosuuList.get(i)); // リストに代入
                }
            }
            sosuu_group.put(j, list); // j(下１桁)に完成したリストを代入
        }
        // System.out.println(sosuu_group);
    }

    public void ranking() { // ランキング付け
        int[] number = new int[4]; // 前後の下1桁
        number[0] = 1;
        number[1] = 3;
        number[2] = 7;
        number[3] = 9;

        for (int n = 0; n < 3; n++) {
            for (int m = 0; m < 3; m++) {
                sosuu_chain.put("前:" + number[n] + " 後:" + number[m] + "", 0); // 初期値0をセット
                for (int i = 1; i < sosuuList.size(); i++) {
                    if (sosuuList.get(i - 1) % 10 == number[n] && sosuuList.get(i) % 10 == number[m]) {
                        sosuu_chain.put("前:" + number[n] + " 後:" + number[m] + "",
                                sosuu_chain.get("前:" + number[n] + " 後:" + number[m] + "") + 1); // 一致するものがあったらvalueを+1する
                    }
                }

            }
        }
        System.out.println(sosuu_chain);
        // 出現回数が多い順に並び替え
        sosuu_chain.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
