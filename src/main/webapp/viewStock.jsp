
<%@ page import="com.project.entities.Stocks" %><%--
  Created by IntelliJ IDEA.
  User: Tarun Dhiman
  Date: 05-06-2022
  Time: 07:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Stock</title>
    <%@include file="/common_css_js.jsp"%>
</head>
<body class="back">
<%@include file="navbar.jsp"%>
<%
    Users user = (Users) session.getAttribute("current-User");
    Stocks stock = (Stocks) session.getAttribute("stocky");
    if(user==null){
%>
<div class="card1">
    <h2>You need to Sign in</h2>
    <a href="login.jsp">Click Here</a>
</div>
<%
}
else if(stock==null){
%>
<div class="card1">
    <h2>No Stock Found by Searched Name</h2>
    <a href="SearchStock.jsp">Search Again</a>
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
    <h2>Stock Details</h2>
    <table class="table table-striped table-bordered" style="color:#72d3f1">
        <tr>
            <td>Stock Name</td>
            <td><%=stock.getSymbol()%></td>
        </tr>
        <tr>
            <td>Stock Price</td>
            <td><%=stock.getPrice()%></td>
        </tr>
        <tr>
            <td>Stock Quantity</td>
            <td><%=stock.getVolume()%></td>
        </tr>
        <tr>
            <td>Open</td>
            <td><%=stock.getOpen()%></td>
        </tr>
        <tr>
            <td>High</td>
            <td><%=stock.getHigh()%></td>
        </tr>
        <tr>
            <td>Low</td>
            <td><%=stock.getLow()%></td>
        </tr>
        <tr>
            <td>Previous Close Price</td>
            <td><%=stock.getPrevClose()%></td>
        </tr>
        <tr>
            <td>Change</td>
            <td><%=stock.getChange()%></td>
        </tr>
        <tr>
            <td>Change Percent</td>
            <td><%=stock.getChangePercent()%></td>
        </tr>
        <td>
            <form action="BuyStockServlet" method="post">
                <input class="btn btn-primary" type="submit" value="Buy">
            </form>
        </td>
<%--        <tr>--%>
<%--            <td>Stock Image</td>--%>
<%--            <td><img src="<%=stock.getStockImage()%>" alt="<%=stock.getStockName()%>" width="100px" height="100px"></td>--%>
<%--        </tr>--%>
    </table>
<%
    }
%>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
