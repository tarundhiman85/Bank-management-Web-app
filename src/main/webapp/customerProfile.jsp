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
<h2>CUSTOMER PORTAL</h2>
<div class="container  C ">
    <div class="row">
        <div class="col-12">
            <div class="col-3 ak1 float-left offset-2 ">
                <i class="fa fa-bank  K " style="font-size:42px  "></i>
                <h5><a href="#" class="text-center ml-2 border-info "> Accounts Summary </a></h5>
            </div>
            <div class="col-3 ak2  float-left offset-2">
                <i class="fa fa-inr   K " style="font-size:42px"></i>
                <h5><a href="#" class="text-center ml-2 border-info "> Account Statement </a></h5>
            </div>

        </div>
        <br>
        <br>

        <div class="col-12 mt-5">
            <div class="col-3 ak3   float-left offset-2">
                <i class="fa-solid fa-sack-dollar  K  " style="font-size:42px"></i>
                <h5><a href="#" class=" ml-5 "> FD and RD </a></h5>
            </div>
            <div class="col-3 ak4  float-left offset-2 ">
                <i class="fa fa-user-circle-o  K  " style="font-size:42px"></i>
                <h5><a href="#" class=" ml-4"> View Account </a></h5>
            </div>
        </div>
        <br>
        <br>

        <div class="col-12 mt-5">
            <div class="col-3 ak5 float-left offset-2">
                <i class="fa-solid fa-comments-dollar k5 " style="font-size:42px"></i>
                <h5 class="h5"><a href="#" class=" ml-4 "> Fund Transfer </a></h5>
            </div>
            <div class="col-3 ak6  float-left offset-2 ">
                <i class="fa-solid fa-money-bill-trend-up k6 " style="font-size:42px"></i>
                <h5><a href="#" class=" ml-2 ">Payee</a></h5>
            </div>

        </div>

    </div>
</div>
<%@include file="common_modals.jsp"%>
</body>

</html>