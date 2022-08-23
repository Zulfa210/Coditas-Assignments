package week5.Day20.Assignments;

/**
 * Q.3)WRITE A PROGRAM OF 3THREAD OBJECTS USING Runnable INTERFACE.
 * TRY TO ACCESS ALL THE METHODS OF Thread CLASS.
 *
 * @author Zulfa Attar
 */

class RunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Executing run() method in " + Thread.currentThread() );
    }
}

public class Q3_RunnableDemo {
    public static void main(String[] args) {

        RunnableThread runnableThread = new RunnableThread();
        Thread thread =new Thread(runnableThread);
        thread.start();

        System.out.println("Name of Thread: " + thread.getName());
        System.out.println("State of Thread: " + thread.getState());


    }
}

/*
Output:
Executing run() method in Thread[Thread-0,5,main]

Process finished with exit code 0
 */