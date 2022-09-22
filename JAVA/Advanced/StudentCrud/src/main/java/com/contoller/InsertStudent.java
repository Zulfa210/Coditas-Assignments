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

/**
 * @author Zulfa Attar
 */
@WebServlet("/Insert")
public class InsertStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String mobileNo = req.getParameter("mobileNo");
        String city = req.getParameter("city");
        float percentage = Float.parseFloat(req.getParameter("percentage"));

        Student student = new Student();
        student.setStudentId(id);
        student.setStudentName(name);
        student.setMobileNo(mobileNo);
        student.setStudentCity(city);
        student.setStudentPercentage(percentage);

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
        StudentDao studentDao = context.getBean("student", StudentDao.class);

        int check = studentDao.insertStudent(student);
        if(check >0){
            out.println("Inserted Successfully");
            req.getRequestDispatcher("Welcome").include(req, resp);
        }else{
            out.println("Error");
            req.getRequestDispatcher("InsertStudent.html").include(req, resp);
        }


    }
}
