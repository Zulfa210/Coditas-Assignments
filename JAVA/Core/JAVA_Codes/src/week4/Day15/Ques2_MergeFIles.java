package week4.Day15;

import java.io.*;
import java.util.Scanner;

/**
 * Q.2)Get data from two file and insert that two file data into third one and read third file data
 *
 * @author Zulfa Attar
 */

class MergeFilesClass {
    SequenceInputStream addTwoFileDataInOne=null;
    FileInputStream file1 = null;
    FileInputStream file2 = null;
    FileOutputStream file1AndFile2Data = null;
    FileInputStream bufferedInputStream3 =null;

    void mergeDataInThirdFile(String firstdata, String seconddata)
    {


        int j;
        try {

            //this statement is used to add data in both file before fetching data from both file



            file1 = new FileInputStream("file1.txt");

            file2 = new FileInputStream("file2.txt");

            addTwoFileDataInOne = new SequenceInputStream(file1,file2);

            file1AndFile2Data = new FileOutputStream("file3.txt");

            //get data from file.txt and file2.txt and add both file data into file3

            while ((j = addTwoFileDataInOne.read()) != -1) {
                file1AndFile2Data.write(j);

            }
            //closeing all open file
            addTwoFileDataInOne.close();

            file1.close();

            file2.close();

            file1AndFile2Data.close();

            System.out.println("=================DATA INSERTED IN THIRD FILE=================");

        }catch(Exception e)
        {
            System.out.println("insert Data into third file error "+e.getMessage());
        }
    }
    void getDataFromThirdFile()
    {


        try {

            bufferedInputStream3 = new FileInputStream("file3.txt");

            int j;
            //read data from thrid file

            while ((j =  bufferedInputStream3.read()) != -1) {
                System.out.print((char)j);
            }
            //close third file connection

            bufferedInputStream3.close();

        } catch (Exception e) {
            System.out.println("Error in reading third file "+e.getMessage());
        }
    }

    //Write Data into both file
    void addDataInFiles(String firstdata, String seconddata)
    {
        try {


            FileOutputStream file1 = new FileOutputStream("file1.txt");

            FileOutputStream file2 = new FileOutputStream("file2.txt");

            file1.write(firstdata.getBytes());

            file2.write(seconddata.getBytes());

            file1.close();

            file2.close();

            System.out.println("================DATA ADDED SUCCESSFULLY==================");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
public class Ques2_MergeFIles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MergeFilesClass mergeFiles = new MergeFilesClass();
        System.out.println("Enter Data for first file");
        String firstfile_data = scanner.nextLine();
        System.out.println("Enter Data for second file");
        String secondfile_data = scanner.nextLine();

        mergeFiles.addDataInFiles(firstfile_data,secondfile_data);
        mergeFiles.mergeDataInThirdFile(firstfile_data+" ",secondfile_data+" ");

        System.out.println("=================READING FROM THIRD FILE=================");
        mergeFiles.getDataFromThirdFile();
    }
}
/*
Output:
Enter Data for first file
Zulfa Attar
Enter Data for second file
 Lives in Pune
================DATA ADDED SUCCESSFULLY==================
=================DATA INSERTED IN THIRD FILE=================
=================READING FROM THIRD FILE=================
Zulfa Attar Lives in Pune
Process finished with exit code 0
 */