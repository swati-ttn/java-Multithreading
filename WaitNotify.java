package multithreading;

import java.util.Date;

public class WaitNotify {
    public static void main(String[] args) {
        System.out.println("Session Starting: " + Thread.currentThread().getName());
        School coordination = new School();
        Thread c1 = new Thread(new Runnable() {
            @Override
            public void run() {
                coordination.Session1();
            }
        });
        Thread c2 = new Thread(new Runnable() {
            @Override
            public void run() {
                coordination.Session2();
            }
        });
        c1.start();
        c2.start();
        System.out.println("Session Over: " + new Date());
    }
}

class School
{
    public void Session1()
    {
        synchronized (this) {
            System.out.println("Session 1 Working");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Session 1 OVER" + new Date());
    }

    public void Session2() {
        synchronized (this) {
            System.out.println("Session 2 Working");
            notify();
        }
        System.out.println("Session 2 Over" + new Date());
    }
}


