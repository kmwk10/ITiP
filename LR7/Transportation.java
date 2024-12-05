import java.util.*;
import java.util.concurrent.*;

public class Transportation {
    public static void main(String[] args) {
        List<Integer> storage1 = new ArrayList<>(Arrays.asList(10, 30, 5, 14, 8, 12, 17, 19, 42, 31, 5, 13, 45, 18, 22, 33, 28, 11, 5, 2, 16, 20, 7, 14, 6, 2, 3));
        List<Integer> storage2 = new ArrayList<>();

        int numThreads = 3;

        ExecutorService pool = Executors.newFixedThreadPool(numThreads);
        CompletionService<List<Integer>> completion = new ExecutorCompletionService<>(pool);

        for (int i = 0; i < numThreads; i++) {
            Callable<List<Integer>> task = new LoaderTask(storage1);
            completion.submit(task);
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                List<Integer> loaderGoods = completion.take().get();
                storage2.addAll(loaderGoods);
                System.out.println("Loader goods " + (i+1) + ": " + loaderGoods);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();
        
        System.out.println("Storage 2: " + storage2);
    }
}

class LoaderTask implements Callable<List<Integer>> {
    private final List<Integer> storage1;

    public LoaderTask(List<Integer> storage1) {
        this.storage1 = storage1;
    }

    @Override
    public List<Integer> call() {
        List<Integer> goods = new ArrayList<>();
        int weight = 0;
        synchronized (storage1) {
            for (int i = 0; i < storage1.size(); i++) {
                if (storage1.isEmpty()) {
                    break;
                }
                if (weight + storage1.get(i) <= 150) {
                    goods.add(storage1.get(i));
                    weight += storage1.remove(i--);
                }
            }
        }
        return goods;
    }
}
