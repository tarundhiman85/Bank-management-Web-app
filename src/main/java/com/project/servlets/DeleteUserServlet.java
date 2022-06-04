package com.project.servlets;

import com.project.entities.Users;
import com.project.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int userId=Integer.parseInt(request.getParameter("user_id").trim());
            Session s= FactoryProvider.getFactory().openSession();
            Transaction tx=s.beginTransaction();
            Users user = s.get(Users.class,userId);
            s.delete(user);
            tx.commit();
            s.close();
            response.sendRedirect("viewUsers.jsp");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
