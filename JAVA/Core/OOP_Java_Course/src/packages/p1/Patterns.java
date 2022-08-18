package packages.p1;

/**
 * @author Zulfa Attar
 */
public class Patterns {
    void pattern1(){
        int n = 5;
        int k = 1;
        for(int i =0; i<n; i++ ){
            for(int j = 0; j <2*n; j++){

                if(j>=4-i && j<=4+i && k==1) {
                    System.out.print("*");
                    k = 0;
                }
                else {
                    System.out.print(" ");
                    k = 1;
                }

            }
            System.out.println();
        }

/*
    *
   * *
  * * *
 * * * *
* * * * *

Process finished with exit code 0

*/
    }

    void pattern2() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j >= 4 - i) {
                    System.out.print("* ");
                } else
                    System.out.print("  ");
            }
            System.out.println();
        }

        /*
        Output:
         *
         * *
         * * *
         * * * *
         * * * * *

         */
    }
    void pattern3(){

        for(int i =0; i<5 ; i++){
            for(int j = 0 ; j< 10; j++){

                if(j>=4-i && j<=4+i){
                    System.out.print("*");
                }
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        for (int i =0; i<5; i++){
            for(int j = 0; j<8; j++){
                if(j > i  && j< 8-i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        String  s ="";

        /*Output:

         *
        ***
       *****
      *******
     *********
      *******
       *****
        ***
         *

         */
    }

    void pattern4(){
        for(int i =0; i<=5 ; i++){
            for (int j = 0; j<i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i =4; i>0 ; i--){
            for (int j = 0; j<i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
/*
output:
 *
 * *
 * * *
 * * * *
 * * * * *
 * * * *
 * * *
 * *
 *

 */
    }

    void pattern5(){

        for(int  i = 0; i< 6; i++){
            for(int j = 0; j<7; j++){
                if(j<=5-i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
/*
      *
     **
    ***
   ****
  *****
 ******
 */
    }

    void pattern6(){
        int k =1;
        for(int i = 0; i<5; i++){
            for(int j= 0; j<10; j++){
                if(j>i && j<10-i && k==1)
                {
                    System.out.print("*");
                    k=0;
                }
                else{
                    System.out.print(" ");
                    k=1;
                }
            }
            System.out.println();
        }
/*
Output:
 * * * * *
  * * * *
   * * *
    * *
     *

 */
    }

    void pattern7(){

        for(int i =0 ; i<5; i++){
            for(int j =0; j<5 ; j++){
                if(j>=i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
/*
 *****
  ****
   ***
    **
     *
 */
    }

    void pattern8(){

        for(int i =0 ; i<5; i++){
            for (int j =0; j<5; j++){
                if(j>=5-i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }for(int i =0 ; i<5; i++){
            for (int j =0; j<5; j++){
                if(j>=i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
/*
Ouput:
    *
   **
  ***
 ****
*****
 ****
  ***
   **
    *

 */
    }


    public static void main(String[] args) {

Patterns patterns = new Patterns();
patterns.pattern8();

    }
}
