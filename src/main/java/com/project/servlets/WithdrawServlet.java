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

@WebServlet(name = "WithdrawServlet", value = "/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            int amount=Integer.parseInt(request.getParameter("withdraw_amount"));
            HttpSession session1=request.getSession();
            Users user=(Users) session1.getAttribute("current-User");
            double balance=Double.parseDouble(user.getBalance());
            int avail_balance=(int)balance;
            if(avail_balance<amount){
             session1.setAttribute("message","Enter amount within range");
             response.sendRedirect("withdraw.jsp");
            }
            else {
                avail_balance -= amount;
                user.setBalance(String.valueOf(avail_balance));
                Session session = FactoryProvider.getFactory().openSession();
                Transaction tx = session.beginTransaction();
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
