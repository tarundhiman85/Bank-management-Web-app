<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FD Account</title>
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
    <div class="row mt-5">
        <div class="col-md-4 offset-md-4">
            <div class="card">
                <div class="card-body px-5">
                    <%@include file="message.jsp"%>
                    <h4 class="text-center my-3">Open FD Account Here</h4>
                    <form action="FDServlet" method="post">


                        <div class="form-group">
                            <%--@declare id="kal"--%><label for="kal" >Your Account No: <%=user.getAccountNo()%></label>
<%--                            <input name="account_no" required type="number" class="form-control" id="kal" placeholder="Enter Account Number">--%>
                        </div>

                        <div class="form-group">
                            <label for="phone" >Deposit Amount :</label>
                            <input name="deposit_amount" required type="number" class="form-control" id="phone4" placeholder="Enter Deposit Amount" aria-describedby="emailHelp" >
                        </div>

                        <div class="form-group">
                            <label for="phone" >Tenure Of Deposit :</label><br>
                            <select name="tenure" class="btn1" required style="background-color: #041d30; color: #72d3f1">
                                <option value="6">6 Months</option>
                                <option value="12">12 Months</option>
                                <option value="18">18 Months</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="kt" >Current Interest Rate  :</label><br>
                            <input type="radio" id="kt" name="fav_language" value="Regular Deposit" >
                            <label for="kt"> 6.5% </label>

                        </div>

                        <div class="form-group">
                            <%--@declare id="phone"--%><label for="phone" >Maturity Amount  will be Calculated after Confirmation</label>
                        </div>

                        <div class="form-group">
                            <%--@declare id="start"--%><label for="start" >Maturity Date will be Calculated after Confirmation</label><br>
                        </div>


                        <div class="container text-center">
                            <button id="register">Confirm</button>
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
%>
</body>
</html>
