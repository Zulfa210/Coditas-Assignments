package week4.Day13.Practicals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Demo_Exception{
    public void divide(){

        try{
            int a = 16, b= 1;
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

    static void checkforFile() throws FileNotFoundException {
        try {
            FileInputStream fin = new FileInputStream("abc.txt");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println("Line number 1");
//        Demo_Exception demo_exception = new Demo_Exception();
//        System.out.println("Line number 1");
//        demo_exception.divide();

            ExceptionHandling.checkforFile();

    }
}
