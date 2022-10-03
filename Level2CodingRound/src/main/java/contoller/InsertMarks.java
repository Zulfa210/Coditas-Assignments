package contoller;

import bean.Student;
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
@WebServlet("/InsertMarks")
public class InsertMarks extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out  = resp.getWriter();

        int subjectID = Integer.parseInt(req.getParameter("studentID"));
        float marks = Float.parseFloat(req.getParameter("subjectMarks"));
        int studentId = Integer.parseInt(req.getParameter("subjectId"));



            ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
            DaoOperationsImplementation Operations = context.getBean("operations", DaoOperationsImplementation.class);

            int checkInsert = Operations.insertSubjectMarks(studentId, subjectID,marks);

            if(checkInsert >0){
                out.println("Student Inserted");
            }else {
                out.println("error");
            }
        }




    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((!str.equals(""))
                && (str != null)
                && (str.matches("^[a-zA-Z]*$")));
    }
}
