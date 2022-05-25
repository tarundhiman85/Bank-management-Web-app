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
<%--    <h4 style="text-align: center;  color: #72d3f1">Customer Profile </h4>--%>
    <div class="row mt-6">
        <div class="col-6 col-sm-3">
            <a href="#">
                <div class="boxDiv">
                    <i class="fa fa-bank  K " style="font-size:42px  "></i><br>
                    <lable>Account Summary</lable><br>
                </div>
            </a>
        </div>
        <div class="col-6 col-sm-3">
            <a href="#">
                <div class="boxDiv">
                    <i class="fa fa-inr   K " style="font-size:42px"></i><br>
                    <lable>Account Statement</lable><br>
                </div>
            </a>
        </div>

        <!-- Force next columns to break to new line -->
        <div class="w-100"></div>

        <div class="col-6 col-sm-3">
            <a href="#">
                <div class="boxDiv">
                    <i class="fa-solid fa-sack-dollar  K  " style="font-size:42px"></i><br>
                    <label>FD and RD</label><br>
                </div>
            </a>
        </div>
        <div class="col-6 col-sm-3">
            <a href="#">
                <div class="boxDiv">
                    <i class="fa fa-user-circle-o  K  " style="font-size:47px"></i><br>
                    <lable>View Account</lable><br>
                </div>
            </a>
        </div>

        <!-- Force next columns to break to new line -->
        <div class="w-100"></div>

        <div class="col-6 col-sm-3">
            <a href="FundTransfer.jsp">
                <div class="boxDiv">
                    <i class="fa-solid fa-money-bill-transfer k5 " style="font-size:42px"></i><br>
                    <label>Fund Transfer</label><br>
                </div>
            </a>
        </div>
        <div class="col-6 col-sm-3">
            <a href="#">
                <div class="boxDiv">
                    <i class="fa-solid fa-money-bill-trend-up k6 " style="font-size:42px"></i><br>
                    <label>Payee</label><br>
                </div>
            </a>
        </div>
    </div>
</div>
<%@include file="common_modals.jsp"%>
</body>

</html>