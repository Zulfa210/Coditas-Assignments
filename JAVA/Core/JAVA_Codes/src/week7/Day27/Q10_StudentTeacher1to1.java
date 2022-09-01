package week7.Day27;

import java.sql.*;

/**
 * Q.10)create table Teacher student using 1-1 relationship (Personal coaching)
 * @author Zulfa Attar
 */
class Student1Teacher{
    Connection connection;
    ResultSet resultSet;
    Statement statement;
    void showTeachersAndStudents(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");

            statement = connection.createStatement();
            System.out.println("All Teachers:  ");
            resultSet = statement.executeQuery("Select * from teacher2");

            System.out.printf("%-10s"+ "%-20s" + "%-20s"  + '\n',"ID ", "NAME" ,"STUDENT_ID");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s" +  '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3));
            }

            System.out.println("\nAll Students:  ");
            resultSet = statement.executeQuery("Select * from student2");

            System.out.printf("%-10s"+ "%-20s" + "%-20s"  + '\n',"ID ", "NAME" ,"TEACHER_ID");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s" +  '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3));
            }

            System.out.println("\nDiaplaying Teacher wise Data:  ");
            resultSet = statement.executeQuery("select t.name as Teacher_Name, s.name as Student_name from teacher t inner join studentnew s on t.id = s.teacher_id");
            System.out.printf("%-20s" + "%-20s"  + '\n',"TEACHER_NAME", "STUDENT_NAME");
            while (resultSet.next()){
                System.out.printf("%-20s" + "%-20s" +  '\n',
                        resultSet.getString(1) , resultSet.getString(2) );

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
public class Q10_StudentTeacher1to1 {
    public static void main(String[] args) {

    }
}
