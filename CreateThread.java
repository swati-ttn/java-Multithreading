package multithreading;
public class CreateThread
{
    public static void main(String[] args)
    {
        new ThreadClass().start();
        new Thread(new ThreadClass2()).start();
    }
}

class ThreadClass extends Thread
{
    @Override
    public void run() {
        System.out.println("Thread created by Thread class");
    }
}

class ThreadClass2 implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("Thread created by Runnable class");
    }
}
