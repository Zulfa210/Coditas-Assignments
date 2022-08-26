package week6.Day23.jdk5;

import java.util.Comparator;

/**
 * 1)Write a program for Addition operation,
 * Class Addition{
 * //add method overloading for add() }
 * Class Varargs_Addition{
 * //use varargs for add method
 * }
 * Class MainApplication{ //access above classes in main()
 * }
 * @author Zulfa Attar
 */

class Addition{

    int add(int a, int b ){
        System.out.println("Addition of " + a +" & "+ b + " is " + (a+b));

        return a+b;
    }
    float add(float a, float b){
        System.out.println("Addition of " + a +" & "+ b + " is " + (a+b));
        return a+b;
    }
    float add(int a, float b){
        System.out.println("Addition of " + a +" & "+ b + " is " + (a+b));
        return a+b;
    }
}
class Varargs_Addition{

    int add(int...a){
        return a[0] + a[1];
    }

    float add(float...a){
        return a[0] + a[1];
    }

}
public class Q1_AdditionOperation {

    public static void main(String[] args) {
        Addition addition= new Addition();
        Varargs_Addition varargsAddition = new Varargs_Addition();

        int a =10, b =20;
        float x = 1.33f, y = 3.44f;
        addition.add(a,b);
        addition.add(a,x);
        addition.add(x,y);

        int array[] = {2,3};
        System.out.println("Addition using varargs: " + varargsAddition.add(6,7));
        System.out.println("Addition using varargs: " +varargsAddition.add(x,y));

    }
}

/*Output

Addition of 10 & 20 is 30
Addition of 10 & 1.33 is 11.33
Addition of 1.33 & 3.44 is 4.77
Addition using varargs: 13
Addition using varargs: 4.77

Process finished with exit code 0

 */