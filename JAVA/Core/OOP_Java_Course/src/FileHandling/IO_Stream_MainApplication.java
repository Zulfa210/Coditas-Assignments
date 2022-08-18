package FileHandling;


import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Zulfa Attar
 */
class IO_Streams{

   public void show(){

       try {
           ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
           //File file1 = new File("Zulfa.txt");
           FileOutputStream fileOutputStream = new FileOutputStream("Zulfa.txt", false);
           String s= "0";
           String ss = JOptionPane.showInputDialog("Enter  your String: ");
           byte b[] = ss.getBytes();
           fileOutputStream.write(b);
           fileOutputStream.close();
//           for(int i =0; i<b.length; i++){
//               fileOutputStream.write(b[i]);
//               System.out.println(b[i]);
//           }
           FileInputStream fileInputStream = new FileInputStream("Zulfa.txt");

           while(true){
               int i = fileInputStream.read();
               if( i == -1 )
                   break;

               System.out.print((char)i);
           }
           fileInputStream.close();


       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

}
class ByteArrayStream_Demo{
    void show(){
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileOutputStream fileOutputStream1 = new FileOutputStream("Zulfa.txt");

            String s = "Hello! My name is Zulfa";
            byte b[] = s.getBytes();

            byteArrayOutputStream.write(b);
            byteArrayOutputStream.writeTo(fileOutputStream1);

            byte b1[] = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b1);

            while(true){
                int i = byteArrayInputStream.read();
                if( i == -1 )
                    break;

                System.out.print((char)i);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class BufferedStreams{
    void show(){
        try {
                FileOutputStream fileOutputStream = new FileOutputStream("Zulfa.txt");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

                String s = "My name is Zulfa";
                byte b[] = s.getBytes();

                bufferedOutputStream.write(b);
                bufferedOutputStream.close();

                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("Zulfa.txt"));

                while (true){
                    int i = bufferedInputStream.read();
                    if(i == -1)
                        break;
                    System.out.print((char) i );
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class DataStreams{


}
class Timer{
    long endTime, startTime;

    public void  checkTime(){
        endTime = System.nanoTime();
    }
}
public class IO_Stream_MainApplication {

    public static void main(String[] args) {

       // BufferedStreams bufferedStreams = new BufferedStreams();
     //   bufferedStreams.show();

//        ByteArrayStream_Demo byteArrayStream_demo = new ByteArrayStream_Demo();
//        byteArrayStream_demo.show();
        IO_Streams io_streams = new IO_Streams();
        io_streams.show();
//        try {
//            int i;
//
//            System.out.println("Enter no");
//            Scanner scanner = new Scanner(System.in);
//
//            i = scanner.nextInt();
//
//            if (i == (int) i) {
//                System.out.println("Integer");
//            } else
//                System.out.println("Float");
//        }
//        catch(InputMismatchException e){
//            e.printStackTrace();
//        }

      //  System.out.println(new DataStreams().show());

    }

}
