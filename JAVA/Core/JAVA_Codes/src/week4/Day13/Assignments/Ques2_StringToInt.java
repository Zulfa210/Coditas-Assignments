package week4.Day13.Assignments;
/**
 * Q.2) Try to add String data in Numeric data type then handle this exception
 *
 * @author Zulfa Attar-Coditas
 */

import java.util.Scanner;

public class Ques2_StringToInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a value: ");
        String check = scanner.next();

        try{
            //parsing String value in integer will throw an exception
            int a  = Integer.parseInt(check);
        }
        catch (Exception e){
            System.out.println("=========================================");
            System.out.println("Exception class: " + e.getClass());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Please Enter Integer Value");
        }
        finally {
            System.out.println("==================END======================");
        }
    }
}

/*
Output:
Enter a value:
Hello
=========================================
Exception class: class java.lang.NpumberFormatExcetion
Message: For input string: "Hello"
Please Enter Integer Value
==================END======================

Process finished with exit code 0
 */