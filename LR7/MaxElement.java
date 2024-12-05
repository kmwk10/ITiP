import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxElement {
    public static void main(String[] args) {
        int[][] matrix = {{1, 10, 3, 13},
                          {4, 11, 6, 14}, 
                          {7, 12, 9, 15},
                          {2, 5, 6, -10}};
        int numThreads = matrix.length;

        ExecutorService pool = Executors.newFixedThreadPool(numThreads);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            Callable<Integer> task = new ArrayMaxTask(matrix[i]);
            futures.add(pool.submit(task));
        }
        
        int max = matrix[0][0];
        for (Future<Integer> future : futures) {
            try {
                max = Math.max(max, future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();

        System.out.println("Maximum element: " + max);
    }
}

class ArrayMaxTask implements Callable<Integer> {
    private final int[] array;

    public ArrayMaxTask(int[] array) {
        this.array = array;
    }

    @Override
    public Integer call() {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
