import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPassword {
    public static void main(String[] args) {
        System.out.println(checkPassword("MyPasssword10"));
        System.out.println(checkPassword("MyPasssword"));
        System.out.println(checkPassword("mypasssword10"));
        System.out.println(checkPassword("myPass1"));
        System.out.println(checkPassword("myVeryVeryLargePass10"));
        System.out.println(checkPassword("MyPasssword-10"));
    }

    public static String checkPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[A-Z])[A-Za-z0-9]{8,16}$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            return("Valid password!");
        } else {
            return("The password must consist of Latin letters and numbers, be from 8 to 16 characters long and contain at least one uppercase letter and one number.");
        }
    }
}
