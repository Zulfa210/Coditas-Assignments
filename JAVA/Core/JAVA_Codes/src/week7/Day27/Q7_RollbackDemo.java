package week7.Day27;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Zulfa Attar
 */
class CommitAndRollback{
    Connection connection;
    ResultSet resultSet;
    Statement statement;
    void commitRollback(){
        try {
            Scanner scanner = new Scanner(System.in);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into teacher values (?,?,?)");
            int choice = 1;
            do{
                System.out.println("Enter Teacher id: ");
                preparedStatement.setInt(1,scanner.nextInt());
                System.out.println("Enter Teacher name: ");
                preparedStatement.setString(2, scanner.next());
                System.out.println("Enter Teacher designation: ");
                preparedStatement.setString(3, scanner.next());

                preparedStatement.executeUpdate();

                resultSet = preparedStatement.executeQuery("Select * from teacher");
                System.out.printf("%-10s"+ "%-20s" + "%-20s" + '\n',"ID ", "NAME" ,"DESIGNATION");
                while (resultSet.next()){
                    System.out.printf("%-10s"+ "%-20s" + "%-20s"  + '\n',
                            resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3)) ;
                }
                System.out.println("Press 1 to Commit and 2 to Rollback");

                int commitOrRollback = scanner.nextInt();
                if(commitOrRollback == 1){
                    connection.setAutoCommit(false);
                    connection.commit();

                    showRecords();
                }
                else{
                    connection.setAutoCommit(false);
                    connection.rollback();
                    showRecords();
                }
                System.out.println("Do you want to add more records? 1.Yes 2.No");
                choice = scanner.nextInt();





            }while (choice !=2);

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    void showRecords(){
        try {
            Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");

            statement = connection2.createStatement();
            resultSet = statement.executeQuery("Select * from teacher");

            System.out.printf("%-10s"+ "%-20s" + "%-20s" + '\n',"ID ", "NAME" ,"DESIGNATION");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s"  + '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3)) ;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
public class Q7_RollbackDemo {
    public static void main(String[] args) {
        new CommitAndRollback().commitRollback();
    }
}

/*
Output:
Enter Teacher id:
11
Enter Teacher name:
sjhs
Enter Teacher designation:
aaa
ID        NAME                DESIGNATION
1         Zulfa               Teacher
2         Adi                 Trainer
3         Shubh               Professor
4         devansh             Associate
5         Ayush               Teacher
6         Abhi                Trainer
11        sjhs                aaa
Press 1 to Commit and 2 to Rollback
2
ID        NAME                DESIGNATION
1         Zulfa               Teacher
2         Adi                 Trainer
3         Shubh               Professor
4         devansh             Associate
5         Ayush               Teacher
6         Abhi                Trainer
Do you want to add more records? 1.Yes 2.No
1
Enter Teacher id:
7
Enter Teacher name:
Usman
Enter Teacher designation:
Trainer
ID        NAME                DESIGNATION
1         Zulfa               Teacher
2         Adi                 Trainer
3         Shubh               Professor
4         devansh             Associate
5         Ayush               Teacher
6         Abhi                Trainer
7         Usman               Trainer
Press 1 to Commit and 2 to Rollback
1
ID        NAME                DESIGNATION
1         Zulfa               Teacher
2         Adi                 Trainer
3         Shubh               Professor
4         devansh             Associate
5         Ayush               Teacher
6         Abhi                Trainer
7         Usman               Trainer
Do you want to add more records? 1.Yes 2.No
2


Process finished with exit code 0
 */