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
@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "zulfa123");


        String name= req.getParameter("username");
        String password = req.getParameter("password");

            getServletContext().setAttribute("Username", name);
            getServletContext().setAttribute("userPassword", password);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from candidate");


        int flag = 0;
        writer.println("<br>");
        while (resultSet.next()) {


            if (name.equals(resultSet.getString(1)) &&
                    (password.equals(resultSet.getString(6)))) {


                flag = 1;

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("Showdata");
                requestDispatcher.forward(req, resp);
            }

        }
        if (flag == 0) {

            RequestDispatcher rd = req.getRequestDispatcher("/LoginServlet");

            rd.include(req, resp);
            writer.print("<h3 style = 'color:red; margin-left: 40%;'>Invalid Credentials</h3>");
     }

    } catch (
    SQLException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    }
}
