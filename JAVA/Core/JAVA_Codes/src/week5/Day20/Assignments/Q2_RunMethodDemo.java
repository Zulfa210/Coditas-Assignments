package week5.Day20.Assignments;

/**
 * Q.2 WHAT IF WE CALL run() EXPLICITLY?
 *
 *
 * @author Zulfa Attar
 */
class ThreadStart extends Thread{
    public void run(){
        System.out.println("Running in: "+ Thread.currentThread().getName());
    }
}
public class Q2_RunMethodDemo {
    public static void main(String[] args) {
        ThreadStart thread1 =new ThreadStart();
        ThreadStart thread2 = new ThreadStart();


        System.out.println("----------Thread without explicitly calling run-----------");
        thread1.start();


        System.out.println("----------Thread with explicitly calling run--------------");
       // thread2.start();
        thread2.run();


    }
}

/*
When we call run method directly then it acts as a normal method
and main method itself will execute the run method , hence no multi threading occurs.

Output:
----------Thread without explicitly calling run-----------
----------Thread with explicitly calling run--------------
Running in: main
Running in: Thread-0

Process finished with exit code 0
 */