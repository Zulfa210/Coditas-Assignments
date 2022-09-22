package com.contoller;

import com.bean.Student;
import com.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><center>\n" +
                "      <div style= 'border:2px solid black; width:50%; padding-bottom:50px'>\n" +
                "      <h1>Welcome to Student Application</h1>\n" );
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
        StudentDao studentDao = context.getBean("student", StudentDao.class);

        out.println("<table border = '1'>");
        List<Student> studentList = studentDao.fetchAllStudents();
        out.println("<tr>" +
                "<th>ID</th>"+
                "<th>NAME</th>"+
                "<th>MOBILE NO</th>"+
                "<th>CITY</th>"+
                "<th>PERCENTAGE</th>"
        );
        for(Student student: studentList){
            out.println("<tr>");
            out.println("<td>" + student.getStudentId() + "</td>");
            out.println("<td>" + student.getStudentName() + "</td>");
            out.println("<td>" + student.getMobileNo() + "</td>");
            out.println("<td>" + student.getStudentCity() + "</td>");
            out.println("<td>" + student.getStudentPercentage() + "</td>");
            out.println("<td>" + "<a href='DeleteConfirm?id="+student.getStudentId()+"'><button type='button'>Delete Student</button></a><br>" + "</td>");
            out.println("<td>" + "<a href='UpdateMenu?id="+student.getStudentId()+"'><button type='button'>Update Student</button></a><br>" + "</td>");
            out.println("</tr>");
        }
        out.println("</table><div style = 'padding-top:20px'>");
        out.println("<a href='InsertStudent.html'><button type='button'>Insert Student</button></a><br>");
        out.println("</div></div></body></html>");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><center>\n" +
                "      <div style= 'border:2px solid black; width:50%; padding-bottom:50px'>\n" +
                "      <h1>Welcome to Student Application</h1>\n" );
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
        StudentDao studentDao = context.getBean("student", StudentDao.class);

        out.println("<table border = '1'>");
        List<Student> studentList = studentDao.fetchAllStudents();
        out.println("<tr>" +
                "<th>ID</th>"+
                "<th>NAME</th>"+
                "<th>MOBILE NO</th>"+
                "<th>CITY</th>"+
                "<th>PERCENTAGE</th>"
        );
        for(Student student: studentList){
            out.println("<tr>");
            out.println("<td>" + student.getStudentId() + "</td>");
            out.println("<td>" + student.getStudentName() + "</td>");
            out.println("<td>" + student.getMobileNo() + "</td>");
            out.println("<td>" + student.getStudentCity() + "</td>");
            out.println("<td>" + student.getStudentPercentage() + "</td>");
            out.println("<td>" + "<a href='DeleteConfirm?id="+student.getStudentId()+"'><button type='button'>Delete Student</button></a><br>" + "</td>");
            out.println("<td>" + "<a href='UpdateMenu?id="+student.getStudentId()+"'><button type='button'>Update Student</button></a><br>" + "</td>");
            out.println("</tr>");
        }
        out.println("</table><div style = 'padding-top:20px'>");
        out.println("<a href='InsertStudent.html'><button type='button'>Insert Student</button></a><br>");
        out.println("</div></div></body></html>");

    }
}
