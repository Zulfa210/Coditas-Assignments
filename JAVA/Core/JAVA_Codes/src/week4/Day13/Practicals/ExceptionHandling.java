package week4.Day13.Practicals;

class Demo_Exception{
    public void divide(){

        try{
            int a = 16, b= 0;
            float div = a/b;
            System.out.println("Division is: " +div);
            throw new RuntimeException();

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        System.out.println("Line number 1");
       Demo_Exception demo_exception = new Demo_Exception();
        System.out.println("Line number 1");
       demo_exception.divide();
    }
}
