package week7.Day27;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Zulfa Attar
 */

class CheckSensitivity{
    Connection connection;
    ResultSet resultSet;
    Scanner scanner = new Scanner(System.in);
    void checkTypeScrollSensitive(){

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);


            System.out.println("\nBefore Updation: ");
             resultSet = statement.executeQuery("Select * from teacher");

            System.out.printf("%-10s"+ "%-20s" + "%-20s"  + '\n',"ID ", "NAME" ,"DESIGNATION");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s" +  '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3));
            }
            System.out.println("This is TYPE_SCROLL_SENSITIVE ");
            System.out.println("Update data in your database\nPress y when done");
            String stats = scanner.next();



            resultSet.absolute(1);

            System.out.println("After Updation: ");


            System.out.printf("%-10s"+ "%-20s" + "%-20s"  + '\n',"ID ", "NAME" ,"DESIGNATION");
            while (resultSet.next()){
                resultSet.refreshRow();
                System.out.printf("%-10s"+ "%-20s" + "%-20s" +  '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    void checkTypeScrollInsensitive(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);


            System.out.println("\nBefore Updation: ");
            ResultSet resultSet = statement.executeQuery("Select * from teacher");

            System.out.printf("%-10s"+ "%-20s" + "%-20s"  + '\n',"ID ", "NAME" ,"DESIGNATION");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s" +  '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3));
            }
            System.out.println("This is TYPE_SCROLL_INSENSITIVE ");
            System.out.println("Update data in your database\nPress y when done");
            String stats = scanner.next();


            resultSet.absolute(1);

            System.out.println("After Updation: ");


            System.out.printf("%-10s"+ "%-20s" + "%-20s"  + '\n',"ID ", "NAME" ,"DESIGNATION");
            while (resultSet.next()){
                resultSet.refreshRow();
                System.out.printf("%-10s"+ "%-20s" + "%-20s" +  '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

class Insensitive{

}
public class Q6_TypeScrollSensitiveDemo {
    public static void main(String[] args) {

        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter which statement you want to check: " +
                    "\n1.TYPE_SCROLL_SENSITIVE " +
                    "\n2.TYPE_SCROLL_INSENSITIVE " +
                    "\n0.Exit");
            choice = scanner.nextInt();

            switch (choice){
                case 0:
                    System.exit(0);

                case 1:
                    new CheckSensitivity().checkTypeScrollSensitive();
                    break;

                case 2:
                    new CheckSensitivity().checkTypeScrollInsensitive();
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }


        }while (choice!=0);
    }
}

/*
Output:
Before Updation:
ID        NAME                DESIGNATION
1         Zulfa               Teacher
2         Adi                 Trainer
3         Shubh               Professor
Update data in your database
Press y when done
y
After Updation:
ID        NAME                DESIGNATION
1         Zulfa               Teacher
2         Adi                 Trainer
3         Shubh               Professor
4         Dev                 Associate

Process finished with exit code 0
 */