package Operations;

import ConnectionMaker.ConnectionMaker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author Zulfa Attar
 */
@WebServlet("/updateCity")
public class UpdateCityServlet extends HttpServlet {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        ServletContext application = req.getServletContext();

        int id = (int) application.getAttribute("id");

        String name = req.getParameter("city");

        try {
            connection = ConnectionMaker.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update employee set address = ? where id = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();

            out.println("Updated Data SuccessFully");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("showAll");
            requestDispatcher.include(req, resp);




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
