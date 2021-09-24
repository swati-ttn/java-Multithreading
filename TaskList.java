package multithreading;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TaskList
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Thread starting: " + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            List<Callable<Integer>> callableList = new ArrayList<>();
            callableList.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(800);
                    return 1;
                }
            });
            callableList.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(1000);
                    return 2;
                }
            });
            callableList.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(2000);
                    return 3;
                }
            });

           List<Future<Integer>> intFutureList = executorService.invokeAll(callableList);

            for (Future<Integer> f : intFutureList) {
                if (f.isDone()) {
                    try {
                        System.out.println("Line no. " + f.get().toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        finally {
            executorService.shutdown();
        }
        executorService.awaitTermination(1000L, TimeUnit.SECONDS);
        System.out.println("Lines printed after maximum Time taken 2000ms: ");
    }
}
