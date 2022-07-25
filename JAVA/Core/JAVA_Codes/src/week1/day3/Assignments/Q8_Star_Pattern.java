package week1.day3.Assignments;

public class Q8_Star_Pattern {

    public void print_Pattern(){


        for (int i= 0; i<5 ; i++) //we have 5 rows to print
        {
            for (int j=0; j<9; j++) //the first row has maximum 9 columns
            {
                if(j>=i && j<=8-i)  //this will print stars from j = i to j = 8-i
                    System.out.print("*");
                else
                    System.out.print(" ");//for j = 0 and j= last index-1, space is printed
            }
            System.out.println("");

        }
    }

    public static void main(String[] args) {
        Q8_Star_Pattern star_pattern = new Q8_Star_Pattern();
        star_pattern.print_Pattern();

    }
}

//Output: *********
//         *******
//          *****
//           ***
//            *
