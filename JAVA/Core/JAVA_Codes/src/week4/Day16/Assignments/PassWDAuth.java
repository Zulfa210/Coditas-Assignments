package week4.Day16.Assignments;
/**
 * Q.6)Explore this code,execute t,pass the arguments for CLI
 * >add code for case:lf access granted,
 * print that file data in console.
 *
 * @author Zulfa Attar
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class PassWDAuth {
    public static void main(String args[]) {
        try {
            String logFileName = args[0];
            File f = new File(logFileName);
            boolean access_granted = false;
            String password = "";

            if (args.length == 2) {
                System.out.println("Checking command-line password");
                password = password + args[1];

                if (password.equals("3dTAqb.7")) {
                    access_granted = true;
                    System.out.println("Password matches.");
                } else {
                    System.out.println("Command-1ine password does not match");
                }
            }//end i
            if (access_granted) {
                System.out.println("Access granted!");

                PrintWriter out = new PrintWriter(new FileOutputStream(f, true));
                out.println();
                out.print("Updated...");
                out.println();
                out.flush();
                out.close();
                int i;
                FileReader fileReader = new FileReader(f);
                while ((i=fileReader.read()) != -1){
                    System.out.print((char)i);
                }

                fileReader.close();
            }
        }//end try
        catch (Exception e) {
            System.out.println("an error has occured.");
        }
    }
}//end class

/*
Output:
Checking command-line password
Password matches.
Access granted!

Updated...

Process finished with exit code 0
 */