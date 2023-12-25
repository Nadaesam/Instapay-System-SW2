
import java.io.Serializable;
import java.time.LocalDateTime;


public class InstapyTransfer extends Transaction implements Serializable{
    public InstapyTransfer(String id, float amount, LocalDateTime time, User sender, User receiver) {
        super(id, amount, time, sender, receiver);
    }

    public void transfer(User Sender , User Receiver, float Amount) {

            
            Sender.setBalance(Sender.getBalance()-Amount);
            Receiver.setBalance(Receiver.getBalance()+Amount);
            setSender(Sender);
            setReceiver(Receiver);
            Sender.addTransaction(this);
            Receiver.addTransaction(this);
    }
    
    

    
}
