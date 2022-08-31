package week7.Day27;

import java.sql.*;

/**
 * @author Zulfa Attar
 */
class StudentToTeacher{
    Connection connection;
    ResultSet resultSet;
    Statement statement;
    void showTeachersWithStudents(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");

            statement = connection.createStatement();
            System.out.println("All Teachers:  ");
            resultSet = statement.executeQuery("Select * from teacher1");

            System.out.printf("%-10s"+ "%-20s" + "%-20s"  + '\n',"ID ", "NAME" ,"DESIGNATION");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s" +  '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3));
            }

            System.out.println("\nAll Students:  ");
            resultSet = statement.executeQuery("Select * from student1");

            System.out.printf("%-10s"+ "%-20s"  + '\n',"ID ", "NAME");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s"+  '\n',
                        resultSet.getInt(1) , resultSet.getString(2) );
            }

            System.out.println("\nDiaplaying Teacher wise Data:  ");
            resultSet = statement.executeQuery("select t.name, s.name from teacher1 t inner join studentTeacher st on t.id = st.teacher_id inner join student1 s on st.student_id = s.id ;");
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
public class StudentTeacherMtoM {
    public static void main(String[] args) {

        new StudentToTeacher().showTeachersWithStudents();
    }
}

/*
Output:
All Teachers:
ID        NAME                DESIGNATION
11        Adi                 Trainer
12        Shub                Teacher
13        Zulfa               Professor
14        Dev                 Trainer
15        Ayush               Teacher

All Students:
ID        NAME
1         Zaid
2         Swaraj
3         Anuj
4         Abhi
5         Ram
6         Vicky
7         Sara

Diaplaying Teacher wise Data:
TEACHER_NAME        STUDENT_NAME
Adi                 Zaid
Shub                Zaid
Adi                 Swaraj
Shub                Anuj
Adi                 Anuj
Zulfa               Anuj
Dev                 Anuj
Dev                 Abhi

Process finished with exit code 0

 */