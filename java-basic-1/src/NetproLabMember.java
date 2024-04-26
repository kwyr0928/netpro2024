import java.util.Random;

public class NetproLabMember {
    public static void main(String[] args){
    double result = 1; // 15年間岩井研に女性の学生が来ない確率
    int girlRate = 20; // 女子の割合
    Random rand = new Random(); // ランダム関数
    int lab[][] = new int[15][3]; // 二次元配列
    for (int i = 0; i < 15; i++) { // 15年分
            lab[i][0] = rand.nextInt(20)+100; // 定員100~120
            lab[i][1] = girlRate; // 女子の割合 毎年1%上昇
            lab[i][2] = rand.nextInt(6)+7; // 岩井研の配属人数7~13
            int girl = (int)(lab[i][0]*lab[i][1]*0.01); // 女子の人数
            int boyRate = (100-lab[i][1]); // 男子の割合
            int boy = (int)(lab[i][0]*boyRate*0.01); // 男子の人数
            // 総数から岩井研の人数を取り出す組み合わせ
            double iwiLab = comb(lab[i][0], lab[i][2]);
            // 男性の中から岩井研のメンバーを取り出す組み合わせ
            double iwiMan = comb(boy, lab[i][2]);
            // 岩井研の人数に男性しか入らない割合
            result *= (double) iwiMan / iwiLab;
            System.out.println(i + "年目：女子" + girl + "男子" + boy); // 女子男子の人数
            System.out.println(result); // その年での累計割合
            girlRate += 1; // 女子の割合が1%上昇
        }
System.out.println("15年間岩井研に女性の学生が来ない確率は" + result + "です。"); // 結果を表示
}
public static double comb(int n, int r) { // 組み合わせの計算
    double result1 = 1;
    double result2 = 1;
    for(int i=0; i<r; i++){ // 分子
        result1 *= n;
        n--;
    }
    for(int j=0; j<r; j++){ // 分母
        result2 *= r;
        r--;
    }
    return result1 / result2;
}
}

