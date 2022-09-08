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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<form name = \"f1\" method=\"post\" action=\"Welcome\" align='center' style = ' border: 3px solid green;margin-left: 50px; margin-top:50px'>");
        out.println("First Name: <input type=\"text\" name = \"username\" style = 'width: 40%;margin-top:20px;'> <br>");
        out.println(" Password: <input type=\"password\" name=\"password\" style = 'width: 40%;margin-top:20px;'><br>");
        out.println("<input type=\"submit\" value=\"LOGIN\" style = 'background-color: blue;color: white; margin-top:50px;padding: 14px 20px; border: none; width: 20%;'></form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<form name = \"f1\" method=\"post\" action=\"Welcome\" align='center' style = ' border: 3px solid green;margin-left: 50px; margin-top:50px'>");
        out.println("First Name: <input type=\"text\" name = \"username\" style = 'width: 40%;margin-top:20px;'> <br>");
        out.println(" Password: <input type=\"password\" name=\"password\" style = 'width: 40%;margin-top:20px;'><br>");
        out.println("<input type=\"submit\" value=\"LOGIN\" style = 'background-color: blue;color: white; margin-top:50px;padding: 14px 20px; border: none; width: 20%;'></form>");
    }
}
