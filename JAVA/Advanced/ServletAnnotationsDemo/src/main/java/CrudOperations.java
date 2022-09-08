import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Zulfa Attar
 */
public class CrudOperations {

    public int addRecords(Student student, Connection connection){
        try {



            PreparedStatement preparedStatement = connection.prepareStatement("insert into student values (?,?,?,?,?,?)");
            preparedStatement.setInt(1,student.studentId);
            preparedStatement.setString(2,student.studentName);
            preparedStatement.setString(3, student.studentYear);
            preparedStatement.setFloat(4, student.studentPercentage);
            preparedStatement.setString(5, student.studentCity);
            preparedStatement.setString(6, student.studentGender);

            int x = preparedStatement.executeUpdate();;


            return x;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
