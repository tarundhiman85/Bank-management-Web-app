<%@ page import="java.util.List" %>
<%@ page import="com.project.dao.UserDao" %>
<%@ page import="com.project.helper.FactoryProvider" %>
<%@ page import="com.project.entities.Transact" %><%--
  Created by IntelliJ IDEA.
  User: shubh
  Date: 22-05-2022
  Time: 03:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transaction History</title>
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
%>
<div class="container-fluid">
    <div class="row al">

            <div class="card mt-3">
                <div class="card-body" style="max-width: 95%; margin: auto">
                    <%@include file="message.jsp"%>
                    <%
                        List<Transact> transactList = new UserDao(FactoryProvider.getFactory()).getTransactionHistoryList(user.getUserId());
                    %>

                    <table class="table table-striped table-bordered" style="color:#72d3f1; margin: auto; max-width: 90%  ">
                        <thead>
                        <tr>
                            <th>Transaction ID</th>
                            <th>Reference Number</th>
                            <th>Transaction Type</th>
                            <th>PAccount Number</th>
                            <th>Date Time</th>
                            <th>Amount</th>
                            <th>Status</th>
                        </tr>
                        </thead>
                        <tbody>

                        <%
                            //iterate list from last to first
                            for(int i=transactList.size()-1; i>=0; i--){
                                %>
                        <tr>
                            <td><%=transactList.get(i).gettId()%></td>
                            <td><%=transactList.get(i).getReferenceNo()%></td>
                            <td><%=transactList.get(i).getTransactionType()%></td>
                            <td><%=transactList.get(i).getpAccountNumber()%></td>
                            <td><%=transactList.get(i).getTime()%></td>
                            <td><%=transactList.get(i).getAmount()%></td>
                            <td><%=transactList.get(i).getStatus()%></td>
                        </tr>
                        <%
                         }
                        %>
                        </tbody></table>
                </div>
            </div>

    </div>
</div>
<%
    }
    %>
</body>
</html>