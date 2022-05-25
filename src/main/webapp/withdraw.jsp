<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Withdraw</title>
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
<div class="card1">
    <%@include file="message.jsp"%>
    <form action="WithdrawServlet" method="post">
    <h6>Available Balance: <%=user.getBalance()%></h6>
    <%
        if(Integer.parseInt(user.getBalance())==0){
    %>
     <h6>Sorry You don't have the balance</h6>
     <a href="deposit.jsp">Click here to add balance</a>
    <%
        }else{
    %>
    <h6>Enter to Withdraw Amount</h6>
    <input name="withdraw_amount" required type="number" class="form-control" placeholder="Enter amount between 1 to <%=user.getBalance()%>">
    <input id="deposit1" type="submit" value="Withdraw">
</form>
</div>

<br> <%
    }}
%>
<%@include file="common_modals.jsp"%>
</body>
</html>
