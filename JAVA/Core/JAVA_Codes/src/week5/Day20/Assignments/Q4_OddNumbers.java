package week5.Day20.Assignments;

import java.util.Scanner;

/**
 * Q.4 USE THE RUNNABLE INTERFACE TO CONVERT THE FOLLOWING CLASS INTO A
 * THREAD.YOU WANT THE THREAD TO PRINT ALL THE ODD NUMBERS U TO ITS BOUND.
 * @author Zulfa Attar
 */
class OddNumbers implements Runnable{

    @Override
    public void run() {
        System.out.println("Running Thread name: "+ Thread.currentThread().getName());
        printOddNumbers();
    }
    void printOddNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bound: ");
        int u = scanner.nextInt();
        System.out.println("Printing Odd Numbers upto "+ u);
        for (int i = 0; i<= u; i++){
            if( i % 2 != 0){
                System.out.println(i + " ");
            }
        }
    }
}
public class Q4_OddNumbers {
    public static void main(String[] args) {
        OddNumbers object =new OddNumbers();
        Thread thread = new Thread(object);
        thread.start();
    }
}
