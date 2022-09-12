import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Zulfa Attar
 */

@WebServlet("/saveForm")
public class SaveFormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("user_name");
        String id = req.getParameter("id");
        Cookie c = new Cookie("name", name);
        resp.addCookie(c);
        c= new Cookie("id", id);
        resp.addCookie(c);

        HttpSession session = req.getSession(true);
        session.setAttribute("sessionName", name);
        session.setAttribute("sessionId", id);

        resp.sendRedirect("Welcome?name=" + name  +"&id=" + id);
    }
}
