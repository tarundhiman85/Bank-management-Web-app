package com.project.servlets;

import com.project.dao.*;
import com.project.entities.RDAccount;
import com.project.entities.Users;
import com.project.helper.FactoryProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "PayRDServlet", value = "/PayRDServlet")
public class PayRDServlet extends HttpServlet {
    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try(PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            //get the current user
            Users user = (Users) session.getAttribute("current-User");
            //get the rd from current user id
            RDAccount rdAccountByUserId = new UserDao(FactoryProvider.getFactory()).getRDAccountByUserId(user.getUserId());
            //get the previous amount to pay
            String amount = rdAccountByUserId.getMaturityAmount();
            String ROI = rdAccountByUserId.getCurrentROI();
            //apply the rate of interest and get the new amount
            String newAmount = String.valueOf(Double.parseDouble(amount) + ((Double.parseDouble(amount) * Double.parseDouble(ROI)) / 100));
            String monthlyPayment = rdAccountByUserId.getMonthlyDeposit();
            //add this monthly deposit to the new amount
            String newAmountWithMonthlyPayment = String.valueOf(Double.parseDouble(newAmount) + Double.parseDouble(monthlyPayment));
            //update the new amount string upto two decimal places
            newAmount = String.format("%.2f", Double.parseDouble(newAmountWithMonthlyPayment));
            //validation before applying the logic
                rdAccountByUserId.setMaturityAmount(newAmount);
                //update the rd account
                 new UserDao(FactoryProvider.getFactory()).updateRDAccount(rdAccountByUserId);

                //first we need to get the date
                String nextDate = rdAccountByUserId.getNextDate();
                String maturityDate = rdAccountByUserId.getMaturityDate();
                //we need to ignore time we just do the string manipulation
                nextDate = nextDate.substring(0,10);
                nextDate += rdAccountByUserId.getNextDate().substring(21);
                maturityDate = maturityDate.substring(0,10);
                maturityDate += rdAccountByUserId.getMaturityDate().substring(21);
                if(nextDate.equals(maturityDate)){
                    session.setAttribute("message","RD Matured just close the rd account");
                    response.sendRedirect("closerd.jsp");
                }
                else{
                    session.setAttribute("message","RD paid successfully");
                    response.sendRedirect("PayRd.jsp");
                }
        }
        catch (Exception e){

            e.printStackTrace();
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
