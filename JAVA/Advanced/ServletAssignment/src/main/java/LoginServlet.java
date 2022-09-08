import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
        getServletContext().setAttribute("userPassword", pass);
        ServletContext servletContext = getServletContext();


        try {

            String className = (String) servletContext.getAttribute("Driver");
            String url = (String) servletContext.getAttribute("URL");
            String userName = (String) servletContext.getAttribute("username");
            String password = (String) servletContext.getAttribute("password");

            Class.forName(className);
            connection = DriverManager.getConnection(url, userName, password);
            servletContext.setAttribute("connection", connection);

            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from user");


            int flag = 0;
            writer.println("<br>");
            while (resultSet.next()) {


                if (((String) servletContext.getAttribute("Username")).equals(resultSet.getString(1)) &&
                        ((String) servletContext.getAttribute("userPassword")).equals(resultSet.getString(2))) {


                    flag = 1;
//                    String applicationName = (String) servletContext.getAttribute("ApplicationName");
//                    writer.println("<html>" + "<body>" + "<center><h1>" + applicationName + "</h1></center>");
//                    writer.println("<center><h2>" + pageName + "</h2></center>");
//                    writer.println("<hr>");
//                    writer.println("<label style='position: absolute;right: 10px;top: 5px; color: red'>" + name + "</label>");
//
//                    writer.println("<form id ='f1' action=\"Bye\" method=\"post\" >");
//
//                    writer.println("<a href='logout' style='display: block;margin-left: auto;margin-right: 0;'>Click Here for Logout Page</a>");

                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("WelcomeServlet");
                    requestDispatcher.forward(req, resp);
                }

            }
            if (flag == 0) {

                RequestDispatcher rd = req.getRequestDispatcher("/index.html");

                rd.include(req, resp);
                writer.print("<h3 style = 'color:red; margin-left: 40%;'>Invalid Credentials</h3>");
//                writer.println("<h4>Invalid Credentials</h4>");
//                writer.println("<a href='index.html' style='display: block;margin-left: auto;margin-right: 0;'>Click Here for Login Page</a>");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        writer.println("</form></body></html>");
    }
}


