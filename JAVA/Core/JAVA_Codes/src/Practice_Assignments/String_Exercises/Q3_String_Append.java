package Practice_Assignments.String_Exercises;

import java.util.Locale;
import java.util.Scanner;

/**
 * Q.3 Create a program to append a string
 * Get the third character of each string from given string array
 * If the third character not present append '$' and return the output in upper case
 *
 * Sample input -> String input[]={"akash","pavan","ac","satish","ram","go"};
 * Expected Output -> "AV$TM$”
 * @author Zulfa Attar
 */

class String_Append{
    void appendString(String[] input){

        String output = "";

        for(int i = 0; i < input.length; i++){
            if(input[i].length() >= 3)
                output = output + input[i].charAt(2);
            else
                output = output + '$';
        }
        System.out.println("\nOutput: " + output.toUpperCase(Locale.ROOT));
    }

}
public class Q3_String_Append {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input[];
        //= {"akash","pavan","ac","satish","ram","go"};
        System.out.println("Enter the no. of Strings: ");
        int n = scanner.nextInt();
        input = new String[n];
        System.out.println("Enter the Strings: ");
        for (int i = 0; i<n ; i++)
            input[i] = scanner.next();

        new String_Append().appendString(input);
    }
}

/*
Output:
Enter the no. of Strings:
5
Enter the Strings:
Zulfa
Attar
Hi
Sid
Yo

Output: LT$D$


Process finished with exit code 0

 */