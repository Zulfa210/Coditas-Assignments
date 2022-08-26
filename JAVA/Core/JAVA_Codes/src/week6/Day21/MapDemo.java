package week6.Day21;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Zulfa Attar
 */
public class MapDemo {
    public static void main(String[] args) {

        Map<Integer, String> hm = new HashMap<Integer, String>();

        hm.put(1, "Zulfa");
        hm.put(2, "A");
        hm.put(3, "Z");

        Iterator<Map.Entry<Integer, String>> iterator =hm.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry mapElement =  iterator.next();

            System.out.println(mapElement.getKey() + " : " + mapElement.getValue());
        }

    }
}
