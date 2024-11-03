import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartsWithLetter {
    public static void main(String[] args) {
        String text = "After a long day at work, filled with meetings and deadlines, she finally arrived home, eager to relax and unwind.";
        char c = 'a';
        Pattern pattern = Pattern.compile("\\b["+Character.toLowerCase(c)+Character.toUpperCase(c)+"][A-z]*\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }  
}
