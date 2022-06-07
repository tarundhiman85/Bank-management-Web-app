<%@ page import="com.project.helper.FactoryProvider" %>
<%@ page import="com.project.dao.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.entities.Stocks" %><%--
  Created by IntelliJ IDEA.
  User: Tarun Dhiman
  Date: 05-06-2022
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Your Stocks</title>
    <%@include file="/common_css_js.jsp"%>
</head>
<body class="back">
<%@include file="navbar.jsp"%>
<div class="container-fluid">
    <h3  style="text-align: center; color: #72d3f1; padding-top: 5%">
        View Stocks
    </h3>
    <div class="row al">
        <div class="col-md-4">
            <div class="card mt-3">
                <div class="card-body">
                    <%@include file="message.jsp"%>
                    <%Users user = (Users) session.getAttribute("current-User");
                        List<Stocks> stockList = new UserDao(FactoryProvider.getFactory()).getStockList(user);
                    %>

                    <table class="table table-striped table-bordered" style="color:#72d3f1">
                        <thead>
                        <tr>
                            <th>Stock Id</th>
                            <th>Stock Name</th>
                            <th>Price Bought</th>
                            <th>Sell</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% if(stockList !=null && stockList.size()>0){ %>
                        <% for(Stocks s: stockList){ %>
                        <tr>
                            <td><%=s.getId()%></td>
                            <td><%=s.getSymbol()%></td>
                            <td><%=s.getPrice()%></td>
                            <td> <a href="SellStock.jsp?stock_id=<%=s.getId()%>">View</a></td>
                        </tr>
                        <% }
                        }%>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
