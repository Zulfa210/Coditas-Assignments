import javax.servlet.ServletContext;
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
@WebServlet("/update")
public class UpdateEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        ServletContext application = req.getServletContext();

        application.setAttribute("id", id);
        out.println("<a href='UpdateData.html?id="+ id+"'> Update Name </a><br>");
        out.println("<a href='UpdateUsername.html?id=" +id+ "'> Update Username </a><br>");
        out.println("<a href='UpdateCity.html?id="+id+"'> Update City </a><br>");
    }
}
