import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidIpAddress {
    public static void main(String[] args) {
        System.out.println(checkIpAddress("255.239.102.5"));
        System.out.println(checkIpAddress("256.239.102.5"));
        System.out.println(checkIpAddress("123.239.102."));
        System.out.println(checkIpAddress("123.239..102.5"));
    }

    public static String checkIpAddress(String ipAddress) {
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[1]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[1]?[0-9]?[0-9])$");
        Matcher matcher = pattern.matcher(ipAddress);
        if (matcher.matches()) {
            return("Valid IP address!");
        } else {
            return("Incorrect IP address.");
        }
    }
}
