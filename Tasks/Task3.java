import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("#1");
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));

        System.out.println("#2");
        Object[][] items = {{"Laptop", 124200}, {"Phone", 51450}, {"Headphones", 13800}};
        System.out.println(Arrays.deepToString(sale(items, 25)));

        System.out.println("#3");
        System.out.println(sucsessShoot(0, 0, 5, 2, 2));
        System.out.println(sucsessShoot(-2, -3, 4, 5, -6));

        System.out.println("#4");
        System.out.println(parityAnalysis(243));
        System.out.println(parityAnalysis(12));
        System.out.println(parityAnalysis(3));

        System.out.println("#5");
        System.out.println(rps("rock", "paper"));
        System.out.println(rps("paper", "rock"));
        System.out.println(rps("paper", "scissors"));
        System.out.println(rps("scissors", "scissors"));
        System.out.println(rps("scissors", "paper"));

        System.out.println("#6");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));
        
        System.out.println("#7");
        Object[][] inventory = {{"Скакалка", 550, 8}, {"Шлем", 3750, 4}, {"Мяч", 2900, 10}};
        System.out.println(mostExpensive(inventory));

        System.out.println("#8");
        System.out.println(longestUnique("abcba"));
        System.out.println(longestUnique("bbb"));

        System.out.println("#9");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));

        System.out.println("#10");
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));
    }

    public static boolean isStrangePair(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty()) {
            return true;
        }
        if (str1.length() > 0 && str2.length() > 0) {
            return str1.charAt(0) == str2.charAt(str2.length()-1) && str1.charAt(str1.length()-1) == str2.charAt(0);
        }
        return false;
    }

    public static Object[][] sale(Object[][] items, int discount) {
        for (Object[] item : items) {
            item[1] = (int) Math.max(1, Math.round((int)item[1] * (1 - discount*0.01)));
        }
        return items;
    }

    public static boolean sucsessShoot(int x, int y, int r, int m, int n) {
        return Math.sqrt(Math.pow(m-x, 2) + Math.pow(n-y, 2)) <= r;
    }

    public static boolean parityAnalysis(int x) {
        int isEven = x % 2;
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return isEven == sum % 2;
    }

    public static String rps(String item1, String item2) {
        HashMap<String, String> rules = new HashMap<>();
        rules.put("rock", "scissors");
        rules.put("paper", "rock");
        rules.put("scissors", "paper");
        if (item1.equals(item2)) {
            return "Tie";
        } else if (rules.get(item1).equals(item2)) {
            return "Player " + 1 + " wins";
        } else {
            return "Player " + 2 + " wins";
        }
    }

    public static int bugger(int x) {
        int cnt = 0;
        while (x >= 10) {
            int prod = 1;
            while (x > 0) {
                prod *= x % 10;
                x /= 10;
            }
            x = prod;
            cnt++;
        }
        return cnt;
    }

    public static String mostExpensive(Object[][] inventory) {
        int maxCost = 0;
        String maxName = "";
        for (Object[] item : inventory) {
            if ((int)item[1] * (int)item[2] > maxCost) {
                maxCost  = (int)item[1] * (int)item[2];
                maxName = (String)item[0];
            }
        }
        return "Наиб. общ. стоимость у предмета " + maxName + " - " + maxCost;
    }

    public static String longestUnique(String str) {
        int start = 0;
        int maxLength = 0;
        int maxStart = 0;
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            while (uniqueChars.contains(currentChar)) {
                uniqueChars.remove(str.charAt(start));
                start++;
            }
            uniqueChars.add(currentChar);
            if (i-start+1 > maxLength) {
                maxLength = i-start+1;
                maxStart = start;
            }
        }
        return str.substring(maxStart, maxStart + maxLength);
    }

    public static boolean isPrefix(String word, String prefix) {
        prefix = prefix.replace("-", "");
        return word.startsWith(prefix);
    }
    public static boolean isSuffix(String word, String suffix) {
        suffix = suffix.replace("-", "");
        return word.endsWith(suffix);
    }

    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (b <= w && a <= h) ||
               (b <= w && c <= h) || (c <= w && b <= h) ||
               (a <= w && c <= h) || (c <= w && a <= h);
    }
}
