import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class HeikinCKadai {
    public static void main(String[] args) {
        Kamoku[] kamoku = new Kamoku[100]; // 全員の番号と点数を格納
        ArrayList<Kamoku> goukaku = new ArrayList<>(); // 合格者リスト
        Random rand = new Random();
        int sum = 0; // 合計得点

        for (int i = 0; i < kamoku.length; i++) {
            kamoku[i] = new Kamoku(rand.nextInt(101), i); // 0-100までランダム
            int score = kamoku[i].getScore();
            if (score >= 80) { // 80点以上だったら
                goukaku.add(kamoku[i]); // 合格者リストに格納
            }
            sum += score; // 点数を加算
        }

        int ave = sum / kamoku.length;
        System.out.println("");
        System.out.println("平均点は" + ave); // 平均点
        System.out.println("");

        // MyComparatorを使用して合格者リストを並び替える
        Collections.sort(goukaku, new MyComparator());
        System.out.println("以下合格者の点数です。");
        System.out.println("");
        // 並び替えたリストを出力する
        for (Kamoku k : goukaku) {
            System.out.print("学籍番号" + k.getStudentid() + ": ");
            System.out.println(k.getScore());
            System.out.println("");
        }
    }

    public static class MyComparator implements Comparator<Kamoku> { // 並び替え
        @Override
        public int compare(Kamoku s1, Kamoku s2) {
            if (s1.getScore() < s2.getScore()) {
                return -1;
            } else if (s1.getScore() > s2.getScore()) {
                return 1;
            } else {
                return Integer.compare(s1.getStudentid(), s2.getStudentid());
            }
        }
    }
}
