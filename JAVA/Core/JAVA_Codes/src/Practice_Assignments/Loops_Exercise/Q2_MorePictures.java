package Practice_Assignments.Loops_Exercise;

import java.util.Scanner;

/**Q.2 More Pictures
 Write a program that accepts an integer n and prints the following picture of a
 diamond with 2n−1 rows.
 1 		X
 2 	   XXX
 3	  XXXXX
 …
 n 	 XXX … X (2 n  1 times)
 …
     XXXXX
      XXX
 2n-1  X

 *
 * @author Zulfa Attar
 */
class PicturePattern{
    public void showPattern(int n){

        for(int i =0; i<n ; i++){
            for(int j = 0 ; j< 2*n; j++){

                if(j>=n-1-i && j<=n-1+i){
                    System.out.print("*");
                }
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        for (int i =0; i<n; i++){
            for(int j = 0; j<2*n -2; j++){
                if(j > i  && j< 2*n-2-i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

    }
}
public class Q2_MorePictures {


    public static void main(String[] args) {
        PicturePattern pattern = new PicturePattern();
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
      ***
     *****
    *******
   *********
  ***********
 *************
***************
 *************
  ***********
   *********
    *******
     *****
      ***
       *


Process finished with exit code 0

 */