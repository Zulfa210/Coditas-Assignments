package week7.Day26.Assignments.Question1;

import week7.Day26.Assignments.Question1.Employee;

import java.sql.*;

/**
 * @author Zulfa Attar
 */
public class EmployeeOperations {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

     void addRecords(Employee employee){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");


            PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,employee.employeeId);
            preparedStatement.setString(2,employee.employeeName);
            preparedStatement.setString(3, employee.Designation);
            preparedStatement.setDate(4, Date.valueOf(employee.dateOfJoining));
            preparedStatement.setInt(5, employee.employeeExperience);
            preparedStatement.setFloat(6, employee.salary);
            preparedStatement.setString(7, employee.status);
            preparedStatement.executeUpdate();;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    void showRecords(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from employee");

            System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s" + "%-20s" + "%-20s" + '\n',"ID ", "NAME" ,"DESIGNATION", "DOJ", "EXPERIENCE", "SALARY", "STATUS");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s" + "%-20s" + "%-20s" + '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3)
                        ,resultSet.getString(4) ,resultSet.getString(5) ,resultSet.getString(6)
                        ,resultSet.getString(7)) ;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    void alterTable(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");
            statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement("alter table employee add city varchar(30)");
            preparedStatement.executeUpdate();


            statement.addBatch("update employee set city='Pune' where id = 11");
            statement.addBatch("update employee set city='Mumbai' where id = 12");
            statement.addBatch("update employee set city='Nagpur' where id = 13");
            statement.addBatch("update employee set city='Dehradun' where id = 1");
            statement.addBatch("update employee set city='Kolkata' where id = 15");
            statement.addBatch("update employee set city='Pune' where id = 16");
            statement.addBatch("update employee set city='Delhi' where id = 17");
            statement.addBatch("update employee set city='Mumbai' where id = 18");
            statement.addBatch("update employee set city='Kanpur' where id = 19");
            statement.addBatch("update employee set city='Pune' where id = 20");

            statement.executeBatch();

            resultSet = statement.executeQuery("Select * from employee");

            System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s" + "%-20s" + "%-20s"  + "%-20s"+ '\n',"ID ", "NAME" ,"DESIGNATION", "DOJ", "EXPERIENCE", "SALARY", "STATUS", "CITY");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s" + "%-20s" + "%-20s" + "%-20s" + '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3)
                        ,resultSet.getString(4) ,resultSet.getString(5) ,resultSet.getString(6)
                        ,resultSet.getString(7), resultSet.getString(8)) ;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    void case4ShowEmployee(){

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");
            statement = connection.createStatement();

           resultSet = statement.executeQuery("select * from employee where city like 'Pune' and salary>30000");

            System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s" + "%-20s" + "%-20s"  + "%-20s"+ '\n',"ID ", "NAME" ,"DESIGNATION", "DOJ", "EXPERIENCE", "SALARY", "STATUS", "CITY");
            while (resultSet.next()){
                System.out.printf("%-10s"+ "%-20s" + "%-20s" + "%-20s" + "%-15s" + "%-20s" + "%-20s" + "%-20s" + '\n',
                        resultSet.getInt(1) , resultSet.getString(2) ,resultSet.getString(3)
                        ,resultSet.getString(4) ,resultSet.getString(5) ,resultSet.getString(6)
                        ,resultSet.getString(7), resultSet.getString(8)) ;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    void updateSalary(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");
            System.out.println("\nBefore Updation: ");
            showRecords();
            PreparedStatement preparedStatement = connection.prepareStatement("update employee set salary = salary+1000 where experience>3");
            preparedStatement.executeUpdate();
            System.out.println("\nAfter Updation: ");
            showRecords();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    void deleteEmployeesWhoLeft(){
         try{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");
        System.out.println("\nBefore Updation: ");
        showRecords();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where status like 'left'");
        preparedStatement.executeUpdate();
        System.out.println("\nAfter Updation: ");
        showRecords();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
    }
}
