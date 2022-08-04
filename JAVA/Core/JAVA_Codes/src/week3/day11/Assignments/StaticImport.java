package week3.day11.Assignments;
import java.util.Scanner;

import static java.lang.Math.*;
import static java.lang.System.*;
class Static_ImportDemo {
    public static void checkStatic()
    {
        // We are calling static member of System class
        // directly without System class name
        Scanner scanner = new Scanner(in);
        out.println("Enter an integer: ");
        int a = scanner.nextInt();

        // We are calling static member of Math class
        // directly without Math class name
        out.println(sqrt(a));
        out.println(pow(2, 2));
        out.println(abs(6.3));
    }
}
public class StaticImport {
    public static void main(String[] args) {
        Static_ImportDemo.checkStatic();
    }
}

//output:
//
//Enter an integer:
//        5
//        2.23606797749979
//        4.0
//        6.3
