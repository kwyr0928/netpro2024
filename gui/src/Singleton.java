public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        // コンストラクタを private にすることで外部からのインスタンス化を防ぐ
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
