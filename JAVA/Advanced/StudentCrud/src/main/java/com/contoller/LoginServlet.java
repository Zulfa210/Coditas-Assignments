package com.contoller;

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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                String username = req.getParameter("username");
                String password = req.getParameter("password");

                if(username.equals("admin") && password.equals("1234")){
                        req.getRequestDispatcher("Welcome").forward(req,resp);
                }else{
                        req.getRequestDispatcher("index.jsp").include(req,resp);
                        out.println("<center>Invalid Credentials</center>");
                }
        }
}
