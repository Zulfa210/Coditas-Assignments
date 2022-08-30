package week6.Day25;

import java.sql.*;

/**
 * @author Zulfa Attar
 */

public class jdbcDemo {
    public static void main(String[] args) {

        Connection connection;
        Statement statement;
        ResultSet resultSet;
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

            PreparedStatement preparedStatement = connection.prepareStatement("update student set city=? where id = ?");


           int z = preparedStatement.executeUpdate();

            resultSet = statement.executeQuery("Select * from student");

            System.out.println("ID "+ "\t||\t" + "NAME" + "\t||\t" + "STREET NAME" + "\t||\t" + "CITY NAME" + "\t||\t" + "PINCODE");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + "\t||\t" + resultSet.getString(2) + "\t||\t"
                        +resultSet.getString(3) + "\t||\t" +
                        resultSet.getString(4) + "\t||\t" + resultSet.getInt(5));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
