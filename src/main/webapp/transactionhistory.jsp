<%@ page import="java.util.List" %>
<%@ page import="com.project.dao.UserDao" %><%--
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
<div class="container-fluid">
    <div class="row al">
        <div class="col-md-6">
            <div class="card mt-3">
                <div class="card-body">
                    <%@include file="message.jsp"%>
                    <table class="table table-striped table-bordered" style="color:#72d3f1">
                        <thead>
                        <tr>
                            <th>Transaction ID</th>
                            <th>Reference Number</th>
                            <th>Transaction Type</th>
                            <th>PAccount Number</th>
                            <th>Date Time</th>
                            <th>Amount</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>10001</td>
                            <td>12345</td>
                            <td>online</td>
                            <td>987654321</td>
                            <td>29th-may-2022</td>
                            <td>3000</td>
                        </tr>
                        <tr>
                        <td>10002</td>
                        <td>12346</td>
                        <td>online</td>
                        <td>987654322</td>
                        <td>29th-may-2022</td>
                        <td>5000</td>
                        </tr>
                        </tbody></table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>