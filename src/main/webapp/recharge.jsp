<%@ page import="com.project.helper.FactoryProvider" %><%--
  Created by IntelliJ IDEA.
  User: Tarun Dhiman
  Date: 06-06-2022
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recharge</title>
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
<%}
else{
%>
<div class="container-fluid">
    <div class="row al">
        <div class="col-md-4">
            <div class="card mt-3">
                <div class="card-body">
                    <%@include file="message.jsp"%>
                    <%@include file="errorMsg.jsp"%>
                    <form action="rechargeServlet" method="post">
                        <div class="form-group">
                            <h3>Recharge</h3>
                        </div>

                        <div class="form-group">
                            <label>Your Account Number is <%=user.getAccountNo()%></label>
                        </div>

                        <div class="form-group">
                            <label>Your Account Balance is <%=user.getAccountType().toUpperCase()%></label>
                        </div>
                        <div class="form-group">
                            <label for="gender">Select Provider</label>
                            <select name="gender" id="gender"  class="form-control"  required style="background-color: #041d30; color: #72d3f1">
                                <option value="VI">VI</option>
                                <option value="Airtel">Airtel</option>
                                <option value="Jio">Jio</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="phone">Phone Number</label>
                            <input name="user_phone" required type="number" class="use-keyboard-input form-control" id="phone" placeholder="Enter your phone" aria-describedby="emailHelp" >
                        </div>

                        <div class="form-group">
                            <label for="amount">Amount</label>
                            <input name="amount" type="number" class="form-control" id="amount" aria-describedby="emailHelp" placeholder="Enter Amount">
                        </div>

                        <div class="container text-center">
                            <button type="submit" id="register">Recharge</button>
                            <button type="reset" id="reset">Reset</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%}%>
</body>
</html>
