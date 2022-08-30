package week7.Day26;

import javax.swing.*;
import java.sql.*;

/**
 * @author Zulfa Attar
 */

class crudOperations{
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    void createTable(){

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");

            PreparedStatement preparedStatement = connection.prepareStatement("create table Employee (id int, name varchar(50), city varchar(50))");
            preparedStatement.executeUpdate();


            statement = connection.createStatement();

            statement.addBatch("insert into employee values (11, 'Dev','Kanpur')");
            statement.addBatch("insert into employee values (12, 'Usman','UP')");
            statement.addBatch("insert into employee values (13, 'Abhi','Kolkata')");
            statement.executeBatch();
            resultSet = statement.executeQuery("Select * from employee");

            System.out.println("ID "+ "\t||\t" + "NAME" + "\t||\t" + "CITY NAME");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + "\t||\t" + resultSet.getString(2) + "\t||\t"
                        +resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    void insertData(){

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");


            statement = connection.createStatement();



//            PreparedStatement preparedStatement = connection.prepareStatement("insert into student values (?,?,?,?,?,?,?)");
//            preparedStatement.setInt(1,14);
//            preparedStatement.setString(2, "Adi");
//            preparedStatement.setString(3, "MG Road");
//            preparedStatement.setString(4,"Delhi");
//            preparedStatement.setString(5,"211090");
//            preparedStatement.setDate(6, Date.valueOf("2000-11-22"));
//            preparedStatement.setString(7, "Male");


//            statement.addBatch("insert into studentinfo values (14, 'Dev','Kanpur')");
//            statement.addBatch("insert into studentinfo values (15, 'Usman','UP')");
//            statement.addBatch("insert into studentinfo values (16, 'Abhi','Kolkata')");
//
//            statement.executeBatch();
//
            CallableStatement callableStatement = connection.prepareCall("call InsertRecord(11,'Zulfa','Pune')");
            boolean check = callableStatement.execute();
            System.out.println("Check record added or not: " + check);



            resultSet = statement.executeQuery("Select * from studentinfo");

            System.out.println("ID "+ "\t||\t" + "NAME" + "\t||\t" + "CITY NAME");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + "\t||\t" + resultSet.getString(2) + "\t||\t"
                        +resultSet.getString(3));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void deleteData(){

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");
            PreparedStatement preparedStatement  = connection.prepareStatement("delete from studentinfo where id = ?");
            preparedStatement.setInt(1, 11);

            preparedStatement.executeUpdate();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from studentinfo");

            System.out.println("ID "+ "\t||\t" + "NAME" + "\t||\t" + "CITY NAME");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + "\t||\t" + resultSet.getString(2) + "\t||\t"
                        +resultSet.getString(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    void UpdateData(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");

            PreparedStatement preparedStatement = connection.prepareStatement("Update studentinfo set city=? where id =?");
            preparedStatement.setString(1,"Chennai");
            preparedStatement.setInt(2, 12);

            preparedStatement.executeUpdate();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from studentinfo");

            System.out.println("ID "+ "\t||\t" + "NAME" + "\t||\t" + "CITY NAME");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + "\t||\t" + resultSet.getString(2) + "\t||\t"
                        +resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    void showData(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from studentinfo");

            System.out.println("ID "+ "\t||\t" + "NAME" + "\t||\t" + "CITY NAME");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + "\t||\t" + resultSet.getString(2) + "\t||\t"
                        +resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
public class JDBC_Batch {
    public static void main(String[] args) {

        crudOperations crudOperations = new crudOperations();
        crudOperations.insertData();

        }
}
