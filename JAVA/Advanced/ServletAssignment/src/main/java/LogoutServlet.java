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
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        ServletContext application = getServletContext();
        String name = (String) application.getAttribute("Username");
        String pass = (String) application.getAttribute("userPassword");

        PrintWriter out = resp.getWriter();
        out.println("<label style='position: absolute;right: 10px;top: 5px; color: red'>" + name + "</label>");

        out.println("<h2> Name: " + name + "</h2>" );
        out.println("<h2> Password: " + pass + "</h2>");
        out.println("<a href='index.html' style='display: block;margin-left: auto;margin-right: 0;'>LOGOUT</a>");

    }
}
