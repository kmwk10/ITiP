import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("#1");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println("#2");
        System.out.println(memeSum(26, 39));
        System.out.println(memeSum(122, 81));
        System.out.println(memeSum(1222, 30277));

        System.out.println("#3");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));

        System.out.println("#4");
        System.out.println(totalPoints(new String[] {"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[] {"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[] {"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        
        System.out.println("#5");
        System.out.println(longestRun(new int[] {1, 2, 3, 5, 6, 7, 8, 9}));
        System.out.println(longestRun(new int[] {1, 2, 3, 10, 11, 15}));
        System.out.println(longestRun(new int[] {5, 4, 2, 1}));
        System.out.println(longestRun(new int[] {13, 5, 7, 10, 15}));

        System.out.println("#6");
        System.out.println(takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[] {"10%"}));
        System.out.println(takeDownAverage(new String[] {"53%", "79%"}));

        System.out.println("#7");
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));

        System.out.println("#8");
        System.out.println(maxPossible(523, 76));
        System.out.println(maxPossible(9132, 5564));
        System.out.println(maxPossible(8732, 91255));

        System.out.println("#9");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        
        System.out.println("#10");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }   

    // #1
    public static boolean sameLetterPattern(String str1, String str2) {
        Map<Character, Character> pattern = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (pattern.containsKey(str1.charAt(i)) && pattern.get(str1.charAt(i)) != str2.charAt(i)) {
                return false;
            } else {
                pattern.put(str1.charAt(i), str2.charAt(i));
            }
        }
        return true;
    }

    // #2
    public static int memeSum(int a, int b) {
        List<Integer> nums = new ArrayList<>();
        while (a > 0 || b > 0) {
            nums.add(a%10 + b%10);
            a /= 10;
            b /= 10;
        }

        String sum = "";
        for (int i = nums.size()-1; i >= 0; i--) {
            sum += String.valueOf(nums.get(i));
        }
        return Integer.parseInt(sum);
    }


    // #3
    public static long digitsCount(long x) {
        return digitsCount(x/10, 1);
    }

    public static long digitsCount(long x, long cnt) {
        if (x == 0) {
            return cnt;
        }
        return digitsCount(x/10, cnt+1);
    }

    // #4
    public static int totalPoints(String[] words, String decoded) {
        Map<Character, Integer> charCnt = new HashMap<>();
        for (char c : decoded.toCharArray()) {
            charCnt.put(c, charCnt.getOrDefault(c+1, 1));
        }

        int points = 0;
        for (String word : words) {
            Map<Character, Integer> charCntCopy = new HashMap<>(charCnt);
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (!charCntCopy.containsKey(c) || charCntCopy.get(c) == 0) {
                    flag = false;
                    break;
                } else {
                    charCntCopy.put(c, charCnt.get(c)-1);
                }
            }
            if (flag) {
                points += word.length()-2;
                if (word.length() == 6) {
                    points += 50;
                }
            }
        }
        return points;
    }

    // #5
    public static int longestRun(int[] arr) {
        int term = 1;
        int cnt = 1;
        int maxCnt = 1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] + 1 == arr[i+1] && term == 1) {
                cnt++;
            } else if (arr[i] - 1 == arr[i+1] && term == -1) {
                cnt++;
            } else if (arr[i] + 1 == arr[i+1] && term == -1) {
                cnt = 2;
                term = 1;
            } else if (arr[i] - 1 == arr[i+1] && term == 1) {
                cnt = 2;
                term = -1;
            } else {
                cnt = 1;
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        return maxCnt;
    }

    // #6
    public static String takeDownAverage(String[] points) {
        int sum = 0;
        for (String x : points) {
            sum += Integer.parseInt(x.replace("%", ""));
        }
        double cnt = points.length;
        return (int)Math.round((cnt + 1)*(sum/cnt - 5) - sum) + "%";
    }

    // #7
    public static boolean canMove(String name, String pos1, String pos2) {
        if (pos1.equals(pos2)) {
            return false;
        }

        int x1 = pos1.charAt(0)-64;
        int y1 = pos1.charAt(1)-'0';
        int x2 = pos2.charAt(0)-64;
        int y2 = pos2.charAt(1)-'0';

        if (x1 > 8 || x1 < 1 || x2 > 8 || x2 < 1 || y1 > 8 || y1 < 1 || y2 > 8 || y2 < 1) {
            return false;
        }

        switch (name) {
            case "Pawn": // пешка
                return (y2-y1 == 1 || y2-y1 == 2) && x1 == x2;
            case "Knight": // конь
                return (Math.abs(x1-x2) == 2 && Math.abs(y1-y2) == 1) || (Math.abs(x1-x2) == 1 && Math.abs(y1-y2) == 2);
            case "Bishop": // слон
                return Math.abs(x1-x2) == Math.abs(y1-y2);
            case "Rook": // ладья
                return x1 == x2 || y1 == y2;
            case "Queen": // ферзь
                return Math.abs(x1-x2) == Math.abs(y1-y2) || x1 == x2 || y1 == y2;
            case "King": // король
                return Math.abs(x1-x2) >= 0 && Math.abs(y1-y2) >= 0;
            default:
                return false;
        }
    }

    // #8
    public static int maxPossible(int a, int b) {
        char[] charsA = String.valueOf(a).toCharArray();
        char[] charsB = String.valueOf(b).toCharArray();
        Arrays.sort(charsB);
        String result = "";
        for (char charA : charsA) {
            boolean flag = true;
            for (int i = charsB.length-1; i >= 0; i--) {
                if (charA < charsB[i]) {
                    result += charsB[i]-'0';
                    charsB[i] = '0';
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result += charA;
            }
        }
        return Integer.parseInt(result);
    }

    // #9
    public static String timeDifference(String cityA, String timestamp, String cityB) {
        Map<String, Integer> GMT = new HashMap<>();
        GMT.put("Los Angeles", -480);
        GMT.put("New York", -300);
        GMT.put("Caracas", -270);
        GMT.put("Buenos Aires", 180);
        GMT.put("London", 0);
        GMT.put("Rome", 60);
        GMT.put("Moscow", 180);
        GMT.put("Tehran", 210);
        GMT.put("New Delhi", 330);
        GMT.put("Beijing", 480);
        GMT.put("Canberra", 600);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.ENGLISH);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
        
        LocalDateTime date = LocalDateTime.parse(timestamp, formatter1);
        LocalDateTime newDate = date.plusMinutes(GMT.get(cityB)-GMT.get(cityA));

        return formatter2.format(newDate);
    }

    // #10
    public static boolean isNew(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        Arrays.sort(chars);
        String zeros = "";
        String minNum = "";
        for (char c : chars) {
            if (c == '0') {
                zeros += '0';
            } else {
                minNum += c;
            }
        }
        minNum = minNum.substring(0,1) + zeros + minNum.substring(1);
        return x <= Integer.parseInt(minNum);
    }
}
