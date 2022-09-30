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
@WebServlet("/InsertStudent")
public class InsertStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out  = resp.getWriter();

        String studentName = req.getParameter("studentName");
        long studentMobileNo = Long.parseLong(req.getParameter("mobileNo"));
        String studentCity = req.getParameter("studentCity");
        int studentId = Integer.parseInt(req.getParameter("studentId"));


        if(isStringOnlyAlphabet(studentName)){
            ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
            DaoOperationsImplementation Operations = context.getBean("operations", DaoOperationsImplementation.class);
            Student student = new Student();

            student.setStudentName(studentName);
            student.setStudentCity(studentCity);
            student.setStudentMobileNo(studentMobileNo);
            student.setStudentId(studentId);

            int checkInsert = Operations.insertStudent(student);

            if(checkInsert >0){
                out.println("Student Inserted");
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
