
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
<%--                            <input name="Account_Number" type="text" style="border:1px solid #72d3f1;" class="form-control" id="Account_Number" aria-describedby="emailHelp" placeholder="Enter receiver's account number">--%>
                        </div>

                        <div class="form-group">

                            <label>Your Account Type is <%=user.getAccountType().toUpperCase()%></label>
<%--                            <label for="account_type"></label>--%>
<%--                            <select name="account_type" id="account_type" required class="form-control">--%>
<%--                                <option value="saving">Saving</option>--%>
<%--                                <option value="current">Current</option>--%>
<%--                            </select>--%>
                        </div>

                        <div class="form-group">
                            <label>Your Branch Name is <%=user.getBranchName().toUpperCase()%></label>
<%--                            <label for="branch"></label>--%>
<%--                            <select name="branch" id="branch" required class="form-control">--%>
<%--                                <option value="Ahmadabad">Ahmadabad</option>--%>
<%--                                <option value="Bangalore">Bangalore</option>--%>
<%--                                <option value="Chandigarh">Chandigarh</option>--%>
<%--                                <option value="Haryana">Haryana</option>--%>
<%--                                <option value="Pune">Pune</option>--%>
<%--                                <option value="Mumbai">Mumbai</option>--%>
<%--                             </select>--%>
                        </div>

                        <div class="form-group">
                            <label for="PAccount_Number">Payee Account Number</label>
                            <input name="PAccount_Number" type="text" style="border:1px solid #72d3f1;" class="form-control" id="PAccount_Number" aria-describedby="emailHelp" placeholder="Enter receiver's account number">
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