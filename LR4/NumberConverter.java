import java.io.FileWriter;
import java.io.IOException;

public class NumberConverter {
    public static void main(String[] args) {
        try {
            System.out.println(StringToInt("23"));
        } catch (CustomNumberFormatException e) {
            System.out.println(e);
        }

        try {
            System.out.println(StringToInt("4ol"));
        } catch (CustomNumberFormatException e) {
            System.out.println(e);
        }
    }

    public static int StringToInt(String str) throws CustomNumberFormatException {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                logException("Сannot convert string to number: " + str);
                throw new CustomNumberFormatException("Сannot convert string to number");
            }
        }
        return Integer.parseInt(str);
    }

    public static void logException(String message) {
        try (FileWriter writer = new FileWriter("logFile.txt", true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

class CustomNumberFormatException extends NumberFormatException {
    public CustomNumberFormatException(String message) {
        super(message);
    }
}
