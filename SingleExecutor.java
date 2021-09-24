package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleExecutor
{
    public static void main(String[] args)
    {
        ExecutorService exeService = Executors.newSingleThreadExecutor();
        System.out.println("Thread starting: " + Thread.currentThread().getName());
        try {
            exeService.submit(new Runnable()
            {
                @Override
                public void run() {
                    System.out.println("Thread 1 starting: " );
                }
            });
            exeService.submit(new Runnable()
            {
                @Override
                public void run() {
                    System.out.println("Thread 2 starting: ");
                }
            });
            exeService.submit(new Runnable()
            {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        System.out.println("Thread 3 Starting: ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        } finally {
            exeService.shutdown();
        }
    }
}
