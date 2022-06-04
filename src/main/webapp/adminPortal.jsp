<%@ page import="com.project.helper.FactoryProvider" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.dao.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="/common_css_js.jsp"%>
    <title>Admin Portal</title>
</head>
<body class="back">
<%@include file="navbar.jsp"%>
<div class="container">
    <%
         UserDao ud=new UserDao(FactoryProvider.getFactory());
         List<Users> users=ud.getAllUsers();
    %>
    <h3  style="text-align: center; color: #72d3f1; padding-top: 5%">
        Admin Portal
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
                <div class="Payee-box">
                    <i class="fa-solid fa-users" style="font-size:50px"></i><br>
                    <label>Number of Users: <%=users.size()-1%></label>
                </div>
        </div>
        <div class="col-sm">
            <a href="CreateAccount.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-user-plus" style="font-size:50px"></i><br>
                    <label>Add User</label>
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
        <div class="w-100"></div>
        <div class="col-sm">
            <a href="account.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-user-shield" style="font-size:50px"></i><br>
                    <label>View Account</label>
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
            <a href="viewUsers.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-users-rectangle" style="font-size:50px"></i><br>
                    <label>View Users</label>
                </div>
            </a>
        </div>
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
    </div>

</div>
<%@include file="common_modals.jsp"%>
</body>
</html>
