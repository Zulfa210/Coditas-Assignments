import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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

        PrintWriter out = resp.getWriter();
        String csvFileName = file.getSubmittedFileName();

        int dot = csvFileName.indexOf(".");
        String extension = csvFileName.substring(dot + 1, csvFileName.length());

        if (extension.equalsIgnoreCase("CSV")) {
            System.out.println("Selected File Name: " + csvFileName);
            String drivePath = "https://docs.google.com/spreadsheets/d/1hpm-nvpbBbKsA3N9AIohswXLUOCfHZtI/edit?usp=sharing&ouid=111590145429153922441&rtpof=true&sd=true";
            String uploadPath = "C:/Users/Coditas/Desktop/Coditas-Assignments/JAVA/Advanced/CSVtoExcel/" + csvFileName;
            System.out.println(uploadPath);


            try {
                FileOutputStream fos = new FileOutputStream(uploadPath);
                //FileOutputStream fosd = new FileOutputStream(drivePath);
                InputStream inputStream = file.getInputStream();

                byte[] data = new byte[inputStream.available()];
                inputStream.read(data);
               // fosd.write(data);
                fos.write(data);
                //fosd.close();
                fos.close();
                System.out.println("File added Successfully");
                new ConvertCsvToExcel().csvToExcel(uploadPath);

                HttpSession session = req.getSession();
                session.setAttribute("filename", csvFileName);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("DisplayFile");
                requestDispatcher.forward(req, resp);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            req.getRequestDispatcher("index.html").include(req,resp);
            out.println("Invalid File! Enter csv file");

        }
    }
}
