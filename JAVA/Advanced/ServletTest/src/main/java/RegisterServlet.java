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
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();




        if(validateData(req.getParameter("firstname"),req.getParameter("lastname"), req.getParameter("mobileno"),  req.getParameter("city"), req.getParameter("education") )) {

            String firstname = req.getParameter("firstname");
            String lastname = req.getParameter("lastname");
            String password = req.getParameter("password");
            int mobileno = Integer.parseInt(req.getParameter("mobileno"));
            String city = req.getParameter("city");
            String education = req.getParameter("education");

            getServletContext().setAttribute("Username", firstname);
            getServletContext().setAttribute("userPassword", password);
            getServletContext().setAttribute("city", city);

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "zulfa123");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into candidate values (?, ?, ? , ? , ?,?)");
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setInt(3, mobileno);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, education);
            preparedStatement.setString(6, password);

            int c = preparedStatement.executeUpdate();
            System.out.println(c);
            RequestDispatcher rd = req.getRequestDispatcher("LoginServlet");
            rd.forward(req, resp);
        }else{
            RequestDispatcher rd = req.getRequestDispatcher("/index.html");
            rd.include(req,resp);
            out.println("Invalid Data");

        }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean validateData( String firstname, String lastname, String mobileno, String city,String education )
    {
        boolean validate = false;

       validate =  ((firstname != null) && (!firstname.equals(""))
                && (firstname.matches("^[a-zA-Z]*$")));
       if(validate ==false)
           return validate;

        validate =  ((lastname != null) && (!lastname.equals(""))
                && (lastname.matches("^[a-zA-Z]*$")));
        if(validate == false)
            return false;

        validate =  ((city != null) && (!city.equals(""))
                && (city.matches("^[a-zA-Z]*$")));
        if(validate == false)
            return false;

        validate =  ((education != null) && (!education.equals(""))
                && (education.matches("^[a-zA-Z]*$")));

        if(validate == false)
            return false;



//        char first[] = firstname.toCharArray();
//
//        for (char ch : first){
//            if((ch>='A' && ch<='Z')||(ch>='a' && ch<='z'))
//            {
//                validate = true;
//            }
//            else
//            {
//                validate = false;
//            }
//        }
//
//        char last[] = lastname.toCharArray();
//
//        for (char ch : last){
//            if((ch>='A' && ch<='Z')||(ch>='a' && ch<='z'))
//            {
//                validate = true;
//            }
//            else
//            {
//                validate = false;
//            }
//        }
//
//
//        char city1[] = city.toCharArray();
//
//        for (char ch : city1){
//            if((ch>='A' && ch<='Z')||(ch>='a' && ch<='z'))
//            {
//                validate = true;
//            }
//            else
//            {
//                validate = false;
//            }
//        }
//        char education1[] = education.toCharArray();
//
//        for (char ch : education1){
//            if((ch>='A' && ch<='Z')||(ch>='a' && ch<='z'))
//            {
//                validate = true;
//            }
//            else
//            {
//                validate = false;
//            }
//        }
//        char education1[] = mobileno.toCharArray();
//        if((mobileno>='A' && mobileno<='Z')||(mobileno>='a' && mobileno<='z'))
//        {
//            validate = false;
//        }
//        else
//        {
//            validate = true;
//        }
//try {
//    int mob = Integer.parseInt(mobileno);
//}
//catch (Exception e){
//    validate = false;
//}



        return validate;
    }
}
