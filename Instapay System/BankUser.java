
import java.io.Serializable;
import java.util.Scanner;

public class BankUser extends User implements ProfileViewer, Serializable {

    private BankAccount bankAccount;

    BankUser() {
    this.settype("BankUser");
    }

    public BankUser(String userId, String username, String password, String mobileNumber, boolean verificationStatus) {
        super(userId, username, password, mobileNumber, verificationStatus);
         this.settype("BankUser");
    }

    @Override
    public User login() {
        Database userdb = new Database();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Database userDatabase = new Database();
        boolean authenticateUser = userDatabase.authenticateUser(username, password);

        if (authenticateUser) {
            System.out.println("Logged in Succesfully :)");
            return userdb.getUser(username, password);
        } else {
            System.out.println("User does not exist.");
        }
        return null;
    }

    @Override
    public void viewProfile() {

        System.out.println("Account Type: BANK ACCOUNT");
        System.out.println("ID: " + this.getUserId());
        System.out.println("Name: " + this.getUsername());
        System.out.println("Mobile Number: " + this.getMobileNumber());
        System.out.println("Bank Name: " + this.getBankAccount().getBankName());
        System.out.println("Balance: " + this.getBankAccount().getBalance());

    }

    @Override
    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your bank account mobile number: ");
        String mobileNumber = scanner.nextLine();
        API api = new API();
        Database userDatabase = new Database();
        Verification verification = new Verification(this);

        boolean authentication = api.autheticateBankUser(mobileNumber);
        if (!authentication) {
            System.out.println("There is no bank account linked to this number.");
            return;
        }

        verification.sendOTP(mobileNumber);
        System.out.print("Enter OTP sent to your number: ");
        int otp = scanner.nextInt();
        scanner.nextLine();

        if (!verification.verifyOTP(otp)) {
            System.out.println("Wrong OTP!");
            return;
        }

        System.out.print("Enter your username : ");
        String username = scanner.nextLine();

        while (userDatabase.doesUserExist(username)) {
            System.out.println("This username exists!");
            System.out.print("Enter your username : ");
            username = scanner.nextLine();
        }

        System.out.print("Enter your password : ");
        String password = scanner.nextLine();

        BankAccount bankAccount = api.getUserBankAccount(mobileNumber);
        BankUser newUser = new BankUser("new_user", username, password, mobileNumber, false);
        newUser.setBankAccount(bankAccount);
        userDatabase.addUser(newUser);

        System.out.println("You have registered successfully!");
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public float inquireAboutBalance() {
        return bankAccount.checkBalance();
    }

    @Override
    public void pay(float amount) {
        bankAccount.withdraw(amount);
    }

    @Override
    public void setBalance(float balance) {
      bankAccount.setBalance(balance);
    
    }

    @Override
    public float getBalance() {
        return bankAccount.getBalance();
    }

    @Override
    public void displayUserInfo() {
       this.viewProfile();
    }
}
