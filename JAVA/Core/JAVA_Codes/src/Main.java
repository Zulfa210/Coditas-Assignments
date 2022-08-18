import java.io.*;

public class Main {
    public static void main(String[] args) {


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("gstData.csv"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("gst.xlsx"));

            String s = null;
            while(true) {
                s = bufferedReader.readLine();
                if(s == null)
                    break;
                bufferedWriter.write(s);
                bufferedWriter.newLine();

            }

            bufferedReader.close();
            bufferedWriter.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {

        }
    }
}