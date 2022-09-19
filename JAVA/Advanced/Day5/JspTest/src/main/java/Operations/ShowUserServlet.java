package Operations;

import ConnectionMaker.ConnectionMaker;

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
@WebServlet("/showUser")
public class ShowUserServlet extends HttpServlet {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();


        if(!session.isNew()) {

            PrintWriter out = resp.getWriter();
            try {

                connection = ConnectionMaker.getConnection();
                statement = connection.createStatement();
                int id = (int) (req.getSession().getAttribute("id"));
                resultSet = statement.executeQuery("select * from employee where id =" + id);
                out.println("<table border = '1'>");
                out.println("<tr>" +
                        "<td>ID</td> " +
                        "<td>Name</td> " +
                        "<td>Username</td> " +
                        "<td>Address</td> " +
                        "</tr>");
                while (resultSet.next()) {

                    out.println("<tr>" +
                            "<td>" + resultSet.getInt(1) + "</td>" +
                            "<td>" + resultSet.getString(2) + "</td>" +
                            "<td>" + resultSet.getString(3) + "</td>" +
                            "<td>" + resultSet.getString(5) + "</td>" +
                            "</tr>"
                    );
                }
                out.println("</table>");
                out.println("<a href = 'logOut' ><button type = 'button'>Logout</button></a>");



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {

            resp.sendRedirect("index.html");
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        HttpSession session = req.getSession();
//        PrintWriter out = resp.getWriter();
//        try {
//
//            connection = ConnectionMaker.getConnection();
//            statement = connection.createStatement();
//            int id = (int)(req.getSession().getAttribute("id"));
//            resultSet = statement.executeQuery("select * from employee where id =" + id);
//            out.println("<table border = '1'>");
//            out.println("<tr>" +
//                    "<td>ID</td> " +
//                    "<td>Name</td> " +
//                    "<td>Username</td> " +
//                    "<td>Address</td> " +
//                    "</tr>");
//            while (resultSet.next()){
//
//                out.println("<tr>" +
//                        "<td>" + resultSet.getInt(1) + "</td>" +
//                        "<td>" + resultSet.getString(2) + "</td>" +
//                        "<td>" + resultSet.getString(3) + "</td>" +
//                        "<td>" + resultSet.getString(5) + "</td>" +
//                        "</tr>"
//                );
//            }
//            out.println("</table>");
//            out.println("<a href = 'logOut' ><button type = 'button'>Logout</button></a>");
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
