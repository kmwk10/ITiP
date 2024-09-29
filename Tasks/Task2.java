import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("#1");
        System.out.println(duplicateChars("Barack", "Obama"));
        System.out.println("#2");
        System.out.println(dividedByThree(new int[] {3, 12, 7, 81, 52}));
        System.out.println("#3");
        System.out.println(getInitials("simonov sergei evgenievich"));
        System.out.println(getInitials("kozhevnikova tatiana vitalevna"));
        System.out.println("#4");
        System.out.println(Arrays.toString(normalizator(new double[] {3.5, 7.0, 1.5, 9.0, 5.5})));
        System.out.println(Arrays.toString(normalizator(new double[] {10.0, 10.0, 10.0, 10.0})));
        System.out.println("#5");
        System.out.println(Arrays.toString(compressedNums(new double[] {1.6, 0, 212.3, 34.8, 0, 27.5})));
        System.out.println("#6");
        System.out.println(camelToSnake("helloWorld"));
        System.out.println("#7");
        System.out.println(secondBiggest(new int[] {3, 5, 8, 1, 2, 4}));
        System.out.println("#8");
        System.out.println(localReverse("baobab", 'b'));
        System.out.println(localReverse("Hello, I\'m under the water, please help me", 'e'));
        System.out.println("#9");
        System.out.println(equal(8, 1, 8));
        System.out.println(equal(5, 5, 5));
        System.out.println(equal(4, 9, 6));
        System.out.println("#10");
        System.out.println(isAnagram("LISTEN", "silent"));
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
        System.out.println(isAnagram("hello", "world"));
        
    }

    public static String duplicateChars(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        String result = "";
        for (char c : str1.toCharArray()) {
            if (str2.indexOf(c) == -1) {
                result += c;
            }
        }
        return result;
    }

    public static int dividedByThree(int[] numbers) {
        int cnt = 0;
        for (int x : numbers) {
            if (x % 2 == 1 && x % 3 == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static String getInitials(String fullName) {
        String[] arr = fullName.split(" ");
        String initials = (arr[1].charAt(0) + "." + arr[2].charAt(0) + ".").toUpperCase();
        String surname = arr[0].substring(0, 1).toUpperCase() + arr[0].substring(1);
        return initials+" "+surname;
    }

    public static double[] normalizator(double[] arr) {
        double max = arr[0]; 
        double min = arr[0];
        for (double x : arr) {
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
        }
        if (min == max) {
            return new double[arr.length];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i]-min)/(max-min);
        }
        return arr;
    }

    public static int[] compressedNums(double[] arr) {
        int len = 0;
        for (double x : arr) {
            if (x != 0) {
                len++;
            }
        }
        int[] result = new int[len];
        int i = 0;
        for (double x : arr) {
            if (x != 0) {
                result[i] = (int) x;
                i++;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public static String camelToSnake(String str) {
        String result = "";
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result += "_" + Character.toLowerCase(c);
            } else {
                result += c;
            }
        }
        return result;
    }

    public static int secondBiggest(int[] arr) {
        int max1 = arr[0];
        int max2 = arr[0];
        for (int i = 1; i < arr.length; i++) { 
            if (arr[i] > max1) { 
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2) {
                max2 = arr[i];
            }
        }
        return max2;
    }

    public static String localReverse(String str, char marker) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i);
            if (str.charAt(i) == marker && i != str.length()-1) {
                int tempLen = 1;
                while (str.charAt(i+tempLen) != marker) {
                    tempLen++;
                }
                String temp = str.substring(i+1, i+tempLen);
                String reversed = "";
                for (int j = temp.length()-1; j >= 0; j--) {
                    reversed += temp.charAt(j);
                }
                result += reversed+marker;
                i += tempLen;
            }
        }
        return result;
    }

    public static int equal(int a, int b, int c) {
        return (a == b && b == c) ? 3 : (a == b || b == c || c == a) ? 2 : 0;
    }
    
    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for (char c : str1.toCharArray()) {
            if (Character.isLetter(c) && str2.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
}