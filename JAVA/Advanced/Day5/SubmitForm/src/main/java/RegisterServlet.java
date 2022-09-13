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
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String course = req.getParameter("course");
        String condition = req.getParameter("condition");

        if(condition.equals("checked")){
            out.println("<h2>Name: " + name + "</h2>");
            out.println("<h2>Password: " + password + "</h2>");
            out.println("<h2>Email: " + email + "</h2>");
            out.println("<h2>Gender: " + gender + "</h2>");
            out.println("<h2>Course: " + course + "</h2>");
        }
        else{
            out.println("You have not Accepted the terms and conditions");
        }

    }
}
