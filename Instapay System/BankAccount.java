
import java.io.Serializable;

public class BankAccount implements Serializable{
    private String bankId;
    private String bankName;
    private float balance;
    private String mobileNumber;

    public BankAccount(){}
    public BankAccount(String bankId, String bankName, float balance, String mobileNumber) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.balance = balance;
        this.mobileNumber = mobileNumber;
    }

    public String getBankId() {
        return bankId;
    }

    public String getBankName() {
        return bankName;
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

    public void viewBalance() {
        System.out.println("Bank Account Balance: " + balance);
    }

    public void withdraw(float x) {
         if (x <= balance) {
            balance -= x;
            System.out.println("Your balance now: " +  balance);
        } else {
            System.out.println("Insufficient balance.");
        }    
    }
    
    
    public void deposit(float x) {
         
            balance += x;
            System.out.println("Your balance now: " +  balance);
             System.out.println("________");
    
        
    }
    
}
