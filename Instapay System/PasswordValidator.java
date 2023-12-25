
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    public static boolean isStrongPassword(String password) {

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
    
    public static void displayPasswordRules() {
        System.out.println("Password Rules:");
        System.out.println("- Length Requirement: Password must be at least 8 characters long.");
        System.out.println("- Use a combination of uppercase and lowercase letters.");
        System.out.println("- Include at least one numeric digit (0-9).");
        System.out.println("- Include at least one special character (e.g., @, $, !, %, *, ?, &).");
       
    }
}
