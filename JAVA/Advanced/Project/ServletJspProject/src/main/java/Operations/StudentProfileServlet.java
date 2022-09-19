package Operations;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Zulfa Attar
 * select t.name from teacher1 t inner join studentTeacher st on t.id = st.teacher_id inner join student1 s on st.student_id = s.id where s.id=3;
 */
public class StudentProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username" );
        String password = (String) session.getAttribute("password" );
        int id =   (int) session.getAttribute("id");
        String name = (String) session.getAttribute("name");
        String aboutMe = (String) session.getAttribute("aboutMe");
        String testimonial = (String) session.getAttribute("testimonial");
        int age = (int) session.getAttribute("age");
        String address = (String) session.getAttribute("address");
        String clas = (String) session.getAttribute("class");
        String mobile = (String) session.getAttribute("mobile");
        String photo = (String) session.getAttribute("photo");


    }
}
