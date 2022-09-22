package com.contoller;

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
@WebServlet("/Update")
public class UpdateStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int id= Integer.parseInt(req.getParameter("id"));
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
        StudentDao studentDao = context.getBean("student", StudentDao.class);

        String field = req.getParameter("field");
        int check;
        if(field.equals("name")) {

        String name = req.getParameter("value");
            check = studentDao.updateStudentName(id,name);
            if (check > 0) {
                req.getRequestDispatcher("Welcome").include(req, resp);
                out.println("<center>Updated Name Successfully</center>");
            } else {
                out.println("Error");
                req.getRequestDispatcher("Welcome").forward(req, resp);
            }
        }else if(field.equals("mobileno")) {

            String mobileNo = req.getParameter("value");
            check = studentDao.updateStudentMobile(id,mobileNo);
            if (check > 0) {
                req.getRequestDispatcher("Welcome").include(req, resp);
                out.println("<center>Updated Mobile No. Successfully</center>");
            } else {
                out.println("Error");
                req.getRequestDispatcher("Welcome").forward(req, resp);
            }
        }else if(field.equals("city")) {

            String city = req.getParameter("value");
            check = studentDao.updateStudentCity(id,city);
            if (check > 0) {
                req.getRequestDispatcher("Welcome").include(req, resp);
                out.println("<center>Updated City Successfully<center>");
            } else {
                out.println("Error");
                req.getRequestDispatcher("Welcome").forward(req, resp);
            }
        }else if(field.equals("percentage")) {

            float percentage = Float.parseFloat(req.getParameter("value"));
            check = studentDao.updateStudentPercentage(id,percentage);
            if (check > 0) {
                req.getRequestDispatcher("Welcome").include(req, resp);
                out.println("<center>Updated Percentage Successfully<center>");

            } else {
                out.println("Error");
                req.getRequestDispatcher("Welcome").forward(req, resp);
            }
        }

    }
}
