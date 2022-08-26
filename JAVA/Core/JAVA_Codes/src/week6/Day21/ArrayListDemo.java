package week6.Day21;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Zulfa Attar
 */
public class ArrayListDemo {
    public static void main(String[] args) {

        int n = 5;

        ArrayList arrayList = new ArrayList();

        arrayList.add(12);
        arrayList.add("Zulfa");
        arrayList.add(1, "X");
        for(int i = 0; i < n; i++){
            arrayList.add(i);
        }

        System.out.println(arrayList);

        arrayList.remove(3);
        System.out.println(arrayList);


        for(int i = 0; i<arrayList.size(); i++){
            System.out.print(arrayList.get(i) + " ");
        }
        arrayList.forEach(ss->System.out.println(ss));
                System.out.println();

        ArrayList arrayList1 = new ArrayList();

        arrayList1.add(11);
        arrayList1.addAll(1, arrayList);

        System.out.println(arrayList1);




//        System.out.println(arrayList.toArray().toString());

//        HashSet hashSet = new HashSet();
//
//        hashSet.add(1);
//        hashSet.add(3);
//        hashSet.add(5);
//
//        HashSet hashSet1 = new HashSet();
//
//        hashSet1.add(5);
//        hashSet1.add(1);
//        hashSet1.add(3);
//
//        System.out.println(hashSet.equals(hashSet1));
    }
}
