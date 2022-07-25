package week1.day3.Assignments;

public class Q8_Alphabet_Pattern_2 {

    public void print_Pattern(){

        for (int i = 0; i <= 5; i++) {
            int alphabet = 65;
            for (int j = 0; j <= i; j++) {
                System.out.print((char) (alphabet + j) + " "); //printing alphabets from A to {A to F}
            }
            System.out.println();
        }
        for (int i = 5; i >= 0; i--) {
            int alphabet = 65;
            for (int j = 0; j <= i - 1; j++) {
                System.out.print((char) (alphabet + j) + " ");//printing alphabets from {A to F} to A
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Q8_Alphabet_Pattern_2 object= new Q8_Alphabet_Pattern_2();
        object.print_Pattern();
    }
}

//output
//A
//A B
//A B C
//A B C D
//A B C D E
//A B C D E F
//A B C D E
//A B C D
//A B C
//A B
//A