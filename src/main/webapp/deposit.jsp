
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deposit Funds</title>
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
%>

<div class="card2">

<form id="f1" action="DepositServlet" method="post">
        <h5 style="color: #72d3f1">Enter the amount to add</h5>
        <input name="balance" id="b1" required type="text" placeholder="Enter Amount">
        <br>
        <input type="submit" id="deposit" value="Deposit">
</form>
    </div>
<%
    }
%>
</body>
</html>
