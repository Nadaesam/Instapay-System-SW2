
import java.io.Serializable;
import java.time.LocalDateTime;




public class BankAccountTransfer extends Transaction implements Serializable{
    public BankAccountTransfer(String id, float amount, LocalDateTime time, User sender, User receiver) {
        super(id, amount, time, sender, receiver);
    }

    public void transfer(User Sender  , BankUser Receiver , float Amount) {
        
        Sender.setBalance(Sender.getBalance() - Amount);
        setSender(Sender);
        Receiver.getBankAccount().deposit(Amount);
        setReceiver(Receiver);
        Sender.addTransaction(this);
        receiver.addTransaction(this);
    }
    
}