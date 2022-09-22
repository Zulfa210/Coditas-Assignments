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
@WebServlet("/Delete")
public class DeleteStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int id= Integer.parseInt(req.getParameter("id"));
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
        StudentDao studentDao = context.getBean("student", StudentDao.class);

        int check = studentDao.deleteStudent(id);
        if(check >0){
            out.println("Deleted Successfully");
            req.getRequestDispatcher("Welcome").forward(req, resp);
        }else{
            out.println("Error");
            req.getRequestDispatcher("Welcome").forward(req, resp);
        }

    }
}
