package com.project.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import com.project.Service.validateAndReturn;
import com.project.entities.Transact;
import com.project.entities.Users;
import com.project.helper.FactoryProvider;
import com.project.Service.SavingMethods;
@WebServlet(name = "FundTransferServlet", value = "/FundTransferServlet")
public class FundTransferServlet extends HttpServlet
{
    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()){
            String amount = request.getParameter("amount");
            String accountNumber = request.getParameter("PAccount_Number");
            //On the Service Layer validate the other user where we are transferring the money to and our own user with password
            //If the user is valid then transfer the money to the other user
            //If the user is not valid then return an error message
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("current-User");
            validateAndReturn validate = new validateAndReturn(FactoryProvider.getFactory());
            boolean differentUser = validate.validateUserDiff(accountNumber);
            if(differentUser){
                //checking if the user has enough money to transfer
                if(validate.validateUserMoney(user.getUserName(), amount)){
                    //transferring the money
                    String remB=validate.transferMoney(amount,user,accountNumber);
                    if(remB.equals("Success"))
                    {
                        Transact transaction = new Transact();
                        transaction.setAmount(amount);
                        transaction.setpAccountNumber(accountNumber);
                        transaction.setTransactionType("Fund Transfer");
                        transaction.setUser(user);
                        new SavingMethods().saveTransaction(transaction);
                        session.setAttribute("message","Money Transferred Successfully "+transaction.getReferenceNo());
                        response.sendRedirect("FundTransfer.jsp");
                    }
                    else
                    {
                        session.setAttribute("message",remB);
                        response.sendRedirect("FundTransfer.jsp");
                    }
                }
            }
            else
            {
                session.setAttribute("errorMsg", "Invalid Details of the user");
                response.sendRedirect("FundTransfer.jsp");
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
