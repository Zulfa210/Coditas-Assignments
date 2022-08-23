package week6.Day22;

import java.util.*;

/**
 * @author Zulfa Attar
 */
public class VectorDemo {

    public static void main(String[] args) {
        //Vector<Integer> vector = new Vector<>();

        Stack<Integer> vector = new Stack<>();
        vector.addElement(2);
        vector.addElement(3);
        vector.addElement(4);
        vector.addElement(5);
        vector.addElement(6);

        while (!vector.isEmpty()) {
            System.out.println(vector.pop());
        }


//        Enumeration enumeration = vector.elements();
//
//        while (enumeration.hasMoreElements()){
//            System.out.println(enumeration.nextElement());
//        }
//        System.out.println("*************************************");
//
//        Iterator iterator = vector.iterator();
//
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

    }
}
