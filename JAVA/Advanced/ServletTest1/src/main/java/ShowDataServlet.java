import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author Zulfa Attar
 */
@WebServlet("/Showdata")
public class ShowDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<center><h2>Welcome " + getServletContext().getAttribute("Username") + "</h2><center>");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "zulfa123");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from candidate");


            out.println("<br>");
            String name = (String) getServletContext().getAttribute("Username");
            String password = (String) getServletContext().getAttribute("userPassword");
            while (resultSet.next()) {


                if (name.equals(resultSet.getString(1)) &&
                        (password.equals(resultSet.getString(6)))) {

                    out.println("<center><table border = 1 bordercolor='grey'>");
                    out.println("<tr><td>First Name</td><td>" + resultSet.getString(1) + "</td></tr>");
                    out.println("<tr><td>Last Name</td><td>" + resultSet.getString(2) + "</td></tr>");
                    out.println("<tr><td>Mobile No.:</td><td>" + resultSet.getInt(3) + "</td></tr>");
                    out.println("<tr><td>City</td><td>" + resultSet.getString(4) + "</td></tr>");
                    out.println("<tr><td>Education</td><td>" + resultSet.getString(5) + "</td></tr></center>");



                }

            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
