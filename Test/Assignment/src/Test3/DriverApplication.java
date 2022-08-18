package Test3;

/**
 * @author Zulfa Attar
 */

class Shape{
}
class Circle extends Shape{
}
public class DriverApplication {

    void case2(){
        try{
            try{
                String name = null;
                int x= name.length();
            }catch (NullPointerException e){
                System.out.println("\n"+ e.getClass() + " Handled Printing Stack Trace");
                System.out.println(e.getStackTrace());
            }
            Shape shape = new Shape();
            Circle circle = (Circle) shape;

        }catch (ClassCastException e){
            System.out.println( "\n"+ e.getClass() + " Handled Printing Stack Trace");
            System.out.println(e.getStackTrace());
        }
    }


    void case1(){
        try{
            try{
                String name = null;
                int x= name.length();
            }finally {
                System.out.println("Finally: String should not be null");
            }
            Shape shape = new Shape();
            Circle circle = (Circle) shape;

        }catch (ClassCastException | NullPointerException e){
            System.out.println("\n"+ e.getClass() + " Handled Printing Stack Trace");
            System.out.println(e.getStackTrace());
        }
    }


    public static void main(String[] args) {

        DriverApplication driver = new DriverApplication();
        driver.case2();
        driver.case1();
    }
}

/*
Output:

class java.lang.NullPointerException Handled Printing Stack Trace
[Ljava.lang.StackTraceElement;@1b6d3586

class java.lang.ClassCastException Handled Printing Stack Trace
[Ljava.lang.StackTraceElement;@4554617c
Finally: String should not be null

class java.lang.NullPointerException Handled Printing Stack Trace
[Ljava.lang.StackTraceElement;@74a14482

Process finished with exit code 0

 */