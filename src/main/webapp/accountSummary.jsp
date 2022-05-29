<%@ page import="java.util.List" %>
<%@ page import="com.project.dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: shubh
  Date: 22-05-2022
  Time: 03:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Summary</title>
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
}else{
%>
<div class="container-fluid">
    <div class="row al">
        <div class="col-md-4">
            <div class="card mt-3">
                <div class="card-body">
                    <%@include file="message.jsp"%>
                    <table class="table table-striped table-bordered" style="color:#72d3f1">
                        <thead>
                        <tr>
                            <th>Account Number</th>
                            <th>Account Type</th>
                            <th>Balance</th>
                            <th>Date of Birth</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><%=user.getAccountNo()%></td>
                            <td><%=user.getAccountType().toUpperCase()%></td>
                            <td><%=user.getBalance()%></td>
                            <td><%=user.getDob()%></td>
                        </tr>
                        </tbody></table>
                </div>
            </div>
        </div>
    </div>
</div>
<%
}
%>
</body>
</html>