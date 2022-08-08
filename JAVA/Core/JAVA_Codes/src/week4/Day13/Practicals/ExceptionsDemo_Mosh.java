package week4.Day13.Practicals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsDemo_Mosh {
    public static void main(String[] args) {
        FileReader reader = null;

        try {
            reader = new FileReader("abc.txt");
            int value  = reader.read();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
