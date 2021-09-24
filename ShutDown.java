package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ShutDown {
    public static void main(String[] args) {
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        ExecutorService exeService = Executors.newSingleThreadExecutor();
        try {
            exeService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        System.out.println("Machine started");
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            exeService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000L);
                        System.out.println("Processor started: " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        finally {
           exeService.shutdown();
         //  executorService.shutdownNow();// java.lang.InterruptedException: sleep interrupted//
        }
    }
}
