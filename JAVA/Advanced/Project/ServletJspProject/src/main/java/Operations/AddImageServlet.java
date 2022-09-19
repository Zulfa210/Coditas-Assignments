package Operations;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author Zulfa Attar
 */
@MultipartConfig
@WebServlet("/AddImage")
public class AddImageServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                 Part file = req.getPart("image");

                 String imageFileName = file.getSubmittedFileName();

            System.out.println("Selected Image File Name: " + imageFileName);
            String uploadPath = "C:/Users/Coditas/Desktop/Coditas-Assignments/JAVA/Advanced/Project/ServletJspProject/src/main/webapp/images/" + imageFileName;
            System.out.println(uploadPath);


            try {
                FileOutputStream fos = new FileOutputStream(uploadPath);
                InputStream inputStream = file.getInputStream();

                byte[] data = new byte[inputStream.available()];
                inputStream.read(data);
                fos.write(data);
                fos.close();

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/imageProject", "root", "zulfa123");
                PreparedStatement preparedStatement = connection.prepareStatement("insert into saveImage (image_name) values (?)");
                preparedStatement.setString(1, imageFileName);
                int check = preparedStatement.executeUpdate();

                if(check>0){
                    System.out.println("Image added Successfully");
                    resp.sendRedirect("displayImage.jsp");
                }else{
                    System.out.println("Failed to Upload Image");
                }

            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
}
