package multithreading;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTask
{
    public static void main(String[] args)
    {
        System.out.println("Workers working: " + Thread.currentThread().getName());

        ScheduledExecutorService service1 = Executors.newSingleThreadScheduledExecutor();
        service1.schedule(new Runnable()
        {
            @Override
            public void run() {
                System.out.println(" Worker1 ((Scheduled Task)) : " +new Date());
            }
        }, 1,TimeUnit.SECONDS);

        ScheduledExecutorService service2 = Executors.newSingleThreadScheduledExecutor();
        service2.scheduleAtFixedRate(new Runnable()
        {
            @Override
            public void run() {
                System.out.println("Worker2 ((Scheduled at fixed rate)) : " + new Date());
            }
        }, 1,1, TimeUnit.SECONDS);


        ScheduledExecutorService service3 = Executors.newSingleThreadScheduledExecutor();
        service3.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("Worker3 ((Scheduled with fixed delay))  : " + new Date());
            }
        }, 1, 1, TimeUnit.SECONDS);

        System.out.println("Data Ending: " + Thread.currentThread().getName());
        // service2.shutdown();
        //service3.shutdown();
    }

}
