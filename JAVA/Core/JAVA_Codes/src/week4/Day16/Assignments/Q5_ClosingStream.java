package week4.Day16.Assignments;

import java.io.FileReader;
import java.io.FileWriter;

public class Q5_ClosingStream {
    void withoutClosingStream() {
        try{
            FileWriter fileWriter = new FileWriter("closing.txt");
            fileWriter.write("Hello! This is Zulfa Attar");
            FileReader fileReader = new FileReader("closing.txt");

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
            FileWriter fileWriter = new FileWriter("closing.txt");

            fileWriter.write("Hello! This is Zulfa Attar");
            fileWriter.close();
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
        System.out.println("========Without Closing Stream=============");
        stream.withoutClosingStream();
        System.out.println("========With Closing Stream=============");
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