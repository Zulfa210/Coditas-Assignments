package week4.Day15;

import java.io.*;

class FileHandling {
    public void OutputStream_Methods(){
        try {

            //FileOutputStream
            FileOutputStream file = new FileOutputStream("abc.txt");
            file.write(90);
            file.close();

            //ByteArrayOutputStream
            String name = "Zulfa";
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] array = name.getBytes();

            // Writes data to the output stream
            out.write(array);

            // Retrieves data from the output stream in string format
            String streamData = out.toString();
            System.out.println("Output stream: " + streamData);



            //DataOutputStream
            FileOutputStream file1 = new FileOutputStream("xyz.txt");
            DataOutputStream data = new DataOutputStream(file1);
            data.writeInt(65);
            data.flush();
            data.close();


            //BufferedOutputStream
            FileOutputStream file2 = new FileOutputStream("xyz.txt");
            // Creates a BufferedOutputStream
            BufferedOutputStream buffer = new BufferedOutputStream(file2);

            // Writes data to the output stream
            buffer.write(name.getBytes());

            // Flushes data to the destination
            buffer.flush();
            System.out.println("Data is flushed to the file.");
            buffer.close();


            //PrintStream
            FileOutputStream fout=new FileOutputStream("mfile.txt");
            PrintStream pout=new PrintStream(fout);
            pout.println(1900);
            pout.println("Hello");
            pout.println("Welcome to Coditas");
            pout.close();
            fout.close();


            System.out.println("Succcess...");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void InputStream_Methods(){



    }

    public void CreateFile(){
        File fileObj = new File("abc.txt");
        try {
            if(fileObj.createNewFile()){
                System.out.println("File Created: "+ fileObj.getName());
            }
            else{
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFileInformation(){
        File myFile = new File("abc.txt");
        if(myFile.exists()){
            System.out.println("File name: " + myFile.getName());
            System.out.println("Absolute Path: " + myFile.getAbsolutePath());
            System.out.println("Writeable: " + myFile.canWrite());
            System.out.println("Readable: " + myFile.canRead());
            System.out.println("File size in bytes: " + myFile.length() );
        }
        else{
            System.out.println("File does not exists!");
        }
    }

    public void WiteToFile(){

        try {
            FileWriter fileWriter = new FileWriter("abc.txt");
            fileWriter.write("Java is an Object Oriented Programming Language.                                                       ");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Successfully written to file");
    }

    public void ReadFromFile(){
        try {
            BufferedReader myReader = new BufferedReader(new FileReader("abc.txt"));
            char[] array = new char[100];
            myReader.read(array);
            System.out.println("Data in the file: ");
            System.out.println(array);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
public class FileHandling_Demo {
    public static void main(String[] args) {

        FileHandling inputOutputStream_demo = new FileHandling();

        //inputOutputStream_demo.OutputStream_Methods();
        inputOutputStream_demo.CreateFile();
        inputOutputStream_demo.getFileInformation();
        inputOutputStream_demo.WiteToFile();
        inputOutputStream_demo.ReadFromFile();
    }
}

/*
Ouput:
File already exists
File name: abc.txt
Absolute Path: C:\Users\Coditas\Desktop\Coditas-Assignments\JAVA\Core\JAVA_Codes\abc.txt
Writeable: true
Readable: true
File size in bytes: 103
Successfully written to file
Data in the file:
Java is an Object Oriented Programming Language.

Process finished with exit code 0
 */