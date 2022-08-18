package Practice_Assignments.Loops_Exercise;

import java.util.Scanner;

/**
 * Q.1 Pictures pattern
 * Write a program that accepts an integer n and prints the following right triangle with
 * base and height n .
 * 1 	X
 * 2 	XX
 * 3 	XXX
 * …
 * n 	XXX…X ( n times)
 * @author Zulfa Attar
 */
class Pattern{
    void showPattern(int n){
        for(int i =0; i<n; i++){
            for(int j = 0; j<n ; j++){
                if(j<=i)
                    System.out.print("* ");
            }
            System.out.println();
        }

    }
}
public class Q1_PicturesPattern {


    public static void main(String[] args) {
        Pattern pattern = new Pattern();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the value of n: ");
        int n = scanner.nextInt();
        pattern.showPattern(n);
    }
}

/*
Output:
Enter the value of n:
8
*
* *
* * *
* * * *
* * * * *
* * * * * *
* * * * * * *
* * * * * * * *

Process finished with exit code 0
 */