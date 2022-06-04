package com.project.servlets;

import com.project.entities.Users;
import com.project.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateUserServlet", value = "/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String fullName=request.getParameter("fullName");
            String userEmail=request.getParameter("email");
            String userPassword=request.getParameter("password");
            String fathersName=request.getParameter("fathers_name");
            String dob=request.getParameter("dob");
            String gender=request.getParameter("gender");
            String userPhone=request.getParameter("user_phone");
            String Landline=request.getParameter("LNumber");

            HttpSession httpSession = request.getSession();
            Session s= FactoryProvider.getFactory().openSession();
            int userId=Integer.parseInt(request.getParameter("user_id"));
            Transaction tx=s.beginTransaction();
            Users user = s.get(Users.class,userId);
            user.setUserName(fullName);
            user.setUserEmail(userEmail);
            user.setUserPassword(userPassword);
            user.setFatherName(fathersName);
            user.setDob(dob);
            user.setGender(gender);
            user.setMobilePhone(userPhone);
            user.setLandline(Landline);

            s.update(user);
            tx.commit();
            s.close();
            httpSession.setAttribute("message","User Updated Successfully");
            response.sendRedirect("editProfile.jsp?user_id="+user.getUserId());
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
