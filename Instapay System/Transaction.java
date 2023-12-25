
import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Transaction implements Serializable{
    public String id;
    public float amount;
    public LocalDateTime time;
    public User sender;
    public User receiver;

    public Transaction(String id, float  amount, LocalDateTime time, User sender, User receiver) {
        this.id = id;
        this.amount = amount;
        this.time = time;
        this.sender = sender;
        this.receiver = receiver;
    }


    public boolean isValidTransaction() {
        
        return true;
    }

    public void generateReceipt() {
        System.out.println("The transaction ID :" + id);
      System.out.println("The transefered amount :"  +amount);
        System.out.println("The Date :" + time);
        System.out.println("_________");
        System.out.println("The sender ID :" + sender.getUserId());
        System.out.println("The sender username  :" + sender.getUsername());
        System.out.println("The sender phone number :" + sender.getMobileNumber());
       System.out.println("_________");
       System.out.println("The receiver ID :" + receiver.getUserId());
        System.out.println("The recceiver username  :" + receiver.getUsername());
        System.out.println("The receiver phone number :" + receiver.getMobileNumber());
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

   public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}