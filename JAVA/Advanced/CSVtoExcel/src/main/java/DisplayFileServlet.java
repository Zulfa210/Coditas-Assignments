import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Iterator;

/**
 * @author Zulfa Attar
 */
@WebServlet("/DisplayFile")
public class DisplayFileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            PrintWriter out = resp.getWriter();
            //HttpSession session = req.getSession();
            //String csvFileName = (String) session.getAttribute("excelData.xlsx");
            String savepath = "C://Users/Coditas/Desktop/Coditas-Assignments/JAVA/Advanced/CSVtoExcel/src/main/webapp/excelData.xlsx" ;
            FileInputStream fileInputStream = new FileInputStream(new File(savepath));

            req.getRequestDispatcher("index.html").include(req,resp);

                  String getData = null;
                 BufferedReader bufferedReader1 = new BufferedReader(new FileReader(savepath));
                out.println("<div style=\"width:70%; padding-left:500px; border:2px solid black\">" +
                        "<table border='2'><tbody>");

                while((getData=bufferedReader1.readLine())!=null)
                {
                    String s[]=getData.split(" ");
                    out.println("<tr>");
                    for(int i=0;i<s.length;i++) {
                        out.println("<td>"+s[i]+"</td>");
                    }
                    out.println("</tr>");
                }
                out.println("</tbody></table></div");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
