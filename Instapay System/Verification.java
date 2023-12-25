
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Verification {

    private User user;
    private int OTP;

    public Verification(User user) {
        this.user = user;
    }

    public int generateOTP() {
        // Generate a random 6-digit OTP
        Random random = new Random();
        OTP = 100000 + random.nextInt(900000);
        return OTP;
    }

    public  void sendOTP(String mobileNumber) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("otp.txt"))) {
            int generatedOTP = generateOTP();
            writer.write("To: " + mobileNumber);
            writer.newLine();
            writer.write("OTP: " + generatedOTP);
            writer.newLine();
            System.out.println("OTP sent to " + mobileNumber + " successfully.");
        } catch (IOException e) {
            System.out.println("cannot open the file");
            e.printStackTrace();
        }
    }

    public boolean verifyOTP(int enteredOTP) {
        return OTP == enteredOTP;
    }
}
