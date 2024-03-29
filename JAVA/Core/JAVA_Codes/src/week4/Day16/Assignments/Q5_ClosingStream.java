package week4.Day16.Assignments;

/**
 * Q.5)Closing Streams is important or not? Explain by writing code
 * @author Zulfa Attar
 */

import java.io.FileReader;
import java.io.FileWriter;

public class Q5_ClosingStream {
    void withoutClosingStream() {
        try{
            System.out.println("========Without Closing Stream=============");
            //writing in file
            FileWriter fileWriter = new FileWriter("closing.txt");
            fileWriter.write("Hello! This is Zulfa Attar");
            FileReader fileReader = new FileReader("closing.txt");

            //reading file
            int i;
            while((i=fileReader.read())!=-1) {
                System.out.print((char)i);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    void withClosingStream() {
        try {
            System.out.println("========With Closing Stream=============");
            //writing in file
            FileWriter fileWriter = new FileWriter("closing.txt");
            fileWriter.write("Hello! This is Zulfa Attar");
            fileWriter.close();

            //reading file
            FileReader fileReader = new FileReader("closing.txt");
            int i;
            while((i=fileReader.read())!=-1){
                System.out.print((char)i);
            }
            fileReader.close();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Q5_ClosingStream stream = new Q5_ClosingStream();
        stream.withoutClosingStream();
        stream.withClosingStream();

    }
}

/*
Output:
========Without Closing Stream=============
========With Closing Stream=============
Hello! This is Zulfa Attar
Process finished with exit code 0
 */