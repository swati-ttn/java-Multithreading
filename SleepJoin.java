package multithreading;


public class SleepJoin {
    public static void main(String[] args) {
        System.out.println("Thread starting: " + Thread.currentThread().getName());
        Thread C1 = new A();
        Thread C2 = new Thread(new B());
        C1.start();
        C2.start();
        try {
            C2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread exiting: " + Thread.currentThread().getName());
    }
}
class A extends Thread {
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Extended from Thread: " + this.getName());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

class B implements Runnable {
    public void run() {
        try {
            Thread.sleep(4000);
            System.out.println("Implementing Runnable: " + Thread.currentThread().getName());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

