package multithreading;

import java.util.Date;

public class WaitNotifyAll {
    public static void main(String[] args) {
        System.out.println("Session Starting: " + Thread.currentThread().getName());
        SeniorSchool coordination = new SeniorSchool();
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
        Thread c3 = new Thread(new Runnable() {
            @Override
            public void run() {
                coordination.Session3();
            }
        });
        Thread c4 = new Thread(new Runnable() {
            @Override
            public void run() {
                coordination.Session4();
            }
        });
        c1.start();
        c2.start();
        c3.start();
        c4.start();

        System.out.println("Session Over: " + new Date());
    }
}

class SeniorSchool
{
    void Session1()
    {
        synchronized (this) {
            System.out.println("Session 1 Working");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" Session 1 OVER" + new Date());
    }

    void Session2() {
        synchronized (this) {
            System.out.println(" Session 2 Working");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" Session 2 Over" + new Date());
    }
    void Session3() {
        synchronized (this) {
            System.out.println(" Session 3 Working");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" Session 3 Over" + new Date());
    }
    void Session4() {
        synchronized (this) {
            System.out.println(" Session 4 Working");
            notifyAll();
        }
        System.out.println(" Session 4 Over" + new Date());
    }
}


