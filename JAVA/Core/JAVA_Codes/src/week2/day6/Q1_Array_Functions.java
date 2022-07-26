package week2.day6;

//Q1)Check for the package, related to Array,where Array related in-built methods are present?
// =>create Simple code using those package in-built functionality.
// =>whenever required use the "for-each" loop to iterate.
// =>Allow Naming conventions and indentation while coding.(spaces, tab
import java.util.Arrays;

class ArrayFunctions{

    public void displayData(int[] array1){
        for(int element: array1)
            System.out.print(element + " ");

        System.out.println();
    }
    public void BuiltInFunctionsDemo(){

        int[] array1 = {2, 3, 6, 3, 1, 8, 6};
        int[] array2 = {5, 6, 4, 8, 9, 10};

        Arrays.asList(array1);
        System.out.println("Using asList() function: " +Arrays.toString(array1) );


        System.out.println("Using sort() function");
        Arrays.sort(array1);
        displayData(array1);


        System.out.println("Element 3 was found using binarysearch() at " + Arrays.binarySearch(array1,3));

        //copying using copyOf() function
        int arraycopy3[] = Arrays.copyOf(array1, 7);
        System.out.println("Copied Array using copyOf(): ");
        displayData(arraycopy3);

        //copying using copyOfRange method
        int arraycopy4[] = Arrays.copyOfRange(array1, 1, 4);
        System.out.println("Copied Array using copyOfRange(): ");
        displayData(arraycopy4);

        System.out.println("Printing using toString(): " + Arrays.toString(array1));

    }
}

public class Q1_Array_Functions {
    public static void main(String[] args) {
        ArrayFunctions arrayFunctions = new ArrayFunctions();
        arrayFunctions.BuiltInFunctionsDemo();
    }
}

//output
//Using asList() function: [2, 3, 6, 3, 1, 8, 6]
//Using sort() function
//1 2 3 3 6 6 8
//Element 3 was found using binarysearch() at 3
//Copied Array using copyOf():
//1 2 3 3 6 6 8
//Copied Array using copyOfRange():
//2 3 3
//Printing using toString(): [1, 2, 3, 3, 6, 6, 8]