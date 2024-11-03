import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalFinder {
    public static void main(String[] args) {
        String text = "JavaScript Java CamelCase";
        Pattern pattern = Pattern.compile("[a-z]{1}[A-Z]{1}");
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll("!$0!");
        System.out.println(result);
    }
}
