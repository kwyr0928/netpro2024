package thread;

// Runnable インターフェースを実装することで、このクラスのインスタンスはスレッドとして実行可能になります。
public class CountAZTenRunnable implements Runnable {
    String myAlfabetStr = "noalfabet";
    // main メソッドはプログラムのエントリーポイントです。
    public static void main(String[] args) {
        CountAZTenRunnable[] cts = new CountAZTenRunnable[26];
        for(int i=0; i<26; i++){
        cts[i] = new CountAZTenRunnable();
        cts[i].setAlfabet((char)(97+i)+"-thread chan");
    }
    for(CountAZTenRunnable ct : cts){
        new Thread (ct).start();
    }


        // この try-catch ブロックは、0 から 9 までの値を 500 ミリ秒間隔で出力するループを実行します。
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("main:i=" + i);

                // メインスレッドを 500 ミリ秒間一時停止します。
                Thread.sleep(500); // ミリ秒単位のスリープ時間
            }
        } catch (InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }

    public void setAlfabet(String alfabetstr) {
    myAlfabetStr = alfabetstr;
    }
    // run メソッドは、新しいスレッドが実行するコードを含みます。
    public void run() {
        // この try-catch ブロックは、0 から 9 までの値を 1000 ミリ秒間隔で出力するループを実行します。
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(myAlfabetStr+"runnable thread:i=" + i);
                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(1000); // ミリ秒単位のスリープ時間
            }
        } catch (InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }
}
