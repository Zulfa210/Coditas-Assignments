import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
            Workbook workBook = new XSSFWorkbook(fileInputStream);
            DataFormatter dataFormatter = new DataFormatter();
            Iterator<Sheet> sheets = workBook.sheetIterator();

            while (sheets.hasNext()) {
                Sheet sh = sheets.next();
                out.println("<h3>File Converted</h3>");
                Iterator<Row> iterator = sh.iterator();
                Row row = iterator.next();
                Iterator<Cell> cellIterator = row.iterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cellValue = dataFormatter.formatCellValue(cell);
                    out.println(cellValue + " ");
                }
                out.println("<br>");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
