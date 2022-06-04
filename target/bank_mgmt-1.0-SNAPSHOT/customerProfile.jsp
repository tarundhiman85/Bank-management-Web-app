<%--
  Created by IntelliJ IDEA.
  User: akshay
  Date: 13-05-2022
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <%@include file="/common_css_js.jsp"%>
    <title>Customer Portal</title>
</head>

<body class="back">
<%@include file="navbar.jsp"%>
<div class="container">
    <h3  style="text-align: center; color: #72d3f1; padding-top: 5%">
        Customer Portal
    </h3>
    <div class="row" >
        <div class="col-sm">
            <a href="accountSummary.jsp">
                <div class="Payee-box">
                    <i class="fa fa-bank" style="font-size:50px"></i><br>
                    <label>Account Summary</label>
                </div>
            </a>
        </div>
        <div class="col-sm">
            <a href="transactionHistory.jsp">
                <div class="Payee-box">
                    <i class="fa fa-inr" style="font-size:50px"></i><br>
                    <label>Transaction History</label>
                </div>
            </a>
        </div>



        <div class="col-sm">
            <a href="FdRdPortal.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-sack-dollar" style="font-size:50px"></i><br>
                    <label>FD and RD</label>
                </div>
            </a>
        </div>
        <div class="w-100"></div>
        <div class="col-sm">
            <a href="account.jsp">
                <div class="Payee-box">
                    <i class="fa fa-user-circle-o" style="font-size:50px"></i><br>
                    <label>View Account</label>
                </div>
            </a>
        </div>
        <div class="col-sm">
              <a href="editProfile.jsp?user_id=<%=user1.getUserId()%>">
                <div class="Payee-box">
                    <i class="fa-solid fa-user-pen" style="font-size:50px"></i><br>
                    <label>Edit Profile</label>
                </div>
            </a>
        </div>
        <div class="col-sm">
            <a href="FundTransfer.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-money-bill-transfer" style="font-size:50px"></i><br>
                    <label>Fund Transfer</label>
                </div>
            </a>
        </div>
        <div class="col-sm">
            <a href="Payee.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-money-bill-trend-up" style="font-size:50px"></i><br>
                    <label>Payee</label>
                </div>
            </a>
        </div>
        <div class="w-100"></div>

        <div class="col-sm">
            <a href="withdraw.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-money-check-dollar" style="font-size:50px"></i><br>
                    <label>Withdraw Money</label>
                </div>
            </a>
        </div>
        <div class="col-sm">
            <a href="deposit.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-money-bills" style="font-size:50px"></i><br>
                    <label>Deposit Money</label>
                </div>
            </a>
        </div>
        <div class="col-sm">
            <a href="loan.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-piggy-bank" style="font-size:50px"></i><br>
                    <label>Loan Offers</label>
                </div>
            </a>
        </div>

    </div>
</div>
<%@include file="common_modals.jsp"%>
</body>

</html>
