import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

/**
 * @author Zulfa Attar
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("userName");
        String pass = req.getParameter("password");
        PrintWriter writer = resp.getWriter();

        String pageName = "Welcome Page";

        getServletContext().setAttribute("ApplicationName", "My Application");
        getServletContext().setAttribute("Driver", "com.mysql.jdbc.Driver");
        getServletContext().setAttribute("URL", "jdbc:mysql://localhost:3306/studentdb");
        getServletContext().setAttribute("username", "root");
        getServletContext().setAttribute("password", "zulfa123");
        getServletContext().setAttribute("Username", name);
        ServletContext servletContext = getServletContext();

        String applicationName = (String) servletContext.getAttribute("ApplicationName");

        writer.println("<center><h1>" + applicationName + "</h1></center>");
        writer.println("<center><h2>" + pageName + "</h2></center>");
        writer.println("<hr>");
        writer.println("Welcome :: ");
        writer.println("<label name = userName >" + name + "</label>");

        writer.println("<html>" + "<body>" + "<form id ='f1' action=\"Bye\" method=\"post\" >");



        try {

            String className = (String) servletContext.getAttribute("Driver");
            String url = (String) servletContext.getAttribute("URL");
            String userName = (String) servletContext.getAttribute("username");
            String password = (String) servletContext.getAttribute("password");

            Class.forName(className);
            connection = DriverManager.getConnection(url,userName, password);
            getServletContext().setAttribute("connection", connection);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from student");

            writer.println("<center><table border = 2 bordercolor = 'aqua'><tr>");
            writer.println("<th>ID</th> "+ "<th>NAME </th>" +"<th>DESIGNATION </th>"+"<th>DOJ </th>"
                    + "<th>EXPERIENCE </th>"+ "<th>SALARY </th>"+ "</tr>");
            writer.println("<br>");
            while (resultSet.next()){
                writer.println("<tr>");
                writer.println("<td>" + resultSet.getInt(1) +"</td>"
                        +"<td>" + resultSet.getString(2)+"</td>"
                        +"<td>" + resultSet.getString(3)  +"</td>"
                        +"<td>" +resultSet.getFloat(4)+"</td>"
                        + "<td>" +resultSet.getString(5)+"</td>"
                        +"<td>" + resultSet.getString(6) +"</td>" ) ;
                writer.println("</tr>");
            }
            writer.println("</table></center>");
            writer.println("<input type='submit' value= 'Bye'>");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



        writer.println("</form></body></html>");
    }


}

