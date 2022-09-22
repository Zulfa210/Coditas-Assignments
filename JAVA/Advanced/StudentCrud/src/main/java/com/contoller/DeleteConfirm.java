package com.contoller;

import org.springframework.context.annotation.Primary;

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
@WebServlet("/DeleteConfirm")
public class DeleteConfirm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int id= Integer.parseInt(req.getParameter("id"));
        RequestDispatcher rd = req.getRequestDispatcher("Welcome");
        rd.include(req,resp);
        out.println("<center><div style='border:2px solid black; width:40%; margin-top:20px; margin-bottom'>" +
                "<h3>Are you sure</h3>" +
                "<a href='Delete?id="+id+"'><button type='button'>Yes</button></a> &nbsp;" +
                "<a href='Welcome'><button type='button'>No</button></a> &nbsp;");
        out.println("</center>");

    }
}
