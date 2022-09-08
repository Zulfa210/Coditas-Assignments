import com.mysql.cj.protocol.Resultset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 * @author Zulfa Attar
 */
@WebServlet("/FetchData")
public class FetchDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            Class.forName("com.mysql.jdbc.Driver");
            String url = (String) getServletContext().getAttribute("URL");
            String username = (String) getServletContext().getAttribute("username");
            String password = (String) getServletContext().getAttribute("password");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("select * from user");

            PrintWriter out = resp.getWriter();

            String name = (String) getServletContext().getAttribute("Username");
            out.println("<label style='position: absolute;right: 10px;top: 5px; color: red'>" + name + "</label>");
            out.println("<table border =10px align = center style = 'margin-top:50px; width: 50%'>" +
                    "<tr><th>Username</th><th>Password</th>");
            while (resultset.next()){
                out.println("<tr>" +
                        "<td><center>" + resultset.getString(1) + "</td></center>" +
                        "<td><center>" + resultset.getString(2) + "</td></center></tr>");
            }
            out.println("</table");



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
