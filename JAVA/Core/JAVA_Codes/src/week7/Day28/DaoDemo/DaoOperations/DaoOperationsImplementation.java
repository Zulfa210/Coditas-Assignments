package week7.Day28.DaoDemo.DaoOperations;


import java.sql.*;
import java.util.Scanner;

import week7.Day28.DaoDemo.DAO.ConnectToDatabase;
import week7.Day28.DaoDemo.StudentPojo.Student;
/**
 * @author Zulfa Attar
 */
public class DaoOperationsImplementation implements DaoOperations {
    Connection connection = ConnectToDatabase.getConnection();

    Statement statement;
    ResultSet resultSet;
    Scanner scanner = new Scanner(System.in);
    public void addStudent() {
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
    public void addRecords(Student student){
        try {


            PreparedStatement preparedStatement = connection.prepareStatement("insert into student values (?,?,?,?,?,?)");
            preparedStatement.setInt(1,student.studentId);
            preparedStatement.setString(2,student.studentName);
            preparedStatement.setString(3, student.studentYear);
            preparedStatement.setFloat(4, student.studentPercentage);
            preparedStatement.setString(5, student.studentCity);
            preparedStatement.setString(6, student.studentGender);

            preparedStatement.executeUpdate();;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void showAllRecords(){
        try {
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


    public void fetchRecordsOfTY(){

        try {

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
    public void fetchRecordsBelow10(){
        try {

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

    public void deleteRecords() {
        try {
            showAllRecords();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id = ?");
            int choice = 1;
            do {
                Savepoint beforeDeleting = connection.setSavepoint();
                System.out.println("Enter Student id to delete: ");
                preparedStatement.setInt(1, scanner.nextInt());

                preparedStatement.executeUpdate();

                showAllRecords();


                System.out.println("Do you want to delete more records? 1.Yes 2.No");
                choice = scanner.nextInt();


            } while (choice != 2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }






}
