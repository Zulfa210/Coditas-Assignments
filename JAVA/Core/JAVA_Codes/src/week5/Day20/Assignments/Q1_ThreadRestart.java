package week5.Day20.Assignments;

/**Q. 1)WHAT IF WE RESTART ANY THREAD?
 =>t1.start();
 =>t1.start()
 *
 *
 * @author Zulfa Attar
 */

class ThreadRestart extends Thread {

    public void run(){
        System.out.println("Started Running...");
    }
}
public class Q1_ThreadRestart {
    public static void main(String[] args) {
        ThreadRestart thread1 = new ThreadRestart();
        thread1.start();
        thread1.start();
    }
}

/*
After starting a thread, it can never be started again.
If you do so, an IllegalThreadStateException is thrown.
In such case, thread will run once but for second time, it will throw exception.
Also, once a thread enters dead state it cannot be restarted.

Output:
Exception in thread "main" java.lang.IllegalThreadStateException
	at java.lang.Thread.start(Thread.java:710)
	at week5.Day20.Assignments.Q1_ThreadRestart.main(Q1_ThreadRestart.java:17)
Started Running...

Process finished with exit code 1
 */