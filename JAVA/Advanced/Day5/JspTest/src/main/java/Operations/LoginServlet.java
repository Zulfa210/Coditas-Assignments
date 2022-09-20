package Operations;

import ConnectionMaker.ConnectionMaker;
import ConnectionMaker.ConnectionParamters;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author Zulfa Attar
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
Connection connection;
Statement statement;
ResultSet resultSet;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        session.setAttribute("username",username );
        session.setAttribute("password",password );

        int flag = 1;
        try {

            connection = ConnectionMaker.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from employee");

            while(resultSet.next()) {
                if (username.equals(resultSet.getString(3)) &&
                        password.equals(resultSet.getString(4))) {

                    flag = 0;
                    if(resultSet.getString(6).equals("admin")){
                        RequestDispatcher requestDispatcher = req.getRequestDispatcher("showAll");
                        requestDispatcher.forward(req, resp);
                    }
                    else if(resultSet.getString(6).equals("user")){
                        session.setAttribute("name",resultSet.getString(2) );
                        session.setAttribute("address",resultSet.getString(5) );
                        session.setAttribute("id", resultSet.getInt(1));

                        RequestDispatcher requestDispatcher = req.getRequestDispatcher("showUser");
                        requestDispatcher.forward(req, resp);
                    }


                }
            }
            if(flag == 1){
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
                requestDispatcher.include(req, resp);
                out.println("Invalid Credentials");
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        resp.setContentType("text/html");
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        HttpSession session = req.getSession();
//        session.setAttribute("username",username );
//        session.setAttribute("password",password );
//
//        int flag = 1;
//        try {
//
//            connection = ConnectionMaker.getConnection();
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("select * from employee");
//
//            while(resultSet.next()) {
//                if(resultSet!=null) {
//                    if (username.equals(resultSet.getString(3)) &&
//                            password.equals(resultSet.getString(4))) {
//
//                        flag = 0;
//                        if (resultSet.getString(6).equals("admin")) {
//                            RequestDispatcher requestDispatcher = req.getRequestDispatcher("showAll");
//                            requestDispatcher.forward(req, resp);
//                        } else if (resultSet.getString(6).equals("user")) {
//                            session.setAttribute("username", username);
//                            session.setAttribute("password", password);
//                            session.setAttribute("name", resultSet.getString(2));
//                            session.setAttribute("address", resultSet.getString(5));
//                            session.setAttribute("id", resultSet.getInt(1));
//
//                            RequestDispatcher requestDispatcher = req.getRequestDispatcher("showUser");
//                            requestDispatcher.forward(req, resp);
//                        }
//
//
//                    }
//                }
//            }
//            if(flag == 1){
//                RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
//                requestDispatcher.include(req, resp);
//                out.println("Invalid Credentials");
//            }
//
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
