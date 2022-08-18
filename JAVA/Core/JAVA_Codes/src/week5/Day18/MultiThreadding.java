package week5.Day18;

/**
 * Thread class is
 * Runnable: ready to  run
 * Can we change the priority of main method?
 * Can setting the priority guarantee the priority execution?
 *
 * If you set Deamon after starting it's execution, Illegal ThreadState Exception occurs
 * If you a start the same thread twice
 *
 * When you call run method explicitly what happens internally.
 *
 *
 * @author Zulfa Attar
 */

class ThreadDemo extends Thread{
    public void run(){
        for(int i =0; i<5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread " + Thread.currentThread());
        }
    }
}
public class MultiThreadding {
    public static void main(String[] args) throws InterruptedException {

        ThreadDemo threadDemo = new ThreadDemo();
        //threadDemo.display();

        threadDemo.setName("A");
       // threadDemo.run();

        ThreadDemo threadDemo1 = new ThreadDemo();
        threadDemo1.setName("B");

        threadDemo.setPriority(1);
        threadDemo1.setPriority(10);

        threadDemo.getState();
        threadDemo.start();
        threadDemo1.start();
        threadDemo.join();


    }
}
