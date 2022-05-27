<%--
  Created by IntelliJ IDEA.
  User: Tarun Dhiman
  Date: 27-05-2022
  Time: 01:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="/common_css_js.jsp"%>
    <title>FD RD Portal</title>
</head>

<body class="back">
<%@include file="navbar.jsp"%>
<div class="container">
    <h3  style="text-align: center; color: #72d3f1; padding-top: 5%">
        FD RD Portal
    </h3>
    <div class="row" >
        <div class="col-sm">
            <a href="fdaccount.jsp">
                <div class="Payee-box">
                    <i class="fa fa-bank" style="font-size:50px"></i><br>
                    <label>Create FD Account</label>
                </div>
            </a>
        </div>
        <div class="col-sm">
            <a href="rdaccount.jsp">
                <div class="Payee-box">
                    <i class="fa fa-bank" style="font-size:50px"></i><br>
                    <label>Create RD Account</label>
                </div>
            </a>
        </div>


        <div class="w-100"></div>

        <div class="col-sm">
            <a href="PayRd.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-sack-dollar" style="font-size:50px"></i><br>
                    <label>Pay RD Monthly</label>
                </div>
            </a>
        </div>
        <div class="col-sm">
            <a href="closefd.jsp">
                <div class="Payee-box">
                    <i class="fa fa-close" style="font-size:50px"></i><br>
                    <label>Close FD</label>
                </div>
            </a>
        </div>

        <div class="w-100"></div>

        <div class="col-sm">
            <a href="closerd.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-close" style="font-size:50px"></i><br>
                    <label>Close RD</label>
                </div>
            </a>
        </div>
    </div>
</div>

<%@include file="common_modals.jsp"%>
</body>
</html>
