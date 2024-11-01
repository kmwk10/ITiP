import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("#1");
        System.out.println(nonRepeat("abracadabra"));
        System.out.println(nonRepeat("abababcac"));

        System.out.println("#2");
        System.out.println(bruteForce(1, 5));
        System.out.println(bruteForce(2,2));
        System.out.println(bruteForce(5,3));

        System.out.println("#3");
        System.out.println(encode(new int[] {0, 31, 28, 10, 29},"MKIIT"));
        System.out.println(Arrays.toString(decode("MTUCI","MKIIT")));

        System.out.println("#4");
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));

        System.out.println("#5");
        System.out.println(shortHand("abbccc"));
        System.out.println(shortHand("vvvvaajaaaaa"));
        
        System.out.println("#6");
        System.out.println(convertToRome(8));
        System.out.println(convertToRome(1234));
        System.out.println(convertToRome(52));
        
        System.out.println("#7");
        System.out.println(uniqueSubstring("31312131"));
        System.out.println(uniqueSubstring("1111111"));
        System.out.println(uniqueSubstring("12223234333"));

        System.out.println("#8");
        System.out.println(Arrays.toString(labirint(new int[][] {{1, 3, 1}, {1, -1, 1}, {4, 2, 1}})));
        System.out.println(Arrays.toString(labirint(new int[][] {{2, -7, 3}, {-4, -1, 8}, {4, 5, 9}})));

        System.out.println("#9");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        
        System.out.println("#10");
        System.out.println(fibString("CCCABDD"));
        System.out.println(fibString("ABC"));
    }

    // #1
    public static String nonRepeat(String str) {
        str = str.toLowerCase();
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : str.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        String result = "";
        for (char c : str.toCharArray()) {
            if (counter.get(c) <= 3) {
                result += c;
            }
        }
        return result;
    }

    // #2
    public static List<String> bruteForce(int n, int k) {
        List<String> result = new ArrayList<>();
        if (n > k) {
            return result;
        }
        generateCombinations("", n, k, result);
        return result;
    }

    private static void generateCombinations(String current, int n, int k, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        for (int i = 0; i < k; i++) {
            String c = Integer.toString(i);
            if (!current.contains(c)) {
                generateCombinations(current + c, n, k, result);
            }
        }
    }


    // #3
    private static String encode(int[] arr, String key) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += (char) (arr[i] ^ key.charAt(i));
        }
        return result;
    }

    private static int[] decode(String str, String key) {
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) ^ key.charAt(i);
        }
        return arr;
    }

    // #4
    private static List<String> split(String str) {
        List<String> result = new ArrayList<>();
        int cnt = 0;
        String cluster = "";
        for (char c : str.toCharArray()) {
            cluster += c;
            cnt += (c == '(') ? 1 : -1;
            if (cnt == 0) {
                result.add(cluster);
                cluster = "";
            }
        }
        return result;
    }

    // #5
    private static String shortHand(String str) {
        String result = "";
        int cnt = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i+1 < str.length() && str.charAt(i) == str.charAt(i+1)) {
                cnt++;
            } else {
                result += str.charAt(i);
                if (cnt > 1) {
                    result += "*" + cnt;
                }
                cnt = 1;
            }
        }
        return result;
    }
    
    // #6
    private static String convertToRome(int x) {        
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String result = "";

        for (int i = 0; i < values.length; i++) {
            while (x >= values[i]) {
                x -= values[i];
                result += symbols[i];
            }
        }
        return result;
    }

    // #7
    public static String uniqueSubstring(String str) {
        int[] counter = new int[10];
        int[] indices = new int[10];
        for (int i = 0; i < str.length(); i++) {
            int x = str.charAt(i) - '0';
            counter[x] += 1;
            if (counter[x] == 1) {
                indices[x] = i % 2;
            }
        }
        int max = 0;
        int maxIndex = -1;
        for (int j = 0; j < 10; j++) {
            if (counter[j] > max) {
                max = counter[j];
                maxIndex = indices[j];
            }
        }
        return (maxIndex == 0) ? "чет" : "нечет"; 
    }
    
    // #8
    public static String[] labirint(int[][] map) {
        int n = map.length;
        int[][] cost = new int[n][n];
        String[][] path = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE / 2;
            }
        }

        cost[n-1][n-1] = map[n-1][n-1];
        path[n-1][n-1] = String.valueOf(map[n-1][n-1]);
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (map[i][j] < 0) {
                    continue;
                }

                if (i < n-1 && map[i+1][j] > 0) {
                    if (cost[i+1][j]+map[i][j] < cost[i][j]) {
                        cost[i][j] = cost[i+1][j]+map[i][j];
                        path[i][j] = path[i+1][j] + "-" + String.valueOf(map[i][j]);
                    }
                    
                }

                if (j < n-1 && map[i][j+1] > 0) {
                    if (cost[i][j+1]+map[i][j] < cost[i][j]) {
                        cost[i][j] = cost[i][j+1]+map[i][j];
                        path[i][j] = path[i][j+1] +  "-" + String.valueOf(map[i][j]);
                    }   
                }
            }
        }

        if (path[0][0] == null) {
            return new String[] {"Прохода нет"};
        }
        return new String[] {path[0][0], Integer.toString(cost[0][0])};
    };

    // #9
    public static String numericOrder(String str) {
        String[] arr = str.split(" ");
        String[] sort = new String[arr.length];
        for (String word : arr) {
            String newWord = "";
            String index = ""; 
            for (char c : word.toCharArray()) {
                if (Character.isDigit(c)) {
                    index += c;
                } else {
                    newWord += c;
                }
            }
            sort[Integer.parseInt(index)-1] = newWord;
        }
        return String.join(" ", sort);
    }

    // #10
    public static boolean fibString(String str) {
        if (str.length() <= 1) {
            return true;
        }

        HashMap<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (counter.containsKey(c)) {
                counter.put(c,  counter.get(c) + 1);
            } else {
                counter.put(c, 1);
            }
        }

        List<Integer> values = new ArrayList<Integer>(counter.values());
        Collections.sort(values);

        if (values.size() == 1 || values.get(0) != 1 && values.get(1) != 1 ) {
            return false;
        }

        for (int j = 0; j < values.size()-2; j++) {
            if (values.get(j) + values.get(j+1) != values.get(j+2)) {
                return false;
            }
        }
        return true;
    }
}
