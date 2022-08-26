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

            //Class.forName("com.mysql//jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");

            statement = connection.createStatement();

            resultSet = statement.executeQuery("Select * from student");

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + ": " + resultSet.getString(2) + ": "
                +resultSet.getString(3) + ": " +
                        resultSet.getString(4) + ": " + resultSet.getInt(5));
            }

//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
