import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Zulfa Attar
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("userName");
        String pass = req.getParameter("password");
        PrintWriter writer = resp.getWriter();

        writer.println("Welcome :: ");
        writer.println("<label name = userName >" + name + "</label>");

        writer.println("<html>" + "<body>" + "<form id ='f1' action=\"Bye\" method=\"post\" >");
        writer.println("<input type = 'submit' value= 'Bye'>");
        writer.println("</form></body></html>");
    }
}
