package com.project.servlets;

import com.project.entities.Users;
import com.project.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            try {
                String userName=request.getParameter("fullName");
                String userEmail=request.getParameter("email");
                String userPassword=request.getParameter("password");
                String userPhone=request.getParameter("user_phone");
                String userAddress=request.getParameter("user_address");
                String dob = request.getParameter("dob");
                String gender = request.getParameter("gender");
                String presentAddress=request.getParameter("present_address");
                String accountType=request.getParameter("account_type");
                String landline = request.getParameter("LNumber");
                String branchName = request.getParameter("branch");
                //get father name
                String fatherName=request.getParameter("fathers_name");
                //get pan number
                String panNumber=request.getParameter("pan_number");
                //get balance
                String balance=request.getParameter("opening_balance");
                String clickedSubmit = request.getParameter("clickedSubmit");
                //validation
                HttpSession httpSession=request.getSession();
                if(userName==null){
                    httpSession.setAttribute("message", "User Name cannot be null");
                    response.sendRedirect("CreateAccount.jsp");
                }
                if(!(clickedSubmit.equals("no"))){
                    httpSession.setAttribute("message", clickedSubmit);
                    response.sendRedirect("CreateAccount.jsp");
                }
                if(Integer.parseInt(balance)<5000){
                    httpSession.setAttribute("message", "Opening Balance should be greater than 5000");
                    response.sendRedirect("CreateAccount.jsp");
                }
                else{
                    //creating a constructor based on the parameters receive
                    Users user=null;
                    if(presentAddress!=null) { user=new Users(userName,userEmail,userPassword,userPhone,userAddress,presentAddress,accountType,fatherName,dob,panNumber,balance,landline,gender,branchName);}
                    else {user=new Users(userName,userEmail,userPassword,userPhone,userAddress,userAddress,accountType,fatherName,dob,panNumber,balance,landline,gender,branchName);}
                    Session session = FactoryProvider.getFactory().openSession();
                    Transaction transaction = session.beginTransaction();
                    transaction.commit();
                    int userId= (int)session.save(user);
                    session.close();
                    httpSession.setAttribute("current-user",user);
                    httpSession.setAttribute("message", "User Created Successfully");
                    response.sendRedirect("CreateAccount.jsp");
                }
            }
            catch (Exception e){
                e.printStackTrace();
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
