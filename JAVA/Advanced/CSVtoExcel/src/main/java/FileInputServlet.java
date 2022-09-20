import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
@WebServlet("/fileInput")
public class FileInputServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part file = req.getPart("csvFile");

        String csvFileName = file.getSubmittedFileName();

        System.out.println("Selected File Name: " + csvFileName);
        String uploadPath = "C:/Users/Coditas/Desktop/Coditas-Assignments/JAVA/Advanced/CSVtoExcel/" + csvFileName;
        System.out.println(uploadPath);


        try {
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream inputStream = file.getInputStream();

            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            fos.write(data);
            fos.close();
            System.out.println("File added Successfully");
            new ConvertCsvToExcel().csvToExcel(uploadPath);

            HttpSession session = req.getSession();
            session.setAttribute("filename", csvFileName);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("DisplayFile");
            requestDispatcher.forward(req,resp);
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/imageProject", "root", "zulfa123");
//            PreparedStatement preparedStatement = connection.prepareStatement("insert into saveImage (image_name) values (?)");
//            preparedStatement.setString(1, csvFileName);
//            int check = preparedStatement.executeUpdate();
//
//            if(check>0){
//                System.out.println("File added Successfully");
//
//            }else{
//                System.out.println("Failed to Upload Image");
//            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
