import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.List;
import java.util.ArrayList;

public class Sum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numThreads = 3;
        int chunkSize = array.length / numThreads;

        ExecutorService pool = Executors.newFixedThreadPool(numThreads);
        List<Future<Integer>> futures = new ArrayList<>();
        
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads-1) ? array.length : start + chunkSize;
            Callable<Integer> task = new ArraySumTask(array, start, end);
            futures.add(pool.submit(task));
        }
        
        int totalSum = 0;
        for (Future<Integer> future : futures) {
            try {
                totalSum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();

        System.out.println("Total Sum: " + totalSum);
    }
}

class ArraySumTask implements Callable<Integer> {
    private final int[] array;
    private final int start;
    private final int end;

    public ArraySumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
