package week3.day12.Assignment;
//2) Count the total number of vowels and consonants in a string.
import java.util.Locale;

class CheckVowels{

    public static void checkCount(String string1){

        int vowels = 0, consonant = 0;

        string1 = string1.toLowerCase();
        System.out.println("String is: " + string1);
        String vowel = "aeiou";

        for(int i = 0; i< string1.length(); i++){
            if(vowel.indexOf(string1.charAt(i)) != -1)
                vowels++;
            else
                consonant++;
        }
        System.out.println("Total no. of vowels: " + vowels + "\nTotal no. of consonants: " + consonant);
    }
}
public class Ques2_VowelsConsonants {
    public static void main(String[] args) {

        String name = "ZulfaAyubAttar";
        CheckVowels.checkCount(name);

    }
}

//output:
//String is: zulfaayubattar
//Total no. of vowels: 6
//Total no. of consonants: 8
//
//Process finished with exit code 0
