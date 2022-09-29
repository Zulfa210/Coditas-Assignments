package com.contoller;

import com.bean.CurrentAccount;
import com.connectionprovider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Zulfa Attar
 */
@WebServlet("/ShowCurrentAccount")
public class ShowCurrentAccountServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        long accountNumber = (long) req.getSession().getAttribute("accountNumber");
                CurrentAccount currentAccount = session.get(CurrentAccount.class,accountNumber );
    }
}
