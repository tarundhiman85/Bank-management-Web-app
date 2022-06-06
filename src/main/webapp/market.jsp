<%@ page import="com.project.entities.profitLoss" %>
<%@ page import="com.project.dao.UserDao" %>
<%@ page import="com.project.helper.FactoryProvider" %><%--
  Created by IntelliJ IDEA.
  User: Tarun Dhiman
  Date: 05-06-2022
  Time: 09:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock Market</title>
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
  }else{
    profitLoss pr = new UserDao(FactoryProvider.getFactory()).getProfitLossByUserId(user.getUserId());
    if(pr==null){
      pr=new profitLoss();
      pr.setLoss("0");
      pr.setProfit("0");
    }
%>

<div class="container">
  <h3  style="text-align: center; color: #72d3f1; padding-top: 5%">
    Stock Market
  </h3>
  <div class="row" >
    <div class="col-sm">
      <a href="SearchStock.jsp">
        <div class="Payee-box">
          <i class="fa-solid fa-magnifying-glass-chart" style="font-size:50px"></i><br>
          <label>Search Stock</label>
        </div>
      </a>
    </div>
    <div class="col-sm">
      <a href="viewStocks.jsp">
        <div class="Payee-box">
          <i class="fa-solid fa-hand-holding-dollar" style="font-size:50px"></i><br>
          <label>Stock Holdings</label>
        </div>
      </a>
    </div>
    <div class="w-100"></div>
    <div class="col-sm">
        <div class="Payee-box">
          <i class="fa-solid fa-sack-dollar" style="font-size:50px"></i><br>
          <label>Current Profit: <%=pr.getProfit()%></label>
        </div>
    </div>
    <div class="col-sm">
        <div class="Payee-box">
          <i class="fa-solid fa-angles-down" style="font-size:50px"></i><br>
          <label>Current Loss: <%=pr.getLoss()%></label>
        </div>
    </div>


  </div>
</div>
<%
  }%>
</body>
</html>
