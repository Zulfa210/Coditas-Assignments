package week3.day12.Assignment;
//5)Accept 5 names of string type, count the length.and as per their length assign there
//order (Ascending).
//=>Replace above strings "vowel characters" with their next letter.
//=>Ex. "Aarti" => Vowels present here are = =>a(2),i(1)
//=>next character of "a" is "b" and for "i" its "j"
//->so,final string will be "bbrti"

import java.util.Scanner;

class StringOperations{
    public static void sortArray(String[] names){
        for (int i = 0; i<names.length; i++){

            String temp = names[i];
            int j = i - 1;
            while (j >= 0 && temp.length() < names[j].length())
            {
                names[j+1] = names[j];
                j--;
            }
            names[j+1] = temp;
        }
    }

    public void changeVowels(String string1){

        int vowels = 0, consonant = 0;

        //string1 = string1.toLowerCase();
        System.out.println("Original String is: " + string1);
        String vowel = "aeiouAEIOU";

        for(int i = 0; i< string1.length(); i++){
            if(vowel.indexOf(string1.charAt(i)) != -1) {
                int a = (int) string1.charAt(i);
                string1 = string1.replace(string1.charAt(i), (char)(a+1));
            }
        }
        System.out.println(string1);
    }

    public String[] acceptData(String[] names){
        Scanner scanner = new Scanner(System.in);
        int i =0;
        System.out.println("Enter names: ");
        for(String name: names){
            name = scanner.next();
            names[i++] = name;
        }

        return names;
    }

    public void displayArray(String[] names){
        for(String name : names)
            System.out.println(name);
    }
}
public class Ques5_DriverClass {
    public static void main(String[] args) {
        String names[] = new String[5];
        StringOperations operations = new StringOperations();

        names = operations.acceptData(names);
        System.out.println("Original Array: ");
        operations.displayArray(names);

        System.out.println("\nArray in ascending order:   ");
        operations.sortArray(names);
        operations.displayArray(names);

        System.out.println("\n----------------------------------\n");
        System.out.println("Names after replacing vowel characters with their next letters");
        for(String name : names)
            operations.changeVowels(name);
    }
}

//output:
//Enter names:
//Zulfa
//Anuj
//Zaid
//Abhishek
//Shubham
//Original Array:
//Zulfa
//Anuj
//Zaid
//Abhishek
//Shubham
//
//Array in ascending order:
//Anuj
//Zaid
//Zulfa
//Shubham
//Abhishek
//
//----------------------------------
//
//Names after replacing vowel characters with their next letters
//Original String is: Anuj
//Bnvj
//Original String is: Zaid
//Zbjd
//Original String is: Zulfa
//Zvlfb
//Original String is: Shubham
//Shvbhbm
//Original String is: Abhishek
//Bbhjshfk
//
//Process finished with exit code 0