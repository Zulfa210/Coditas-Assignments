package week7.Day26.Assignments;

/**
 * Q.5) Try to add image in Database
 * @author Zulfa Attar
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Question3 {
    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "zulfa123");

            PreparedStatement statement = connection.prepareStatement("insert into image_table values(?,?)");

            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Coditas\\Pictures\\Saved Pictures\\git11.png");

            statement.setInt(1,11);
            statement.setBinaryStream(2, fileInputStream, fileInputStream.available());

            int status = statement.executeUpdate();

            connection.close();

            System.out.println(status);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
