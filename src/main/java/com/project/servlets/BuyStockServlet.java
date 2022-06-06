package com.project.servlets;

import com.project.Service.SavingMethods;

import com.project.entities.Stocks;
import com.project.entities.Transact;
import com.project.entities.Users;
import com.project.helper.FactoryProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BuyStockServlet", value = "/BuyStockServlet")
public class BuyStockServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("current-User");
            Stocks stock = (Stocks) session.getAttribute("stocky");
            stock.setUser(user);
            String changePercent = stock.getChangePercent();
            StringBuilder str = new StringBuilder(changePercent).deleteCharAt(changePercent.length()-1);
            stock.setChangePercent(str.toString());
            boolean b = new SavingMethods().saveStock(stock, user);
            Transact transaction = new Transact();
            transaction.setAmount(stock.getPrice());
            transaction.setpAccountNumber(user.getAccountNo());
            transaction.setTransactionType("Stock Buy");
            transaction.setUser(user);
            if(b){
                transaction.setStatus("Success");
                new SavingMethods().saveTransaction(transaction);
                session.setAttribute("message","Stock Bought Successfully");
            }
            else{
                transaction.setStatus("Failed");
                new SavingMethods().saveTransaction(transaction);
                session.setAttribute("message","Stock Not Bought");
            }
            response.sendRedirect("viewStock.jsp");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
