import java.io.Serializable;

public class TaskObject implements ITask, Serializable {
    int number;
    PrimeChecker checker = new PrimeChecker();

    public static void main(String[] args) {
    }

    @Override
    public void setExecNumber(int x) {
        this.number = x;
    }

    @Override
    public void exec() {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            if (PrimeChecker.isPrime(i)) {
                result = i;
                System.out.println(i + " is a prime number.");
            } else {
                System.out.println(i + " is not a prime number.");
            }
        }
        number = result;
    }

    @Override
    public int getResult() {
        return number;
    }
}
