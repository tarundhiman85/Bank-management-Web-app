package com.project.servlets;

import com.project.Service.SavingMethods;
import com.project.dao.UserDao;
import com.project.entities.Stocks;
import com.project.entities.Transact;
import com.project.entities.Users;
import com.project.helper.FactoryProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SellStockServlet", value = "/SellStockServlet")
public class SellStockServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        //get a logic to sell the stock at market Price
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("current-User");
            String stockId= request.getParameter("st");
             Stocks stock = new UserDao(FactoryProvider.getFactory()).getStockById(stockId);
            String marketPrice = request.getParameter("mktP");
            String profit = request.getParameter("prof");
            String loss = request.getParameter("los");

            boolean b = new SavingMethods().sellStock(stock, user );
            Transact transaction = new Transact();
            transaction.setAmount(marketPrice);
            transaction.setpAccountNumber(user.getAccountNo());
            transaction.setTransactionType("Stock Sell");
            transaction.setUser(user);
            if(b){
                transaction.setStatus("Success");
                new SavingMethods().saveTransaction(transaction);
                new UserDao(FactoryProvider.getFactory()).updateProfitLoss(user,profit,loss);
                session.setAttribute("message","Stock Sell Successfully");
            }
            else{
                transaction.setStatus("Failed");
                new SavingMethods().saveTransaction(transaction);
                session.setAttribute("message","Stock Not Sell");
            }
            response.sendRedirect("viewStocks.jsp");
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
