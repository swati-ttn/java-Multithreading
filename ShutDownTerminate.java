package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ShutdownTerminate {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("School starting: " + Thread.currentThread().getName());
        try {
            executorService.submit(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(2000L);
                        System.out.println("Let's get Started");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            executorService.submit(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000L);
                        System.out.println("Let's get started again.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        } finally {
            executorService.shutdown();
        }
        System.out.println("School is Terminated (isTerminated()): " + executorService.isTerminated());
        System.out.println("School is ShutDown (isShutdown()): " + executorService.isShutdown());
    }
}

