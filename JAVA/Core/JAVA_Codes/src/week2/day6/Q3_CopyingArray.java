package week2.day6;
//Q3)Copy one array into the another array,using in-built functionality
//there are many methods to copy one array into another array
//1. Using clone() method
//2. Using arraycopy() method of system class
//3. Using copyOf() method of Arrays class
//4. Using copyOfRange() method of Arrays class

import java.util.*;

class ArrayCopy{

    public void displayArray(int[] array1){
        for(int element: array1)
            System.out.print(element + " ");

        System.out.println();
    }

    public void copyArray(){
        int[] originalarray = {3, 5, 2, 6, 1};
        System.out.println("Original Array: ");
        displayArray(originalarray);

        //copying using clone() method
        int arraycopy1[] = originalarray.clone();
        System.out.println("Copied Array with method 1");
        displayArray(arraycopy1);

        //copying using arraycopy() method
        int arraycopy2[] = new int[originalarray.length];
        System.arraycopy(originalarray, 0, arraycopy2, 0, 5);
        System.out.println("Copied Array with method 2");
        displayArray(arraycopy2);

        //copying using copyOf method
        int arraycopy3[] = Arrays.copyOf(originalarray, 5);
        System.out.println("Copied Array with method 3");
        displayArray(arraycopy3);

        //copying using copyOfRange method, it will copy array from index 1 to 4
        int arraycopy4[] = Arrays.copyOfRange(originalarray, 1, 4);
        System.out.println("Copied Array with method 4");
        displayArray(arraycopy4);

    }

}


public class Q3_CopyingArray {

    public static void main(String[] args) {
        ArrayCopy  arrayCopy = new ArrayCopy();

        arrayCopy.copyArray();
    }
}

//output
//Original Array:
//3 5 2 6 1
//Copied Array with method 1
//3 5 2 6 1
//Copied Array with method 2
//3 5 2 6 1
//Copied Array with method 3
//3 5 2 6 1
//Copied Array with method 4
//5 2 6
