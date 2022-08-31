package week7.Day27;

import java.sql.*;
import java.util.Scanner;

/**
 * 11)check the concept of savepoint() and try to implement it using a simple example.
 * Add the output of every different scenario.
 * @author Zulfa Attar
 */
class SavepointRollback {
    Connection connection;
    ResultSet resultSet;
    Statement statement;

    void commitRollback() {
        try {
            Scanner scanner = new Scanner(System.in);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");
            connection.setAutoCommit(false);

            showRecords();

            PreparedStatement preparedStatement = connection.prepareStatement("delete from teacher where id = ?");
            int choice = 1;
            do {
                Savepoint beforeDeleting = connection.setSavepoint();
                System.out.println("Enter Teacher id to delete: ");
                preparedStatement.setInt(1, scanner.nextInt());

                preparedStatement.executeUpdate();

                resultSet = preparedStatement.executeQuery("Select * from teacher");
                System.out.printf("%-10s" + "%-20s" + "%-20s" + '\n', "ID ", "NAME", "DESIGNATION");
                while (resultSet.next()) {
                    System.out.printf("%-10s" + "%-20s" + "%-20s" + '\n',
                            resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                }
                System.out.println("Press 1 to Commit and 2 to Rollback");

                int commitOrRollback = scanner.nextInt();
                connection.setAutoCommit(false);
                if (commitOrRollback == 1) {
                    connection.commit();


                } else {
                    connection.rollback(beforeDeleting);

                }
                showRecords();
                System.out.println("Do you want to delete more records? 1.Yes 2.No");
                choice = scanner.nextInt();


            } while (choice != 2);

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
public class Q11_SavePointDemo {
    public static void main(String[] args) {
        new SavepointRollback().commitRollback();
    }
}

/*
Output:
ID        NAME                DESIGNATION
1         Zulfa               Teacher
2         Adi                 Trainer
3         Shubh               Professor
4         Dev                 associate
5         Ayush               Trainer
6         Abhi                Teacher
Enter Teacher id to delete:
6
ID        NAME                DESIGNATION
1         Zulfa               Teacher
2         Adi                 Trainer
3         Shubh               Professor
4         Dev                 associate
5         Ayush               Trainer
Press 1 to Commit and 2 to Rollback
1
ID        NAME                DESIGNATION
1         Zulfa               Teacher
2         Adi                 Trainer
3         Shubh               Professor
4         Dev                 associate
5         Ayush               Trainer
Do you want to delete more records? 1.Yes 2.No
1
Enter Teacher id to delete:
5
ID        NAME                DESIGNATION
1         Zulfa               Teacher
2         Adi                 Trainer
3         Shubh               Professor
4         Dev                 associate
Press 1 to Commit and 2 to Rollback
2
ID        NAME                DESIGNATION
1         Zulfa               Teacher
2         Adi                 Trainer
3         Shubh               Professor
4         Dev                 associate
5         Ayush               Trainer
Do you want to delete more records? 1.Yes 2.No
2


Process finished with exit code 0

 */