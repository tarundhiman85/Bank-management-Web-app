package com.project.servlets;

import com.project.entities.NewUser;
import com.project.entities.Users;
import com.project.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CreateAccount", value = "/CreateAccount")
public class CreateAccount extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

//        try (PrintWriter out = response.getWriter()) {
//            try {
//                String firstName=request.getParameter("first_name");
//                String lastName=request.getParameter("last_name");
//                String fathersName=request.getParameter("fathers_name");
//                String dob=request.getParameter("dob");
//                String gender=request.getParameter("gender");
//                String address=request.getParameter("user_address");
//                String presentAddress=request.getParameter("present_address");
//                String PANno=request.getParameter("pan_number");
//                String userPhone=request.getParameter("user_phone");
//                String accountType=request.getParameter("account_type");
//                String openingBalance=request.getParameter("opening_balance");


//                //validation
//                if(firstName==null && lastName==null){
//                    out.println("<h1>user Name cannot be null</h1>");
//                }
//                else{
//                    NewUser newuser = new NewUser(firstName,lastName,fathersName,dob,gender,address,presentAddress,PANno,userPhone,accountType,openingBalance);
//                    Session session = FactoryProvider.getFactory().openSession();
//                    Transaction transaction = session.beginTransaction();
//                    transaction.commit();
//                    int userId= (int)session.save(newuser);
//                    session.close();
//                    HttpSession httpSession = request.getSession();
//                    httpSession.setAttribute("current-user",newuser);
//                    response.sendRedirect("index.jsp");
//                }
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        }
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

