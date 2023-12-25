
import java.io.Serializable;


 public class CIBWallet extends Wallet implements Serializable{
    public CIBWallet(String id, float balance, String mobileNumber) {
        super(id, balance, mobileNumber);
    }

    @Override
    public void viewBalance() {
        System.out.println("CIB Wallet Balance: " + getBalance());
    }

    @Override
    public void withdraw(float x) {
      float b = getBalance();
      if (x <= b) {
            b -= x;
            setBalance(b);
            System.out.println("Your balance in your CIB wallet now is: " +  b);
        } else {
            System.out.println("Insufficient balance.");
        }      
    }
    
    
    @Override
     public void deposit(float x) {
         float b = getBalance();
            b+= x;
             setBalance(b);
            System.out.println("Receiver balance now: " +  b);
         System.out.println("________");
    
    }
}