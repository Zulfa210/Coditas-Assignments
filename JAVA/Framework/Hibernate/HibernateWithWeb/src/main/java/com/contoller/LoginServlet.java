package com.contoller;

import com.bean.CurrentAccount;
import com.bean.SavingAccount;
import com.connectionprovider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Zulfa Attar
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        long accountNumber = Long.parseLong(req.getParameter("accountNumber"));
        String password = req.getParameter("password");

        String accountType = req.getParameter("accountType");

        HttpSession session = req.getSession();
        session.setAttribute("accountNumber", accountNumber);
        session.setAttribute("password", password);


        Session session1 = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session1.beginTransaction();

        if(accountNumber == 111111){
            req.getRequestDispatcher("ShowAllAccounts").forward(req,resp);
        }else if(accountType.equalsIgnoreCase("current")){
            CurrentAccount currentAccount = session1.get(CurrentAccount.class, accountNumber);

            if(currentAccount != null){
                if(currentAccount.getPassword().equals(password)){
                    req.getRequestDispatcher("ShowCurrentAccount").forward(req,resp);
                }else{
                    out.println("<h3>Invalid Password</h3>");
                    req.getRequestDispatcher("LoginPage.html").include(req,resp);
                }
            }else {
                out.println("<h3>Invalid Account Number</h3>");
                req.getRequestDispatcher("LoginPage.html").include(req,resp);
            }
        }else if(accountType.equalsIgnoreCase("saving")){
            SavingAccount savingAccount = session1.get(SavingAccount.class, accountNumber);

            if(savingAccount != null){
                if(savingAccount.getPassword().equals(password)){
                    req.getRequestDispatcher("ShowSavingAccount").forward(req,resp);
                }else{
                    out.println("<h3>Invalid Password</h3>");
                    req.getRequestDispatcher("LoginPage.html").include(req,resp);
                }
            }else {
                out.println("<h3>Invalid Account Number</h3>");
                req.getRequestDispatcher("LoginPage.html").include(req,resp);
            }
        }
    }
}
