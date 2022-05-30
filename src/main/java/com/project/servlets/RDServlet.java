package com.project.servlets;

import com.project.Service.SavingMethods;
import com.project.entities.RDAccount;
import com.project.entities.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RDServlet", value = "/RDServlet")
public class RDServlet extends HttpServlet {
    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()){
            String depositAmount = request.getParameter("deposit_amount");
            String tenureOfDeposit = request.getParameter("tenure");
            String monthlyDeposit = request.getParameter("monthly_deposit");
            String interestRate = "6.5";

            String dateOfMaturity = "";
            //get the current date from date class
            java.util.Date date = new java.util.Date();
            //now add the months to the current date
            int months = Integer.parseInt(tenureOfDeposit);
            //now add the months to the current date
            date.setMonth(date.getMonth() + months);
            //now convert the date into string
            dateOfMaturity = date.toString();
            //save the RD details by SavingMethods class
            SavingMethods savingMethods = new SavingMethods();
            RDAccount rdAccount = new RDAccount();
            rdAccount.setDepositAmount(depositAmount);
            rdAccount.setTenureOfDeposit(tenureOfDeposit);
            rdAccount.setCurrentROI(interestRate);
            rdAccount.setMaturityAmount(depositAmount);
            rdAccount.setMaturityDate(dateOfMaturity);
            rdAccount.setMonthlyDeposit(monthlyDeposit);
            //get the current user from session
            HttpSession session = request.getSession();
            //get the current user
            Users current_User = (Users) session.getAttribute("current-User");
            //set the current user
            rdAccount.setUser(current_User);
            //save the RD details
            boolean f=savingMethods.saveRDAccount(rdAccount);
            if(f){
                session.setAttribute("message","RD Account Created Successfully"+"->Maturity Date is "+dateOfMaturity);
                response.sendRedirect("rdaccount.jsp");
            }
            else{
                session.setAttribute("message","RD Account Creation Failed");
                response.sendRedirect("rdaccount.jsp");
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
