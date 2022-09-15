package Operations;

import ConnectionMaker.ConnectionMaker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author Zulfa Attar
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String city = req.getParameter("city");

        try {
            connection = ConnectionMaker.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into employee values (?,?,?,?,?,?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, city);
            preparedStatement.setString(6, "user");
            preparedStatement.executeUpdate();

            out.println("Inserted Successfully");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("showAll");
            requestDispatcher.include(req, resp);




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
