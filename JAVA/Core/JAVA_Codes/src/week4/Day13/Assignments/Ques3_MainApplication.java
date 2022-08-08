package week4.Day13.Assignments;

/**Q.3)public class ABC
 public static void main(String[] args) {
 int[] array = new int[1o]; int sum = 0;
 // good code
 for (int i =0; i< array.length; i++){
 sum = sum + array[i];
 Try it for conditions =>1)i< 10
 =>2)i<11

 @author Zulfa Attar-Coditas
 *
 */
public class Ques3_MainApplication {

    public static void main(String[] args) {

        try {
            int[] array = new int[10];
            int sum = 0;
            //for i<10
            for (int i = 0; i < 10; i++) {
                sum = sum + array[i];
            }
            System.out.println("Executed Successfully for i<10");

            int[] array2 = new int[10];
            int sum2 = 0;
            //for i<11, this will throw ArrayIndexOutOfBound Exception because
            //array2 has only 10 elements
            for (int i = 0; i < 11; i++) {
                sum2 = sum2 + array2[i];
            }
            System.out.println("Executed Successfully for i<11");
        }
        catch (Exception e){
            System.out.println("========================================================");
            System.out.println("Exception class: " + e.getClass());
            System.out.println("Message: " + e.getMessage());

        }
        finally {
            System.out.println("====================END=====================");
        }
    }
}

/*
Output:
Executed Successfully for i<10
========================================================
Exception class: class java.lang.ArrayIndexOutOfBoundsException
Message: 10
====================END=====================

Process finished with exit code 0
 */