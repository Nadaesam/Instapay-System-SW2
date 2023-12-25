
import java.io.Serializable;


public abstract class Wallet implements Serializable{
    private String id;
    private float balance;
    private String mobileNumber;

    public Wallet(String id, float balance, String mobileNumber) {
        this.id = id;
        this.balance = balance;
        this.mobileNumber = mobileNumber;
    }

    public String getId() {
        return id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public float checkBalance() {
        return balance;
    }

    public abstract void viewBalance();

    public abstract void withdraw(float x);
    
    public abstract void deposit(float x);
}
