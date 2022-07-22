package week1.day3.Assignments;

import java.util.Scanner;

public class Q5_Greatest_Values {

    public void check_greatest(int num1, int num2){

        if(num1 > num2)
            System.out.println("Number1 is greater than Number2");
        else
            System.out.println("Number2 is greater than Number1");
    }


    public static void main(String[] args) {
        Q5_Greatest_Values object1 = new Q5_Greatest_Values();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter two numbers: ");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();

        object1.check_greatest(number1, number2);


    }
}
//Output:
//        Enter two numbers:
//        10
//        21
//        Number2 is greater than Number1