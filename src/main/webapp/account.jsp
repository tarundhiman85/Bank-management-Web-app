<%@ page import="org.hibernate.Session" %>
<%@ page import="com.project.helper.FactoryProvider" %>
<%@ page import="com.project.entities.Users" %>
<%@ page import="com.project.dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: Tarun Dhiman
  Date: 15-08-2021
  Time: 03:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    Users user = (Users) session.getAttribute("current-User");
    UserDao userDao = new UserDao(FactoryProvider.getFactory());
    user = userDao.getUserById(user.getUserId());
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Details</title>
    <%@include file="/common_css_js.jsp"%>
</head>
<%--Customers can view their account details such as type of account, available balance, the interest rate on available loans, credit/debit statements, etc. from any remote location.--%>
<body class="back">
<%@include file="navbar.jsp"%>
<%--What if user click on this page without login must be redirected to login page--%>
<%
    if(user==null){
   %>
    <div class="card1">
        <h2>You need to Sign in</h2>
        <a href="login.jsp">Click Here</a>
    </div>
   <%
    }
    else{
   %>

<%--how to fetch the current user on the login page  Session tracking--%>
<div class="container-center">
    <h3  style="text-align: center; color: #72d3f1; padding-top: 5%">
        View Account
    </h3>
    <div class="row al">

        <div class="card mt-3" style="color:#72d3f1; margin: auto; max-width: 250%; background-color: #001e30">


    <h6>Name: <%=user.getUserName()%></h6>
    <h6>Address: <%=user.getUserAddress()%></h6>
    <h6>Account Type: <%=user.getAccountType().toUpperCase()%></h6>
    <h6>Balance: <%=user.getBalance()%></h6>
    <h6>Date of Birth :<%=user.getDob()%></h6>
    <h6>Email: <%=user.getUserEmail()%></h6>
    <h6>Phone: <%=user.getMobilePhone()%></h6>
</div>
        </div>
    </div>
    <br> <%
    }
    %>

<%@include file="common_modals.jsp"%>
</body>
</html>
