package week2.day6;
//2)Print array in Ascending and descending order,using in-built functionality.

import java.util.*;

class AscendingAndDescending{

    public void displayArray(Integer[] array1){
        for(int element: array1)
            System.out.print(element + " ");

        System.out.println();
    }

    public void asc_desc(){
        Integer[] array1 = {3, 4, 5, 2, 1, 10};

        //printing original array
        System.out.println("Original array");
        displayArray(array1);

        //printing sorted array in ascending order
        Arrays.sort(array1);
        System.out.println("Array in Ascending Order");
        displayArray(array1);

        //printing sorted array in descending order
        Arrays.sort(array1, Collections.reverseOrder());
        System.out.println("Array in Descending Order");
        displayArray(array1);
    }

}
public class Q2_AscendingAndDescending {

    public static void main(String[] args) {

        AscendingAndDescending object  = new AscendingAndDescending();

        object.asc_desc();

    }
}

//output
//Original array
//3 4 5 2 1 10
//Array in Ascending Order
//1 2 3 4 5 10
//Array in Descending Order
//10 5 4 3 2 1
