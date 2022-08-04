package week3.day12.Assignment;
//3) Remove all repeated characters from a given string.

import java.util.Arrays;
import java.util.LinkedHashSet;

class Repeated_characters{

    public static void remove_repeated(String string1){

        System.out.println("String with repeated characters: "  + string1.toString());
//          using LinkedHashSet
//        //Create LinkedHashSet of type character
//        LinkedHashSet<Character> set = new LinkedHashSet<>();
//
//        //Adding each character of the string1 into LinkedHashSet
//        for(int i=0;i<string1.length();i++)
//            set.add(string1.charAt(i));
//
//        // printing the string1 after removing duplicate characters
//        for(Character ch : set)
//            System.out.print(ch);

        //converting sting into character array
       char[] temp1 = string1.toCharArray();

       //creating new empty string
       String newString = "";

       //adding only distinct characters in new string
       for(char c: temp1){
            if(newString.indexOf(c) == -1){
                newString += c;
            }
       }

        System.out.println("String without repeated characters: "  + newString.toString());

    }
}

public class Ques3_RepeatedChars {

    public static void main(String[] args) {
        String string = "zulfaattar";
        Repeated_characters.remove_repeated(string);

    }
}

//output:
//String with repeated characters: zulfaattar
//String without repeated characters: zulfatr
//
//Process finished with exit code 0
