package week7.Day26.Assignments.Question2;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Zulfa Attar
 */
public class StudentOperations{
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    Scanner scanner = new Scanner(System.in);
    void addStudent() {
        System.out.println("Enter the number of Students you want to add: ");
        int noOfStudents = scanner.nextInt();

        for (int i = 0; i < noOfStudents; i++) {

            System.out.println("Enter Student id: ");
            int id = scanner.nextInt();
            System.out.println("Enter Student name: ");
            String name = scanner.next();
            System.out.println("Enter Student year: ");
            String year = scanner.next();
            System.out.println("Enter Student percentage: ");
            float percentage = scanner.nextFloat();
            System.out.println("Enter Student city: ");
            String city = scanner.next();
            System.out.println("Enter Student gender: ");
            String gender = scanner.next();
            Student student  = new Student(id,name,year,percentage,city,gender);


            addRecords(student);
        }
        showAllRecords();
    }
    void addRecords(Student student){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "zulfa123");


            PreparedStatement preparedStatement = connection.prepareStatement("insert into student values (?,?,?,?,?,?)");
            preparedStatement.setInt(1,student.studentId);
            preparedStatement.setString(2,student.studentName);
            preparedStatement.setString(3, student.studentYear);
            preparedStatement.setFloat(4, student.studentPercentage);
            preparedStatement.setString(5, student.studentCity);
            preparedStatement.setString(6, student.studentGender);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    void showAllRecords(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "zulfa123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from student");

            System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s"+ "%-15s" + '\n',"ID ", "NAME" ,"YEAR", "PERCENTAGE", "CITY", "GENDER");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s" + "%-15s"  + '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3)
                        ,resultSet.getFloat(4) ,resultSet.getString(5), resultSet.getString(6)) ;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void alterTable(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "zulfa123");
            statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement("alter table student add gender varchar(10)");
            preparedStatement.executeUpdate();


            statement.addBatch("update student set gender='female' where id = 1");
            statement.addBatch("update student set gender='male' where id = 2");
            statement.addBatch("update student set gender='male' where id = 3");
            statement.addBatch("update student set gender='male' where id = 14");
            statement.addBatch("update student set gender='male' where id = 15");
            statement.addBatch("update student set gender='female' where id = 16");

            statement.executeBatch();

            resultSet = statement.executeQuery("Select * from student");

            System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s"+ "%-15s" + '\n',"ID ", "NAME" ,"YEAR", "PERCENTAGE", "CITY", "GENDER");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s" + "%-15s"  + '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3)
                        ,resultSet.getFloat(4) ,resultSet.getString(5), resultSet.getString(6)) ;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    void fetchRecordsOfTY(){

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "zulfa123");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from student where year like 'TY' and percentage>70");
            System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s"+ "%-15s" + '\n',"ID ", "NAME" ,"YEAR", "PERCENTAGE", "CITY", "GENDER");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s" + "%-15s"  + '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3)
                        ,resultSet.getFloat(4) ,resultSet.getString(5), resultSet.getString(6)) ;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
    void fetchRecordsBelow10(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "zulfa123");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from student where id>=1 and id<=10");
            System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s"+ "%-15s" + '\n',"ID ", "NAME" ,"YEAR", "PERCENTAGE", "CITY", "GENDER");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s" + "%-15s"  + '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3)
                        ,resultSet.getFloat(4) ,resultSet.getString(5), resultSet.getString(6)) ;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void removeLastYearStudents(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "zulfa123");

            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where year like ?");
            preparedStatement.setString(1,"TY");
            preparedStatement.executeUpdate();

            showAllRecords();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void addPrefixToName(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "zulfa123");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from student where gender like 'male'");

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = "Mr. " + resultSet.getString(2);
                PreparedStatement preparedStatement = connection.prepareStatement("update student set name = ? where id = ?");
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,id);
                preparedStatement.executeUpdate();
            }

            resultSet = statement.executeQuery("select * from student where gender like 'female'");

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = "Ms. " + resultSet.getString(2);
                PreparedStatement preparedStatement = connection.prepareStatement("update student set name = ? where id = ?");
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,id);
                preparedStatement.executeUpdate();
            }

            showAllRecords();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
