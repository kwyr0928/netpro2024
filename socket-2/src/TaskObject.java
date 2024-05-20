import java.io.Serializable;

public class TaskObject implements Serializable {

    long number;

    public void setNumber(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public void exec() {
        number = number * number;
    }

    public interface ITask {
        public void setExecNumber(int x); //クライアントで最初に計算させる数字を入力しておく関数
        public void exec() ; //サーバで計算を実行をさせる関数...計算アルゴリズムが記載される。下記アルゴリズムを参照のこと
        public int getResult(); //クライアントで結果を取り出す関数
    }
}
