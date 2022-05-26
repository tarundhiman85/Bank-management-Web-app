package com.project.servlets;

import com.project.dao.UserDao;
import com.project.entities.RDAccount;
import com.project.entities.Users;
import com.project.helper.FactoryProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

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
            //get the amount to pay
            String amount = rdAccountByUserId.getDepositAmount();
            String ROI = rdAccountByUserId.getCurrentROI();
            //apply the rate of interest and get the new amount
            String newAmount = String.valueOf(Double.parseDouble(amount) + (Double.parseDouble(amount) * Double.parseDouble(ROI)) / 100);
            //update the amount

            //validation before applying the logic
            boolean isAmountLarger=false;
            boolean f =false;
            if(Double.parseDouble(rdAccountByUserId.getDepositAmount())>=Double.parseDouble(rdAccountByUserId.getMaturityAmount())) {
                isAmountLarger=true;
            }
            if(!isAmountLarger) {
                rdAccountByUserId.setDepositAmount(newAmount);
                //update the rd account
                 f = new UserDao(FactoryProvider.getFactory()).updateRDAccount(rdAccountByUserId);
            }
            if(f){
                if(Double.parseDouble(newAmount)>=Double.parseDouble(rdAccountByUserId.getMaturityAmount())){
                    session.setAttribute("message","RD Matured just close the rd account");
                    response.sendRedirect("PayRd.jsp");
                }
                else{
                    session.setAttribute("message","RD paid successfully");
                    response.sendRedirect("PayRd.jsp");
                }
            }
            else if(isAmountLarger) {
                session.setAttribute("message", "RD Matured just close the rd account");
                response.sendRedirect("PayRd.jsp");
            }
            else {
                session.setAttribute("message","Error in paying the RD");
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
