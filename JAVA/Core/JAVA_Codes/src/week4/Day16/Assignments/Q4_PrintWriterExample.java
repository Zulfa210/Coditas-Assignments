package week4.Day16.Assignments;

import java.io.File;
import java.io.PrintWriter;

class PrintWriterDemo{
    public void Writing() {

        try {
            //Data to write on Console using PrintWriter
            PrintWriter writer = new PrintWriter(System.out);
            writer.write("Hello! This is Zulfa Attar");
            writer.flush();
            writer.close();
            //Data to write in File using PrintWriter
            PrintWriter writer1 = null;
            writer1 = new PrintWriter(new File("abc.txt"));
            writer1.write("Adding Text in File");
            writer1.flush();
            writer1.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
public class Q4_PrintWriterExample {
    public static void main(String[] args){
        PrintWriterDemo printWriterDemo =new PrintWriterDemo();
        printWriterDemo.Writing();


    }
}

/*
Output:
Hello! This is Zulfa Attar
Process finished with exit code 0
 */