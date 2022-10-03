package contoller;

import bean.Student;
import bean.Subject;
import dao.DaoOperationsImplementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/InsertSubject")
public class InsertSubject extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out  = resp.getWriter();

        String subjectName = req.getParameter("subjectName");
        int subjectID = Integer.parseInt(req.getParameter("subjectID"));


        if(isStringOnlyAlphabet(subjectName)){
            ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
            DaoOperationsImplementation Operations = context.getBean("operations", DaoOperationsImplementation.class);
            Subject subject = new Subject();
            subject.setSubjectId(subjectID);
            subject.setSubjectName(subjectName);

            int checkInsert = Operations.insertSubject(subject);

            if(checkInsert >0){
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("Welcome");
                requestDispatcher.include(req, resp);
                out.println("subject Inserted");
            }else {
                out.println("error");
            }
        }
        else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("InsertStudent.html");
            requestDispatcher.include(req, resp);
            out.println("Numbers not allowed in Student name");
        }
    }

    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((!str.equals(""))
                && (str != null)
                && (str.matches("^[a-zA-Z]*$")));
    }
}
