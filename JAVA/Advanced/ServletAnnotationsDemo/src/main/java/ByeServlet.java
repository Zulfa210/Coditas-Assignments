import javax.servlet.ServletConfig;
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
@WebServlet("/Bye")
public class ByeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String pass = req.getParameter("password");
        PrintWriter writer = resp.getWriter();

        String pageName = "Bye Page";

        ServletContext servletContext = getServletContext();

        String applicationName = (String) servletContext.getAttribute("ApplicationName");
        String name = (String) servletContext.getAttribute("Username");

        writer.println("<center><h1>" + applicationName + "</h1></center>");
        writer.println("<center><h2>" + pageName + "</h2></center>");
        writer.println("<hr>");
        writer.println("Bye :: " + name);


    }
}

