<%--This is one of the interesting Java projects to create. This project focuses on developing an online banking system.
The main aim is to create an online banking platform that is accessible from any location,
so customers need not go to the bank branches for routine banking operations like money withdrawal, money transfer, balance inquiry,
etc.--%>

<%--Visiting the physical branches of banks is not only time consuming but can also be hectic, thanks to long queues and waiting time.
 Not to forget, running to banks for every minor banking task creates an unnecessary burden on bank staff.
 These issues can be addressed by developing an online banking system that will offer seamless and prompt banking services to customers.
 However, to use this software application, a user must be registered with the system.
To do so, the user has to create a unique user name and password for securely logging in to the application.--%>
<%--This online bank management application will provide the following services to customers:--%>
<%--Customers can view their account details such as type of account, available balance, the interest rate on available loans, credit/debit statements, etc. from any remote location.--%>
<%--Customers can check their transaction history that includes necessary information like transaction time, type, and amount.--%>
<%--It will display the amount of deposited cash or withdrawn cash along with the date of deposition/withdrawal.--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Online Bank Management</title>
    <%@include file="/common_css_js.jsp"%>
</head>
<body class="back">
<%@include file="navbar.jsp"%>

<div class="div-block">
    <div class="text-block">
        Welcome to the ABC Bank<br>
        Check your Account Details Akshay Sontakke <br>
        Check Your Loan Offers<br>
        Withdraw Money<br>
    </div>
</div>

<%@include file="common_modals.jsp"%>
</body>
</html>