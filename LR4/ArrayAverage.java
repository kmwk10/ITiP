public class ArrayAverage {
    public static void main(String[] args) {
        Object[] arr1 = {1, 2, 3, 4, 5};
        Object[] arr2 = {};
        Object[] arr3 = {"12", "22"};
        
        System.out.println(getAverage(arr1));
        System.out.println(getAverage(arr2));
        System.out.println(getAverage(arr3));
    }

    public static String getAverage(Object[] arr) {
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                sum += (int) arr[i];
            }
            return("Average: " + sum/arr.length);
        } catch (ArithmeticException e1) {
            return("Error: Cannot find average in empty array");
        } catch (ClassCastException e2) {
            return("Error: Array element is not integer");
        }
    }
}
