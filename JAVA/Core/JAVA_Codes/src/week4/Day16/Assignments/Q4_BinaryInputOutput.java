package week4.Day16.Assignments;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

class BinaryIO{
    void BinaryInput()
    {

        try {
            System.out.println("Data from File: ");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("binary.txt"));
            int a;
            while((a=bufferedInputStream.read())!=-1) {
                System.out.print((char)a);
            }
            bufferedInputStream.close();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    void BinaryOutput() {


        try {
            Scanner scanner= new Scanner(System.in);
            System.out.println("Enter Data to Write in the File");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("binary.txt"));
            bufferedOutputStream.write(scanner.nextLine().getBytes());
            bufferedOutputStream.close();
            System.out.println("Data Written Successfully");

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
public class Q4_BinaryInputOutput {
    public static void main(String[] args) {

        BinaryIO binaryIO = new BinaryIO();
        binaryIO.BinaryOutput();
        binaryIO.BinaryInput();

    }
}

/*
Output:
Enter Data to Write in the File
Zulfa Attar
Data Written Successfully
Data from File:
Zulfa Attar
Process finished with exit code 0
 */