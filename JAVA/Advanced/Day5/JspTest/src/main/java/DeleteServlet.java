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
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            connection = ConnectionMaker.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

            out.println("Deleted SuccessFully Successfully");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("showAll");
            requestDispatcher.include(req, resp);




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
