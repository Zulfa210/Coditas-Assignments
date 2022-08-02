package week3.day10.Assignments;
//Q4) Try to access parameterized methods of a class

import java.lang.reflect.Method;

class Calculator{
    public int a;
    public int b;

    public void add(int a, int b){
        int sum = a + b;
        System.out.println("Addition is : " + sum);
    }
}

public class Ques4_MainApplication {
    public static void main(String[] args) throws Exception {

        Calculator calculate = new Calculator();

        Class myClass = calculate.getClass();
        int a = 10;
        int b = 12;

        //We can access parameterized methods through class.getMethods() function
        //we need to pass method name and parameter types in getMethod()
        Method method1 = myClass.getMethod("add", int.class, int.class);

        //method.invoke is used to call the method
        method1.invoke(calculate, a, b);
    }
}
