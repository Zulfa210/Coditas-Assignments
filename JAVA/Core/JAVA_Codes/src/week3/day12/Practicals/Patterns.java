package week3.day12.Practicals;

public class Patterns {
    public static void main(String[] args) {
        for(int row = 0; row< 7; row++){
            int sp = row<4?4-row:4+row;
            for(int col=1; col<=4; col++){
                if(col == sp)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
