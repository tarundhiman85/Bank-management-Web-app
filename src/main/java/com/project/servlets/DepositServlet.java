package com.project.servlets;

import com.project.entities.Users;
import com.project.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DepositServlet", value = "/DepositServlet")
public class DepositServlet extends HttpServlet {
    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String balance = request.getParameter("balance");
            Session session = FactoryProvider.getFactory().openSession();
            //we want the current user how to do it
            HttpSession httpSession = request.getSession();
            Users user = (Users) httpSession.getAttribute("current-User");
            Transaction tx= session.beginTransaction();
            if (user.getBalance() == null) {
                user.setBalance(balance);
                session.update(user);
                tx.commit();
                session.close();
                response.sendRedirect("account.jsp");

            } else {
                double currentBalance = Double.parseDouble(user.getBalance());
                currentBalance += Double.parseDouble(balance);
                user.setBalance((String.valueOf(currentBalance)));
                session.update(user);
                tx.commit();
                session.close();
                response.sendRedirect("account.jsp");
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
