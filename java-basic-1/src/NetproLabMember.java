import java.util.Random;

public class NetproLabMember {
    public static void main(String[] args){
    int girlRate = 20;
    double boyRates = 1;
    Random rand = new Random();
    int lab[][] = new int[15][3];
    for (int i = 0; i < 15; i++) {
            lab[i][0] = rand.nextInt(20)+100;
            lab[i][1] = girlRate;
            lab[i][2] = rand.nextInt(6)+7;
            // int girl = (int)(lab[i][0]*lab[i][1]*0.01);
            // int boy = (int)(lab[i][0]*(100-lab[i][1])*0.01);
            Double boyRate = (100-lab[i][1])*0.01;
            for(int j=1; j<lab[i][2]; j++){
            boyRate *=(100-lab[i][1])*0.01;
            }
            boyRates *= boyRate;
            // System.out.println("女子" + girl + "男子" + boy + "女子いない確率" + boyRate + "," + boyRates);
            girlRate += 1;
        }
System.out.println("15年間岩井研に女性の学生が来ない確率は" + boyRates + "です。");
}
}

