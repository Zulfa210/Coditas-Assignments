package com.contoller;

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
@WebServlet("/UpdateMenu")
public class UpdateMenu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int id= Integer.parseInt(req.getParameter("id"));
        RequestDispatcher rd = req.getRequestDispatcher("Welcome");
        rd.include(req,resp);
        out.println("<center><div style='border:2px solid black; width:40%; margin-top:20px; margin-bottom'>" +
                "<h3>Updating Student of Id "+id+"</h3><form action='Update?id="+id+"' method=post>" +
                "Select Field: &nbsp;&nbsp;" +
                "<select name ='field'>" +
                "<option value='name'>Name</option>" +
                "<option value='mobileno'>Mobile no. </option>" +
                "<option value='city'>City</option>" +
                "<option value='percentage'>Percentage</option></select><br>" +
                "Enter new Value: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "<input type='text' name='value'><br>" +
                "<input type='submit' value='Update'></form>");
        out.println("</center>");
    }
}
