import java.io.Serializable;

public class KadaiRegister implements Serializable {

    String subject;
    String number;
    String kadai;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getKadai() {
        return kadai;
    }

    public void setKadai(String kadai) {
        this.kadai = kadai;
    }

}