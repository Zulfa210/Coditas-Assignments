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

        out.println("<h1>User Details</h1>");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String course = req.getParameter("course");
        String condition = "";

        condition=   req.getParameter("condition");

        if(condition!=null) {
            if (condition.equals("checked")) {
                out.println("<h2>Name: " + name + "</h2>");
                out.println("<h2>Password: " + password + "</h2>");
                out.println("<h2>Email: " + email + "</h2>");
                out.println("<h2>Gender: " + gender + "</h2>");
                out.println("<h2>Course: " + course + "</h2>");
            }
        }else{
            out.println("<h2>You have not Accepted the terms and conditions<h2>");
            out.println("<a href=\"index.html\"><button type =\"button\">Click here to Register Again</button></a>");
        }
    }
}
