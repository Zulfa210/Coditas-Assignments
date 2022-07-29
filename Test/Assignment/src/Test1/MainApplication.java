package Test1;
//1) create an array of size 5 int, and iterate it, print all elements
//2) find the greatest value in the array
//3) find the fourth largest value in the array

import java.util.Arrays;

class ArrayAssignment{

    public void printArray(int[]  array1){
        for(int element: array1){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public void get_Greatest(int[] array1){
        Arrays.sort(array1);
        System.out.println("-----------------------------------------------------");
        System.out.println("Greatest element is: " + array1[array1.length - 1]);
    }
    public void get_Fourth_Largest(int[] array1){
        Arrays.sort(array1);
        System.out.println("-----------------------------------------------------");
        System.out.println("Fourth Largest element is "+ array1[array1.length - 4]);
    }
}
public class MainApplication {
    public static void main(String[] args) {

        int array1[] = {2, 15, 1, 100, 70};
        ArrayAssignment arrays = new ArrayAssignment();
        arrays.printArray(array1);
        arrays.get_Greatest(array1);
        arrays.get_Fourth_Largest(array1);

    }
}
//output:
//2 15 1 100 70
//-----------------------------------------------------
//Greatest element is: 100
//-----------------------------------------------------
//Fourth Largest element is 2