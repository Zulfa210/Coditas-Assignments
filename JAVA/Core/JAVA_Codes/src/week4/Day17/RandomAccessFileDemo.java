package week4.Day17;

import java.applet.Applet;
import java.io.RandomAccessFile;

/**
 * @author Zulfa Attar
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) {
        try{
            int i = 28;
            RandomAccessFile raf = new RandomAccessFile("newfile.txt", "rw");

            raf.seek(0);
            raf.write(65);

            raf.seek(0);
            raf.close();
            System.out.println(raf.readInt());

        }catch (Exception e){
        }
    }
}
