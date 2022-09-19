package Operations;

import ConnectionMaker.ConnectionMaker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Zulfa Attar
 */
@WebServlet("/TeacherLogin")
public class TeacherLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = ConnectionMaker.getConnection();

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String username = req.getParameter("teacherUsername");
        String password = req.getParameter("teacherPassword");

        HttpSession session = req.getSession();
        session.setAttribute("teacherUsername",username );
        session.setAttribute("teacherPassword",password );

        int flag = 1;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from teacher");

            while(resultSet.next()) {
                if (username.equals(resultSet.getString(2)) &&
                        password.equals(resultSet.getString(3))) {

                    flag = 0;

                    session.setAttribute("username",username );
                    session.setAttribute("password",password );
                    session.setAttribute("id", resultSet.getInt(1));
                    session.setAttribute("name",resultSet.getString(4) );
                    session.setAttribute("aboutMe",resultSet.getString(5) );
                    session.setAttribute("testimonial", resultSet.getString(6));
                    session.setAttribute("age", resultSet.getInt(7));
                    session.setAttribute("address", resultSet.getString(8));
                    session.setAttribute("doj", resultSet.getString(9));
                    session.setAttribute("mobile", resultSet.getString(10));
                    session.setAttribute("photo",resultSet.getString(11));


                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("TeacherProfile.jsp");
                    requestDispatcher.forward(req, resp);


                }
            }
            if(flag == 1){
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginPage.html");
                requestDispatcher.include(req, resp);
                out.println("<center>Invalid Credentials</center>");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
