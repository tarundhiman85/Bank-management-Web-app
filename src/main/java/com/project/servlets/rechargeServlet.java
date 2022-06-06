package com.project.servlets;

import com.project.Service.SavingMethods;
import com.project.dao.UserDao;
import com.project.entities.Transact;
import com.project.entities.Users;
import com.project.helper.FactoryProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "rechargeServlet", value = "/rechargeServlet")
public class rechargeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String amount = request.getParameter("amount");
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("current-User");
            String phone = request.getParameter("user_phone");
            //check if phone number is valid
            Transact transact = new Transact();
            transact.setAmount(amount);
            transact.setpAccountNumber(user.getAccountNo());
            transact.setTransactionType("Recharge");
            transact.setUser(user);

            if (phone.length() != 10) {
                session.setAttribute("message", "Invalid Phone Number");
                transact.setStatus("Failed");
            }
            //check if amount is valid
            else if (amount.length() == 0) {
                session.setAttribute("message", "Invalid Amount");
                transact.setStatus("Failed");
            } else {
                //check if user has enough balance
                if (Double.parseDouble(user.getBalance()) < Double.parseDouble(amount)) {
                    session.setAttribute("message", "Insufficient Balance");
                    transact.setStatus("Failed");
                }
                //reduce the balance of the user
                 boolean b = new UserDao(FactoryProvider.getFactory()).decreaseUserBalance(user, Double.parseDouble(amount));
                if (b) {
                    session.setAttribute("message", "Recharge Successful");
                    transact.setStatus("Success");
                }
            }
            new SavingMethods().saveTransaction(transact);
            response.sendRedirect("recharge.jsp");
        }
    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
