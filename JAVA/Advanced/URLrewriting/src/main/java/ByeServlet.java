import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Zulfa Attar
 */
@WebServlet("/ByeServlet")
public class ByeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();


        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<center><h3>Bye " + session.getAttribute("sessionName") + "<br>" +
                "Logged Out Successfully! </h3>");
        session.invalidate();
        out.println("<a href='index.html'> Click here to Login Again</a></center>");
    }
}
