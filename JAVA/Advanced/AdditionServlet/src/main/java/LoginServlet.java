
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author Zulfa Attar
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "zulfa123");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from user");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdditionServlet");
//        requestDispatcher.include(req,resp);
        PrintWriter out = resp.getWriter();
        out.println("<html>" + "<body>" + "<form id ='f1' action=\"Addition\" method=\"post\" >");
        out.println("<label>First Number</label>");
        out.println("<input type='text' placeholder='Enter First Number' name='firstNumber'>");
        out.println("<br><label>Second Number</label>");
        out.println("<input type=\"text\" placeholder=\"Enter Second Number\" name=\"secondNumber\">");
        out.println("<input type=\"submit\" value=\"ADD\">");
        out.println("</form></body></html>");

        String s = "new";

    }
}
