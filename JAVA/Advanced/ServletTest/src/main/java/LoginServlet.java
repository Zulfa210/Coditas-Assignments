import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

/**
 * @author Zulfa Attar
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<form name = \"f1\" method=\"post\" action=\"Welcome\">");
        out.println("First Name: <input type=\"text\" name = \"username\">");
        out.println(" Password: <input type=\"password\" name=\"password\">");
        out.println("<input type=\"submit\" value=\"REGISTER\"></form>");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<form name = \"f1\" method=\"post\" action=\"Welcome\">");
        out.println("First Name: <input type=\"text\" name = \"username\">");
        out.println(" Password: <input type=\"password\" name=\"password\">");
        out.println("<input type=\"submit\" value=\"REGISTER\"></form>");
    }
}
