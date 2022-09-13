import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Zulfa Attar
 */
@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String username = req.getParameter("name");
        String id = req.getParameter("id");
        out.println("<center><h1>Welcome " + username + "</h1>");
        String name1= null, id1 = null;
        Cookie cookies[] = req.getCookies();
        if(cookies == null){
            out.println("You are a new user, Please Sign up!");
        }
        else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    name1 = cookie.getValue();
                }
            }
        }

        out.println("<center><h2>Hii " + name1 + "</h2>");
        out.println("<form action='formInfo?name="+username+"&id=" +id+"' method='post' > " +
                "<input type = 'hidden' name='userName' value='" + username +"'>" +
                "<input type = 'hidden' name='userId' value='" + id +"'>");
        out.println("<input type = 'submit' value = 'Go to Next Page' style='height:30px; width:100px background-color:blue;'></center>");



    }
}
