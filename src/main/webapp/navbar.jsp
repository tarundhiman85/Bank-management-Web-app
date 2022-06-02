<%@ page import="com.project.entities.Users" %><%
    Users user1 = (Users) session.getAttribute("current-User");
%>
<nav class="navbar navbar-expand-lg navbar-light  bg-transparent navbar-fixed-top">
<%--<nav class="navbar">--%>
<a class="navbar-brand" style="color: #72d3f1" href="index.jsp">XYZ Bank</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <%
        if(user1==null){
    %>
    <div id="right">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="login.jsp">Login</a>
            </li>
        </ul>
    </div>
    <%
    } else if(user1.getRoleId()==2){
    %>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="loan.jsp">Loan Offers</a>
            </li>
        </ul>
    </div>
    <div id="right">
        <ul class="navbar-nav log_cursor">
            <li class="nav-item ">
                <a class="nav-link" href="customerProfile.jsp" style="cursor: pointer;">Welcome <%=user1.getUserName()%></a>
            </li>
            <li class="nav-item">
                <a class="nav-link log_cursor" href="LogoutServlet">Log out</a>
            </li>
        </ul>
    </div>
    <%
    } else if(user1.getRoleId()==1){
    %>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="adminPortal.jsp">Admin Portal</a>
            </li>
        </ul>
    </div>
    <div id="right">
        <ul class="navbar-nav log_cursor">
            <li class="nav-item ">
                <a class="nav-link" href="adminPortal.jsp" style="cursor: pointer;">Welcome Admin</a>
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
<%@include file="common_modals.jsp"%>