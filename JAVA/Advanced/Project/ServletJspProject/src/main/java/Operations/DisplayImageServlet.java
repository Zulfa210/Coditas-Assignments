package Operations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Zulfa Attar
 */
@WebServlet("/DisplayServlet")
public class DisplayImageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("In do post method of Display Image servlet.");
        String imageId=req.getParameter("imageId");
        int id=Integer.parseInt(imageId);

        //getting database connection (jdbc code)
        Connection connection=null;
        int imgId=0;
        String imgFileName=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/imageProject","root","zulfa123");
            Statement stmt;
            String query="select * from saveImage";
            stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery(query);

            while(rs.next())
            {
                if(rs.getInt(1)==id)
                {
                    imgId=rs.getInt(1);
                    imgFileName=rs.getString(2);
                }
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        RequestDispatcher rd;
        req.setAttribute("id",String.valueOf(imgId));  //valueOf
        req.setAttribute("img",imgFileName);
        rd=req.getRequestDispatcher("displayImage.jsp");
        rd.forward(req, resp);
    }
}
