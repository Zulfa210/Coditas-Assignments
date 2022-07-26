package week2.day6;
//Q6)Try to get the nth index element from an array. Accept index value from user (Scanner)

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class getValueOfN{
   public void getNthHighest(int n, Integer[] array){

       Arrays.sort(array, Collections.reverseOrder());

       System.out.println(n+ "th highest index value is "+ array[n-1]);
  }


}

public class Q6_nthIndex {

    public static void main(String[] args) {
        int index;
        Scanner scanner = new Scanner(System.in);

        Integer[] array = {3, 5, 8, 1, 9};
        System.out.println("Array is: " + Arrays.toString(array));

        System.out.print("Enter index: ");
        index = scanner.nextInt();

        getValueOfN object = new getValueOfN();
        object.getNthHighest(index, array);
    }
}

//ouput
//Array is: [3, 5, 8, 1, 9]
//Enter index: 2
//2th highest index value is 8
