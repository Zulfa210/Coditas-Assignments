package week7.Day27;

import java.sql.*;

/**
 * @author Zulfa Attar
 */
class StudentTeacher{
    Connection connection;
    ResultSet resultSet;
    Statement statement;
    void showTeachersAndStudents(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");

            statement = connection.createStatement();
            System.out.println("All Teachers:  ");
            resultSet = statement.executeQuery("Select * from teacher");

            System.out.printf("%-10s"+ "%-20s" + "%-20s"  + '\n',"ID ", "NAME" ,"DESIGNATION");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s" +  '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3));
            }

            System.out.println("\nAll Students:  ");
            resultSet = statement.executeQuery("Select * from studentnew");

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
public class Q8_StudentTeacher1toM {
    public static void main(String[] args) {
        new StudentTeacher().showTeachersAndStudents();
    }
}

/*
Output:
All Teachers:
ID        NAME                DESIGNATION
1         Zulfa               Teacher
2         Adi                 Trainer
3         Shubh               Professor
4         devansh             Associate
5         Ayush               Teacher
6         Abhi                Trainer
7         Usman               Trainer

All Students:
ID        NAME                TEACHER_ID
11        Zaid                2
12        Swaraj              2
13        Anuj                3
14        Abhishek            3
15        Ram                 1
16        Vicky               1
17        Sara                2

Diaplaying Teacher wise Data:
TEACHER_NAME        STUDENT_NAME
Adi                 Zaid
Adi                 Swaraj
Shubh               Anuj
Shubh               Abhishek
Zulfa               Ram
Zulfa               Vicky
Adi                 Sara

Process finished with exit code 0

 */