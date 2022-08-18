package Practice_Assignments.String_Exercises;

import java.util.Scanner;

/**
 * Q.1 String Rotation
 * Write a program that rotates a given string n characters to the right. For example, if the input to your program is rotatemeplease 4,
 * then the output is easerotatemepl
 * @author Zulfa Attar
 */

class StringRotation{
    void rotate(String string1, int d){
        int n = string1.length() ;
        string1 = string1.substring(n - d, n) + string1.substring(0, n-d );
        System.out.println(string1);
    }

}

public class Q1_StringRotation {
    public static void main(String[] args) {

        StringRotation stringRotation = new StringRotation();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the String: ");
        String string1 = scanner.next();

        System.out.println("Enter the no. of Characters to be Rotated: ");
        int noOfCharacters = scanner.nextInt();

        stringRotation.rotate(string1, noOfCharacters);

    }

}
/*
Output:
Enter the String:
ZulfaAttar
Enter the no. of Characters to be Rotated:
2
arZulfaAtt

Process finished with exit code 0
 */