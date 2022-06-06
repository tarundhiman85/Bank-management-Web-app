<%@ page import="com.project.entities.Payee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.dao.UserDao" %>
<%@ page import="com.project.helper.FactoryProvider" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="/common_css_js.jsp"%>
</head>
<body class="back">
<%@include file="navbar.jsp"%>
<%
    Users user = (Users) session.getAttribute("current-User");
    List<Payee> payeeList = new UserDao(FactoryProvider.getFactory()).getPayeeList(user.getUserId());
    if(user==null){
%>
<div class="card1">
    <h2>You need to Sign in</h2>
    <a href="login.jsp">Click Here</a>
</div>
<%} else if(payeeList.size()==0){
    %>
<div class="card1">
    <h2>You need to add Payee</h2>
    <a href="AddPayee.jsp">Click Here</a>
</div>
<%
    }
else{
    %>
<div class="container-fluid">
    <div class="row al">
        <div class="col-md-4">
            <div class="card mt-3">
                <div class="card-body">
                    <%@include file="message.jsp"%>
                    <%@include file="errorMsg.jsp"%>
                    <form action="FundTransferServlet" method="post">
                        <div class="form-group">
                            <h3>Fund Transfer</h3>
                        </div>

                        <div class="form-group">
                            <label>Your Account Number is <%=user.getAccountNo()%></label>
                        </div>

                        <div class="form-group">

                            <label>Your Account Type is <%=user.getAccountType().toUpperCase()%></label>
                        </div>

                        <div class="form-group">
                            <label>Your Branch Name is <%=user.getBranchName().toUpperCase()%></label>
                        </div>
<%--                        Select a payee from payee list by some option and then transfer funds--%>
                        <div class="form-group">
                            <label>Select a Payee</label>
                            <label>
                                <select name="payeeData" class="form-control"  required style="background-color: #041d30; color: #72d3f1">
                                    <option value="">Select a Payee</option>
                                    <%
                                    for(Payee payee:payeeList){
                                    %>
                                    <option value="<%=payee.getpID()%>"> <%=payee.getpName()%></option>
                                    <%
                                    }
                                    %>
                                </select>
                            </label>
                        </div>

                        <div class="form-group">
                            <label for="amount">Amount</label>
                            <input name="amount" type="number" class="form-control" id="amount" aria-describedby="emailHelp" placeholder="Enter Amount">
                        </div>

                        <div class="container text-center">
                            <button type="submit" id="register">Transfer</button>
                            <button type="reset" id="reset">Cancel</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<%
}
%>