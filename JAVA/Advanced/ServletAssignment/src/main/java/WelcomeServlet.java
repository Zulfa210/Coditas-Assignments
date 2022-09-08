import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Zulfa Attar
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        PrintWriter writer = resp.getWriter();
        String applicationName = (String) servletContext.getAttribute("ApplicationName");
        String pageName = "Welcome Page";
        String name = (String) servletContext.getAttribute("Username");
        writer.println("<html>" + "<body>" + "<center><h1>" + applicationName + "</h1></center>");
        writer.println("<center><h2>" + pageName + "</h2></center>");
        writer.println("<hr>");
        writer.println("<label style='position: absolute;right: 10px;top: 5px; color: red'>" + name + "</label>");

        writer.println("<form id ='f1' action=\"Bye\" method=\"post\" >");

        writer.println("<center><a href='logout' style='display: block;margin-left: auto;margin-right: 0;'>Click Here for Logout Page</a>");

        writer.println("<br><a href = 'FetchData'>Click Here To Show Data</a></center");

    }
}
