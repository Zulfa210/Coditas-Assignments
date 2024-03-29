import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Zulfa Attar
 */
public class ByeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("userName");
        String pass = req.getParameter("password");
        PrintWriter writer = resp.getWriter();

        ServletConfig servletConfig = getServletConfig();
        String pageName = servletConfig.getInitParameter("pageName");

        ServletContext servletContext = getServletContext();
        String applicationName = servletContext.getInitParameter("ApplicationName");

        writer.println("<center><h1>" + applicationName + "</h1></center>");
        writer.println("<center><h2>" + pageName + "</h2></center>");
        writer.println("<hr>");
        writer.println("Bye :: " + name);


    }
}
