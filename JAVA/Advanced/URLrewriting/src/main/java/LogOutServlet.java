import javax.servlet.RequestDispatcher;
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
@WebServlet("/logOut")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");


        if(session.isNew()){
            out.println("You are a new User");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
            requestDispatcher.include(req, resp);
        }
        else {

           req.getRequestDispatcher("ByeServlet").forward(req,resp);
        }
    }
}
