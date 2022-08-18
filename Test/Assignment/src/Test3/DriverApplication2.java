package Test3;

import java.io.*;

/**
 * @author Zulfa Attar
 *
 * Q.1) You have to accept
 */


public class DriverApplication2 {

    void FileHandling(){
        try {

            File file = new File("Zulfa.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Hi I am genius \n");
            fileWriter.write("I am Confident\n");
            fileWriter.write("I love myself \n");

            fileWriter.close();
            int i;
            FileInputStream myReader = new FileInputStream(file);
            if(file.exists()){
                while((i = myReader.read()) != -1){
                    System.out.print((char)i);
                }
           }
            else{
                System.out.println("File doesn't exist");
            }

            myReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    void copyData(){
        try{

            FileOutputStream file1 = new FileOutputStream("A.txt");
            FileOutputStream file2 = new FileOutputStream("B.txt");
            FileOutputStream file3 = new FileOutputStream("C.txt");
            FileOutputStream file4 = new FileOutputStream("D.txt");

            FileInputStream filex = new FileInputStream("Zulfa.txt");
            int i;
            while((i = filex.read()) != -1){
                file1.write((char)i);
            }
            file1.close();

            FileInputStream filex1 = new FileInputStream("Zulfa.txt");
            while((i = filex1.read()) != -1){
                file2.write((char)i);
            }
            file2.close();

            FileInputStream filex2= new FileInputStream("Zulfa.txt");
            while((i = filex2.read()) != -1){
                file3.write((char)i);
            }
            file3.close();
            FileInputStream filex3 = new FileInputStream("Zulfa.txt");
            while((i = filex3.read()) != -1){
                file4.write((char)i);
            }
            filex1.close();
            filex2.close();
            filex3.close();
            file4.close();
            filex.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DriverApplication2 driver = new DriverApplication2();

        driver.FileHandling();
        driver.copyData();
    }
}
