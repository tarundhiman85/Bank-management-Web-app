package com.project.servlets;
import com.project.Service.*;
import com.project.Service.SavingMethods;
import com.project.dao.*;
import com.project.entities.Payee;
import com.project.entities.Users;
import com.project.helper.FactoryProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PayeeServlet", value = "/PayeeServlet")
public class PayeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

     void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
         response.setContentType("text/html");
         try (PrintWriter out = response.getWriter()) {
             String operation = request.getParameter("PayeeOp");
             String AccountNumber = request.getParameter("Account_Number");
             String Name = request.getParameter("name");
             String ifscCode = request.getParameter("ifsc");
             String password = request.getParameter("password");
             HttpSession session = request.getSession();
             Users user = (Users) session.getAttribute("current-User");
             boolean validateUser = user.getUserPassword().equals(password);
             //Adding the payee
             if(operation.equals("Add")) {
                 boolean f =false;
                 f=new SavingMethods().SavePayee(AccountNumber,ifscCode,Name,user);
                 if(f && validateUser) {
                     session.setAttribute("message","Payee Added Successfully");
                     response.sendRedirect("Payee.jsp");
                 }
                 else{
                     session.setAttribute("message","Payee Not Added Something went wrong");
                     response.sendRedirect("Payee.jsp");
                 }
             }
             //Removing the payee
             else if(operation.equals("Remove")) {
                 String payeeId = request.getParameter("payeeId");
                 Payee payee = new UserDao(FactoryProvider.getFactory()).getPayeeById(payeeId);
                 boolean f = false;
                 if(payee!=null) f=new RemoveMethod().removePayee(payee);
                 if(f){
                     session.setAttribute("message","Payee Removed Successfully");
                     response.sendRedirect("DeletePayee.jsp");
                 }
                 else{
                     session.setAttribute("message","Payee Not Removed Something went wrong");
                     response.sendRedirect("DeletePayee.jsp");
                 }
             }
             //Activating the payee
             else if(operation.equals("Activate")) {
                 String payeeId = request.getParameter("payeeId");
                 Payee payee = new UserDao(FactoryProvider.getFactory()).getPayeeById(payeeId);
                 boolean f = false;
                 if(payee!=null) f=new SavingMethods().activatePayee(payee);
                 if(f){
                     session.setAttribute("message","Payee Activated Successfully");
                     response.sendRedirect("ActivatePayee.jsp");
                 }
                 else{
                     session.setAttribute("message","Payee Not Activated Something went wrong");
                     response.sendRedirect("ActivatePayee.jsp");
                 }
             }
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
