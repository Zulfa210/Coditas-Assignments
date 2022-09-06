
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Zulfa Attar
 */
public class AdditionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        int firstNumber  = Integer.parseInt(req.getParameter("firstNumber"));
        int secondNumber  = Integer.parseInt(req.getParameter("secondNumber"));
        int sum  = firstNumber + secondNumber;
        writer.println("Addition is " + sum);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doGet(req, resp);
    }
}
