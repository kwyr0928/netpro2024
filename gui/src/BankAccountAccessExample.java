public class BankAccountAccessExample {
    public static void main(String[] args) {
        // シングルトンのインスタンスを取得
        BankAccount account = BankAccount.getInstance();

        // 3つのスレッドを作成してバンクアカウントにアクセス
        Thread thread1 = new Thread(() -> {
            account.deposit(100); // 100円を預金
            account.withdraw(50); // 50円を引き出し
        });

        Thread thread2 = new Thread(() -> {
            account.deposit(200); // 200円を預金
            account.withdraw(100); // 100円を引き出し
        });

        Thread thread3 = new Thread(() -> {
            account.deposit(300); // 300円を預金
            account.withdraw(150); // 150円を引き出し
        });

        // スレッドを開始
        thread1.start();
        thread2.start();
        thread3.start();

        // スレッドの終了を待機
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 処理が完了した後の残高を表示
        System.out.println("Final balance: " + account.getBalance());
    }
}
