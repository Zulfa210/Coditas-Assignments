package Test1;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class StringTest {
    public static void main(String[] args) {
        String string = "Hello Good Morning How Are You ?";
        String[] arr = string.split(" ");
        System.out.println("Printing spilted Array of String : \n"+Arrays.toString(arr));
//        Arrays.sort(arr, Collections.reverseOrder());
//        System.out.println("Printing descending order Array : \n"+Arrays.toString(arr));
        Arrays.sort(arr, Comparator.comparingInt(String ::length));
        System.out.println("Printing descending order Array lengthwise : \n"+Arrays.toString(arr));

        String ans="";
        for(String str : arr){
            ans=ans+str+" ";
        }
        //System.out.println(ans);
        StringTokenizer tokenizer = new StringTokenizer(ans," ");
        System.out.println("\nPrinting tokens With dollor $$");
        while(tokenizer.hasMoreTokens()){
            System.out.print(tokenizer.nextToken()+" || ");
        }
//
//        while(tokenizer.){
//            System.out.print(tokenizer.nextToken() + " $ ");
//
//        }


    }
}
