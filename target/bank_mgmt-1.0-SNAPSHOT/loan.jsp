<%--
  Created by IntelliJ IDEA.
  User: Tarun Dhiman
  Date: 17-09-2021
  Time: 09:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available Loans</title>
    <%@include file="/common_css_js.jsp"%>
</head>
<body class="back">
<%@include file="navbar.jsp"%>
<%
    Users user = (Users) session.getAttribute("current-User");
    if(user==null){
%>
<div class="card1">
    <h2>You need to Sign in</h2>
    <a href="login.jsp">Click Here</a>
</div>
<%
}
else{
//    int balance=Integer.parseInt(user.getBalance());
    double balance1=Double.parseDouble(user.getBalance());
    int balance= (int) balance1;
    if(balance>50){
        if(balance<100){
%>
<div class="card1">
    <h2>Available Bank Offer is: Rs <%=String.valueOf(balance*(2))%>/- at
        <%=String.valueOf(((balance*(2))/100)*10)%>(10%) Interest</h2>
</div>
<%} else if(balance<500){
%>
<div class="card1">
    <h2>Available Bank Offer is: Rs <%=String.valueOf(balance*(2))%>/- at
        <%=String.valueOf(((balance*(2))/100)*10)%>(10%) Interest</h2>
</div>
<%} else{
%>
<div class="card1">
    <h2>Available Bank Offer is: Rs <%=String.valueOf(balance*(2))%>/- at
        <%=String.valueOf(((balance*(2))/100)*10)%>(10%) Interest</h2>
</div>
<%}} else{
%>
<div class="card1">
    <h2>You don't have any Offer</h2>
</div>
<%}%>
<%}%>
</body>
</html>
