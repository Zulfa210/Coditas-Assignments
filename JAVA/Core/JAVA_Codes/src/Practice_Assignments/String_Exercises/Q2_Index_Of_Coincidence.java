package Practice_Assignments.String_Exercises;

import java.util.Scanner;

/**Q.2 Index of Coincidence
 If two strings of equal length are superimposed on one another, then some letters
 may match. For example consider the strings “wonderwhowrot ethebookonlov e” and “weallliveinay ellowsubmarin e”.
 Notice that there are three positions that contain the same letter: the 1 st (w) , 14 th (e), and 27 th (e). Of 27 possible positions, matches occur in three positions (11.1%). This percentage is called the index of coincidence for two strings, and it is used to decrypt ciphers like those used by the Germans in World War II. Write a program that accepts two strings of the same length and determines their
 index of coincidence.

 *
 * @author Zulfa Attar
 */
class Index_Of_Coincidence{
    void check(String a, String b){
        float count = 0;
        float n = 0;
        int flag = 0;
        if(a.length() == b.length()){
            for (int i =0 ; i < a.length(); i++){
                if(a.charAt(i) == ' '){
                    if(b.charAt(i) == ' ')
                        continue;
                    else {
                        flag = 1;
                        System.out.println("Spaces should be at same locations");
                    }
                }
            }

            if(flag != 1) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != ' ') {
                        n++;
                        if (a.charAt(i) == b.charAt(i)) {
                            count++;
                        }
                    }
                }
                float percent = (count / n) * 100;
                System.out.println("Total no. of Characters: " + n);
                System.out.println("Total positions with same character: " + count);
                System.out.println("Index of Coincidence: " + percent);
            }

        }else
            System.out.println("Length of Strings is not Equal");

    }
}
public class Q2_Index_Of_Coincidence {
    public static void main(String[] args) {
        Index_Of_Coincidence object = new Index_Of_Coincidence();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter String 1: ");
        String string1 = scanner.nextLine();

        System.out.println("Enter String 2: ");
        String string2 = scanner.nextLine();

        object.check(string1, string2);

    }
}

/*Output 1:
Enter String 1:
wonderwhowrot ethebookonlov e
Enter String 2:
weallliveinay ellowsubmarin e
Total no. of Characters: 27.0
Total positions with same character: 3.0
Index of Coincidence: 11.111112

Process finished with exit code 0

Output 2:
Enter String 1:
Zulfa Attar
Enter String 2:
Zaid Attar
Length of Strings is not Equal

Process finished with exit code 0

Output 3:
Enter String 1:
Zulfa attar
Enter String 2:
Zulf Attara
Spaces should be at same locations

Process finished with exit code 0

*/