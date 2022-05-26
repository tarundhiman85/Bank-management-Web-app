<%@ page import="com.project.dao.UserDao" %>
<%@ page import="com.project.entities.RDAccount" %>
<%@ page import="com.project.helper.FactoryProvider" %>
<%@ page import="com.project.entities.FDAccount" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Close RD</title>
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
else
{
    UserDao userDao = new UserDao(FactoryProvider.getFactory());
    FDAccount fdAccount = userDao.getFDAccountByUserId(user.getUserId());
    if(fdAccount==null){
%>
<div class="card1">
    <h2>You need to create an FD Account</h2>
    <a href="fdaccount.jsp">Click Here</a>
</div>
<%
}
else{

%>
<div class="container-fluid">
    <div class="row al">
        <div class="col-md-4">
            <div class="card mt-3">
                <div class="card-header custom-bg">
                    <h3>Close FD</h3>
                </div>
                <div class="card-body">
                    <%@include file="message.jsp"%>
                    <form action="closeFDRDServlet" method="post">
                        <div class="form-group">
                            <%--@declare id="exampleinputemail1"--%><label for="exampleInputEmail1">Your Account Number is: <%=user.getAccountNo()%></label>
                        </div>
                        <div class="form-group">
                            <%--@declare id="exampleinputpassword1"--%><label for="exampleInputPassword1">In Your RD the Deposited Amount is: <%=fdAccount.getDepositAmount()%></label>
                        </div>
                        <div class="form-group">
                            <%--@declare id="exampleinputpassword1"--%><label for="exampleInputPassword1">In Your Rd the Maturity Amount is: <%=fdAccount.getMaturityAmount()%></label>
                        </div>
                        <div style="margin-bottom: 15px">
                            <p class="text-center d-block mb-2">If closing before maturity then 1% charge will be levied</p>
                        </div>
                        <input type="hidden" name="close" value="fd">
                        <div class="container text-center">
                            <button type="submit" id="register">Click to Close FD</button>
                            <button type="reset" id="reset">Reset</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%
        }
    }
%>
</body>
</html>
