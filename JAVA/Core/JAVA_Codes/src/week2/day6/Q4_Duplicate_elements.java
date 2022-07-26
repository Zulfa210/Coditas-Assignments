package week2.day6;
//Q4)using the "equals" method, find the duplicate elements (int/String)of the array.. print the Duplicate element.
//=>try to remove the second occurrence of Duplicate element,
//again print Array elements (without duplication)
import java.util.Arrays;

class DuplicateElements{

    public void checkDuplicate(Integer[] array1){

        System.out.println("Array with Duplicates: " + Arrays.toString(array1));

        System.out.println("Duplicates: ");
        int count = 0;
        for(int i =0; i < array1.length; i++){
            for(int j= i+1; j < array1.length; j++){
                if(array1[i].equals(array1[j])){
                    System.out.print(array1[i] + " ");
                    //printing duplicates
                }
            }
        }
        System.out.println();

    }
    public void removeDuplicates(Integer[] array1){

        Arrays.sort(array1);
        int len = array1.length;
        int j = 0;

        for (int i = 0; i < len - 1; i++){
            //if value at index i and i+1 is equal, it's a duplicate, since array is sorted
            if (array1[i] != array1[i + 1]) {
                array1[j++] = array1[i];
            }
        }

        array1[j++] = array1[len - 1];
        System.out.println("Array without Duplicates: " );
        for (int k = 0; k < j; k++) {
            System.out.print(array1[k] + " ");
        }


    }
}

public class Q4_Duplicate_elements {
    public static void main(String[] args) {
        DuplicateElements duplicateElements = new DuplicateElements();

        Integer array1[] = {1,3, 5 ,6 ,1, 6, 8};

        duplicateElements.checkDuplicate(array1);
        duplicateElements.removeDuplicates(array1);
    }
}

//output
//Array with Duplicates: [1, 3, 5, 6, 1, 6, 8]
//Duplicates:
//1 6
//Array without Duplicates:
//1 3 5 6 8