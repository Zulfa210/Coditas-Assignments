import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Zulfa Attar
 */
@WebServlet("/formInfo")
public class FormInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        resp.setIntHeader("refresh", 5);

//        String username = req.getParameter("name");
//        String id = req.getParameter("id");
//        out.println("<form action='logOut?name="+username+"&id=" +id+"' method='post' > " +
//                "<input type = 'hidden' name='userName' value='" + username +"'>" +
//                "<input type = 'hidden' name='userId' value='" + id +"' align = right>");
        out.println("<a href='logOut' style='height:30px; width:100px background-color:blue;' align='right'>LOGOUT</a>");


        out.println("<br><h3>Data from Cookies: <br></h3>");
        String name1= null, id1 = null;
        Cookie cookies[] = req.getCookies();
        if(cookies == null){
            out.println("<h2>You are a new user, Please Sign up!</h2>");
        }
        else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    name1 = cookie.getValue();
                }
                if (cookie.getName().equals("id")) {
                    id1 = cookie.getValue();
                }

            }
            out.println("<h2> Name : " +name1 + "<br>");
            out.println("ID : " + id1 + "</h2>");
        }



        out.println("<br><h3>Data from URL Rewriting: <br></h3>");
        out.println("<h2> Name : " + req.getParameter("name") + "<br>");
        out.println("ID : " + req.getParameter("id") + "</h2>");

        out.println("<br><h3>Data from Hidden Form Fields: <br></h3>");
        out.println("<h2> Name : " + req.getParameter("userName") + "<br>");
        out.println("ID : " + req.getParameter("userId") + "</h2>");

        HttpSession session = req.getSession();


        out.println("<br><h3>Data from HttpSession: <br></h3>");
        out.println("<h2> Name : " + session.getAttribute("sessionName") + "<br>");
        out.println("ID : " + session.getAttribute("sessionId") + "</h2>");
    }
}
