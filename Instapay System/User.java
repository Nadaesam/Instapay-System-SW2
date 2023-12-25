
import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable {

    private String userId;
    private String userName;
    private String password;
    private String mobileNumber;
    private boolean verificationStatus;
    private String type;
    private ArrayList<Bill> bills = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    User() {}
   
        public User(String userId, String username, String password, String mobileNumber, boolean verificationStatus) {
        this.userId = userId;
        this.userName = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.verificationStatus = verificationStatus;
        bills = new ArrayList<>();
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setVerificationStatus(boolean verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public boolean getVerificationStatus() {
        return verificationStatus;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    public void removeBill(Bill bill) {
        bills.remove(bill);
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public void printBills() {
        for (Bill b : bills) {
            b.billDetails();
        }
    }
     public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction>transactions) {
        this.transactions = transactions;
    }
    
    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }
    public  String getType(){
        return type;
    }
    protected void settype(String type){
        this.type = type;
    }

    public abstract void setBalance(float balance);
    
    public abstract float getBalance();
    
    public abstract void register();

    public abstract User login();

    public abstract float inquireAboutBalance();

    public abstract void pay(float amount);
      
    public abstract void displayUserInfo();

}
