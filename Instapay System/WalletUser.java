
import java.io.Serializable;
import java.util.Scanner;

public class WalletUser extends User implements ProfileViewer, Serializable {

    private Wallet wallet;
    
    
    public WalletUser() {
     this.settype("WalletUser");
    }


   
    public WalletUser(String userId, String username, String password, String mobileNumber, boolean verificationStatus) {
        super(userId, username, password, mobileNumber, verificationStatus);
         this.settype("WalletUser");
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your wallet mobile number: ");
        String mobileNumber = scanner.nextLine();
        API api = new API();
        Database userDatabase = new Database();
        Verification verification = new Verification(this);

        boolean authentication = api.authenticateWalletUser(mobileNumber);
        if (!authentication) {
            System.out.println("There is no wallet linked to this number.");
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
        if (!PasswordValidator.isStrongPassword(password)) {

        }
        Wallet userWallet = api.getWallet(mobileNumber);
        WalletUser newUser = new WalletUser("new_user",username, password,mobileNumber,false);
        newUser.setWallet(userWallet);
        userDatabase.addUser(newUser);

        System.out.println("You have registered successfully!");
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
        System.out.println("Account Type: Wallet account" );
        System.out.println("ID: " + this.getUserId());
        System.out.println("Name: " + this.getUsername());
        System.out.println("Mobile Number: " + this.getMobileNumber());
        System.out.println("Balance : " + this.wallet.getBalance());
        System.out.println("Wallet ID : " + this.wallet.getId());

    }

    @Override
    public float inquireAboutBalance() {
        return wallet.checkBalance();
    }

    @Override
    public void pay(float amount) {
        wallet.withdraw(amount);
    }

    @Override
    public void setBalance(float balance) {
       wallet.setBalance(balance);
    }

    @Override
    public float getBalance() {
       return wallet.getBalance();
    }

    @Override
    public void displayUserInfo() {
        this.viewProfile();
    }
  

}
