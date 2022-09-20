import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author Zulfa Attar
 */
public class ConvertCsvToExcel {
    void csvToExcel(String filePath)
    {
        try{
            BufferedReader csvfile = new BufferedReader(new FileReader(filePath));
            String savepath = "C://Users/Coditas/Desktop/Coditas-Assignments/JAVA/Advanced/CSVtoExcel/src/main/webapp/excelData.xlsx" ;
            BufferedWriter excelfile = new BufferedWriter(new FileWriter(savepath));
            String s =null;
            //fetch csv file data and insert data into excel file
            
            while((s=csvfile.readLine())!=null)
            {
                excelfile.write(s);
                excelfile.newLine();
                System.out.println(s);
            }

            //now fetch data from excel


            csvfile.close();
            excelfile.close();
            System.out.println("File Converted");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
