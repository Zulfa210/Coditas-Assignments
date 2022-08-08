package week3.day12.Practicals;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test_MainAplication {

    public void showPatter(){
        int n = 5;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <=n; j++){
                if(j<n-i){
                    System.out.print("  ");
                }
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
    public void showPattern(){
        int n = 5;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < n; j++){
                if(j<n-i){
                    System.out.print("  ");
                }
                else
                    System.out.print("* ");
            }
            for(int k = 1; k<i; k++){
                System.out.print("* ");
            }
            System.out.println();
        }


    }
    public void showString(String string){

        int i = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
        String string1[] = new String[stringTokenizer.countTokens()];
        while(stringTokenizer.hasMoreElements()){
            string1[i++] = stringTokenizer.nextToken();
        }


        //string1 =  string.split(" ", 5);

        Arrays.sort(string1);

        System.out.println("===In Alphabetical Order====");
        for(String s1: string1){
            System.out.println(s1 + " ");
        }

//        for(int i =1; i < string1.length; i++){
//            String temp = string1[i];
//            int j = i-1;
//            if(j>=0 && temp.length() > string1[j].length()){
//                string1[j] = temp;
//                        j--;
//            }
//            string[j+1] =temp
//
//        }

        Arrays.sort(string1, Comparator.comparingInt(String ::length));

        System.out.println("\n===In Ascending Order====");
        for(String s1: string1){
            System.out.println(s1.toString() + " ");
        }
    }


    public static void main(String[] args) {
        Test_MainAplication test_main = new Test_MainAplication();
        // test_main.showPattern();

        String s1=null;
        System.out.println("Enter your String: ");
        Scanner scanner = new Scanner(System.in);
        s1 = scanner.nextLine();
        //s1 = "i love my india";
        test_main.showString(s1);
    }
}
