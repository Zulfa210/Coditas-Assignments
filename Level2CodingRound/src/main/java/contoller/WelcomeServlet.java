package contoller;

import bean.Student;
import bean.Subject;
import dao.DaoOperationsImplementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out  = resp.getWriter();

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
        DaoOperationsImplementation Operations = context.getBean("operations", DaoOperationsImplementation.class);
        List<List<Student>> studentList = new ArrayList<>();

        studentList = Operations.showStudentData();
out.println("<table>");
        out.println("<tr>");
        out.println("<td>" + "Student Id" + "</td>");
        out.println("<td>" + "student ID" + "</td>");
        out.println("<td>" + "city" + "</td>");
        out.println("<td>" + "mobile" + "</td>");
        out.println("<td>" + "Subjects" + "</td>");
        out.println("<td>" + "Percentage" + "</td>");
        out.println("<.td>");

        for(List<Student> students: studentList){
            float sum = 0;
            for(Student student: students){
                out.println("<tr>");
                out.println("<td>" + student.getStudentId() + "</td>");
                out.println("<td>" + student.getStudentName() + "</td>");
                out.println("<td>" + student.getStudentCity() + "</td>");
                out.println("<td>" + student.getStudentMobileNo() + "</td>");
                out.println("<td>");
                for(Subject subject: student.getSubjectList()){
                    out.println(subject.getSubjectName()+ ": " + subject.getSubjectMarks());
                    sum = sum+subject.getSubjectMarks();
                }
                float percentage = sum/ student.getSubjectList().size();
                out.println(percentage);
                out.println("</td>");

                out.println("/tr");
            }
            out.println("</table>");
        }

        out.println("<a href ='InsertStudent'>Add student</a>");
        out.println("<a href ='InsertSubject'>Add subject</a>");
        out.println("<a href ='InsertMarks'>Add Marks</a>");

    }
}
