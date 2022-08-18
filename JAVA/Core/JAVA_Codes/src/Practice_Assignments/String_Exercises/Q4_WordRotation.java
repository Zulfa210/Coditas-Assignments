package Practice_Assignments.String_Exercises;

import java.util.Scanner;

/**
 * Word Rotation
 * Write an application that accepts a string and an integer n as input, prints the string, rotates it n words to the right, and prints it again.
 * For example,
 * Input -
 * here is a good example for this 3
 * Output -
 * here is a good example for this
 * example for this here is a good
 * @author Zulfa Attar
 */

class WordRotation{
    void rotate(String input, int d){


        int space = 0;
        for(int i = 0; i<input.length() ; i++){
            if(input.charAt(i) == ' ')
                space++;
        }


       // System.out.println(space);
        String inputs[] = new String[space + 1];

        int n = inputs.length;
        inputs = input.split(" ");
        for(String s: inputs){
            System.out.print(s + " ");
        }
        String temp[] = new String[n-d];


        for (int i =0; i< n-d; i++){
            temp[i] = inputs[i];
        }

        int j =0;
        for(int i =n- d ; i<inputs.length; i++){
            inputs [j++] = inputs[i];
        }
        for(int i = 0; i< temp.length; i++){
            inputs[j++] = temp[i];
        }
        System.out.println();
        for(String s: inputs){
            System.out.print(s + " ");
        }



    }
}
public class Q4_WordRotation {
    public static void main(String[] args) {
        WordRotation wordRotation = new WordRotation();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the String");
        String inputString = scanner.nextLine();

        System.out.println("Enter no. of words to rotate: ");
        int noOfWords = scanner.nextInt();

        wordRotation.rotate(inputString, noOfWords);
    }
}

/*
Output:
Enter the String
here is a good example for this
Enter no. of words to rotate:
3
here is a good example for this
example for this here is a good
Process finished with exit code 0

 */