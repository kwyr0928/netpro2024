package thread;

// Runnable インターフェースを実装することで、このクラスのインスタンスはスレッドとして実行可能になります。
public class ExThreadsMain implements Runnable {
    String task = "";
    // main メソッドはプログラムのエントリーポイントです。
    public static void main(String[] args) {
        ExThreadsMain[] works = new ExThreadsMain[17];
        for(int i=0; i<works.length; i++){
        works[i] = new ExThreadsMain();
    }
    works[0].setTask("洗濯");
    works[1].setTask("炊飯");
    works[2].setTask("掃除");
    works[3].setTask("洗い物");
    works[4].setTask("料理");
    works[5].setTask("風呂掃除");
    works[6].setTask("テレビ");
    works[7].setTask("ブルアカ");
    works[8].setTask("Twitter");
    works[9].setTask("散歩");
    works[10].setTask("昼寝");
    works[11].setTask("課題");
    works[12].setTask("インターン");
    works[13].setTask("就活");
    works[14].setTask("電話");
    works[15].setTask("プログラミング");
    works[16].setTask("草むしり");
    for(ExThreadsMain work : works){
        new Thread (work).start();
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

    public void setTask(String taskContent) {
    task = taskContent;
    }
    // run メソッドは、新しいスレッドが実行するコードを含みます。
    public void run() {
        // この try-catch ブロックは、0 から 9 までの値を 1000 ミリ秒間隔で出力するループを実行します。
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(task+" thread:i=" + i);
                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(1000); // ミリ秒単位のスリープ時間
            }
        } catch (InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }
}
