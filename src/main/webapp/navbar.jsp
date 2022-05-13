<%@ page import="com.project.entities.Users" %><%
    Users user1 = (Users) session.getAttribute("current-User");
%>
<nav class="navbar navbar-expand-lg navbar-light  bg-transparent navbar-fixed-top">
<%--<nav class="navbar">--%>
<a class="navbar-brand" style="color: #72d3f1" href="index.jsp">ABC Bank</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="account.jsp">Account Details</a>
            </li>
        </ul>
    </div>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="deposit.jsp">Deposit Funds</a>
            </li>
        </ul>
    </div>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="loan.jsp">Loan Offers</a>
            </li>
        </ul>
    </div>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="withdraw.jsp">Withdraw Money</a>
            </li>
        </ul>
    </div>

    <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="CreateAccount.jsp">Create Account</a>
            </li>
        </ul>
    </div>
    <%
        if(user1==null){
    %>
    <div id="right">
        <ul class="navbar-nav log_cursor">
        <li class="nav-item ">
            <a class="nav-link " data-toggle="modal" data-target="#loginExample" style="cursor: pointer;">Login</a>
        </li>
        <li class="nav-item">
            <a class="nav-link log_cursor" href="register.jsp">Sign Up</a>
        </li>
        </ul>
    </div>
    <%
    } else{
    %>
    <div id="right">
        <ul class="navbar-nav log_cursor">
            <li class="nav-item ">
                <a class="nav-link"  style="cursor: pointer;"><%=user1.getUserName()%></a>
            </li>
            <li class="nav-item">
                <a class="nav-link log_cursor" href="LogoutServlet">Log out</a>
            </li>
        </ul>
    </div>
    <%
        }
    %>
</nav>

