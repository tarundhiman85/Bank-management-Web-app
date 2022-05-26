package com.project.servlets;

import com.project.dao.UserDao;
import com.project.entities.FDAccount;
import com.project.entities.RDAccount;
import com.project.entities.Users;
import com.project.helper.FactoryProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "closeFDRDServlet", value = "/closeFDRDServlet")
public class closeFDRDServlet extends HttpServlet {
    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try(PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("current-User");
            String fethOP = request.getParameter("close");
            if(fethOP.equals("fd")){
                //we have to close the fd
                //fetch the fd from UserDao class
                UserDao ud = new UserDao(FactoryProvider.getFactory());
                FDAccount fd = ud.getFDAccountByUserId(user.getUserId());
                //close the fd
                //call the remove fd method from UserDao class
                boolean f =ud.removeFDAccount(fd);
                if(f){
                    session.setAttribute("message","FD closed successfully");
                    response.sendRedirect("fdaccount.jsp");
                }
                else{
                    session.setAttribute("message","FD closing failed");
                    response.sendRedirect("fdaccount.jsp");
                }
            }
            else{
                //we have to close the rd
                //fetch the rd from UserDao class
                UserDao ud = new UserDao(FactoryProvider.getFactory());
                RDAccount rd = ud.getRDAccountByUserId(user.getUserId());
                //close the rd
                //call the remove rd method from UserDao class
                boolean f =ud.removeRDAccount(rd);
                if(f){
                    session.setAttribute("message","RD closed successfully");
                    response.sendRedirect("rdaccount.jsp");
                }
                else{
                    session.setAttribute("message","RD closing failed");
                    response.sendRedirect("rdaccount.jsp");
                }
            }
        }
        catch (Exception e) {
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
