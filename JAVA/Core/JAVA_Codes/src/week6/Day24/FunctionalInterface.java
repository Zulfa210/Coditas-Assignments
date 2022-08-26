package week6.Day24;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zulfa Attar
 */
public class FunctionalInterface {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(80);
        list.add(31);
        list.add(20);
        list.add(41);
        list.add(50);

        System.out.println(list);
        List<Integer> list1 = list.stream().filter(i->i%2==0).map(i->i+5).collect(Collectors.toList());
        System.out.println(list1);

//        List<Integer> updatedList = list.stream().map(i->i+5).collect(Collectors.toList());
//        System.out.println(updatedList);

        list.stream().map(x->x*2).forEach(y-> System.out.print(y + " "));
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        System.out.println(list.stream().reduce(0,(ans,i)->ans+i));
        System.out.println(list.stream().reduce(0, Integer::sum));
        int count  = (int) list.stream().count();
        Integer finde = list.stream().findAny().get();


    }
}
