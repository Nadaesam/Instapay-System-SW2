
import java.io.Serializable;
import java.time.LocalDateTime;

public class WalletTransfer extends Transaction implements Serializable {
    public WalletTransfer(String id, float amount, LocalDateTime time, User sender, User receiver) {
        super(id, amount, time, sender, receiver);
    }

    public void transfer(User Sender  , WalletUser Receiver , float Amount) {
        
              Sender.setBalance(sender.getBalance() - amount);
              Receiver.getWallet().deposit(Amount);     
              setSender(Sender);
              setReceiver(Receiver);
              Sender.addTransaction(this);
              Receiver.addTransaction(this);
    }
    

    
    
}