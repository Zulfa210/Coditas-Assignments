package Operations;

import ConnectionMaker.ConnectionMaker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Zulfa Attar
 */
@WebServlet("/showAll")
public class ShowAllServlet extends HttpServlet {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try {

            connection = ConnectionMaker.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from employee where role='user';");
            out.println("<table border = '1'>");
            out.println("<tr>" +
                    "<td>ID</td> " +
                    "<td>Name</td> " +
                    "<td>Username</td> " +
                    "<td>Address</td> " +
                    "<td> Update</td>" +
                    "</tr>");
            while (resultSet.next()){

                int id  =resultSet.getInt(1);
                out.println("<tr>" +
                        "<td>" + resultSet.getInt(1) + "</td>" +
                        "<td>" + resultSet.getString(2) + "</td>" +
                        "<td>" + resultSet.getString(3) + "</td>" +
                        "<td>" + resultSet.getString(5) + "</td>" +
                        "<td> <a href ='update?id=" +id+"'>Update</a></td>" +

                        "</tr>"
                );
            }
            out.println("</table><br>");
            out.println("<a href = 'InsertData.html' ><button type = 'button'>Insert Employee</button></a>");
            out.println("<a href = 'DeleteData.html' ><button type = 'button'>Delete Employee</button></a>");
            out.println("<a href = 'logOut' ><button type = 'button'>LogOut</button></a>");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
