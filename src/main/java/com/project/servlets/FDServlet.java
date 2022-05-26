package com.project.servlets;

import com.project.Service.SavingMethods;
import com.project.entities.FDAccount;
import com.project.entities.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FDServlet", value = "/FDServlet")
public class FDServlet extends HttpServlet {
    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()){
            String depositAmount = request.getParameter("deposit_amount");
            String tenureOfDeposit = request.getParameter("tenure");
            String interestRate = "6.5";
            //now calculate the simple interest
            double simpleInterest = Double.parseDouble(depositAmount) * (Double.parseDouble(tenureOfDeposit)/12) * Double.parseDouble(interestRate) / 100;
            //now calculate the total amount
            double totalAmount = Double.parseDouble(depositAmount) + simpleInterest;
            //convert into string
            String totalAmountStr = String.valueOf(totalAmount);
            //from the tenure of months from today, calculate the date of maturity
            String dateOfMaturity = "";
            //get the current date from date class
            java.util.Date date = new java.util.Date();
            //now add the months to the current date
            int months = Integer.parseInt(tenureOfDeposit);
            //now add the months to the current date
            date.setMonth(date.getMonth() + months);
            //now convert the date into string
            dateOfMaturity = date.toString();
            //save the FD details by SavingMethods class
            SavingMethods savingMethods = new SavingMethods();
            FDAccount fdAccount = new FDAccount();
            fdAccount.setDepositAmount(depositAmount);
            fdAccount.setTenureOfDeposit(tenureOfDeposit);
            fdAccount.setCurrentROI(interestRate);
            fdAccount.setMaturityAmount(totalAmountStr);
            fdAccount.setMaturityDate(dateOfMaturity);
            //get the current user from session
            HttpSession session = request.getSession();
            //get the current user
             Users current_User = (Users) session.getAttribute("current-User");
            //set the current user
            fdAccount.setUser(current_User);
            //save the FD details
            boolean f=savingMethods.saveFDAccount(fdAccount);
            if(f){
                session.setAttribute("message","FD Account Created Successfully"+"->Maturity Amount is "+totalAmountStr+"->Maturity Date is "+dateOfMaturity);
                response.sendRedirect("fdaccount.jsp");
            }
            else{
                session.setAttribute("message","FD Account Creation Failed");
                response.sendRedirect("fdaccount.jsp");
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
