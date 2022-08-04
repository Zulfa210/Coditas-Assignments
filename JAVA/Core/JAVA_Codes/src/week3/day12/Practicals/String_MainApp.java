package week3.day12.Practicals;

import java.util.StringTokenizer;

public class String_MainApp {

    public static void main(String[] args) {
        //way1 =>literal way
        String first_name = "Coditas";

        //way2 => using new keyword
        String last_name  = new String("doditas");

        System.out.println("Name of Firm is :: " + first_name + " " + last_name);

        //first_name = first_name.concat(last_name);
        System.out.println(first_name);

        //way1=> it will check content and length of th object
        System.out.println(first_name.equals(last_name));

        //way2=> it will check object creation type
        System.out.println(first_name == last_name);

        //way3=> compareto => integer exact same = 0, fn>sn <0, fn<sn >0
        System.out.println(first_name.compareTo(last_name));

        System.out.println(last_name.intern());

        System.out.println("********************************************");
        String check_null_value = null;
        ///System.out.println(check_null_value.length());
        //split()
        //substring
        //matches
        //regionMatches
        //ensure
        //ensureCapacity

        StringBuffer stringBuffer = new StringBuffer("Coditas");

        stringBuffer.append("ELTP");
        System.out.println(stringBuffer);

//        stringBuffer.reverse();
//        System.out.println(stringBuffer);

        stringBuffer.insert(5, " 799 ");
        System.out.println(stringBuffer);

        StringBuffer news = new StringBuffer();
        System.out.println(news.capacity());
        System.out.println(stringBuffer.capacity());

        news.ensureCapacity(50);
        System.out.println(news.capacity());

        StringTokenizer token  = new StringTokenizer("Hello is this you?", " ");

    }
}
