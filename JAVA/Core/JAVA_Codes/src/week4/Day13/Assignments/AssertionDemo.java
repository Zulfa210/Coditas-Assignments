package week4.Day13.Assignments;
/**\
 * Q1)Check about the concept of Assertion?
 */

import java.util.Scanner;

public class AssertionDemo {
    public static void main(String[] args) {
        int age;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your Age: ");
        age = sc.nextInt();
        assert age <= 100 : "Age is too large";
        System.out.println("age is " + age);
    }
}

/*
Output:
Enter your Age:
900
Exception in thread "main" java.lang.AssertionError: Age is too large
	at week4.Day13.Assignments.AssertionDemo.main(AssertionDemo.java:15)

Process finished with exit code 1
 */