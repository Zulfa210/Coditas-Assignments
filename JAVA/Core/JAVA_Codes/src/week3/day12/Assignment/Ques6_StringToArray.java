package week3.day12.Assignment;
//6) Convert String data into array and present it

public class Ques6_StringToArray {
    public static void main(String[] args) {

        String statement = "ZulfaAyubAttar";

        System.out.println("Original String : " + statement);
        char[] arrayStatement = statement.toCharArray();

        System.out.println("String after converting to array: " );
        for (char character: arrayStatement) {
            System.out.print(character + " ");
        }

    }
}

//output:
//Original String : ZulfaAyubAttar
//String after converting to array:
//Z u l f a A y u b A t t a r
//Process finished with exit code 0