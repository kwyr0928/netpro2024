import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class HeikinCKadai {
    public static void main(String[] args) {
        Kamoku[] kamoku = new Kamoku[100];
        ArrayList<Kamoku> goukaku = new ArrayList<>();
        Random rand = new Random();
        int sum = 0;

        for (int i = 0; i < kamoku.length; i++) {
            kamoku[i] = new Kamoku(rand.nextInt(101), i);
            int score = kamoku[i].getScore();
            if (score >= 80) {
                goukaku.add(kamoku[i]);
            }
            sum += score;
        }

        int ave = sum / kamoku.length;
        System.out.println("平均点は" + ave);

        // MyComparatorを使用してgoukakuリストを並び替える
        Collections.sort(goukaku, new MyComparator());
        System.out.println("以下合格者の点数です。");
        // 並び替えたリストを出力する
        for (Kamoku k : goukaku) {
            System.out.println("学番" + k.getStudentid() + ": " + k.getScore());
        }
    }

    public static class MyComparator implements Comparator<Kamoku> {
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
