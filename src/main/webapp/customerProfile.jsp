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
<div class="topnav">
    <a class="active" href="#">XYZ Bank</a>
    <h2>CUSTOMER PORTAL</h2>
    <div class="container  C " >
        <div class="row">
            <div class="col-12">
                <div  class="col-3 ak abc   float-left offset-2 ">
                    <i class="fa fa-bank  K  fa-color" style="font-size:42px  "></i>
                    <h5><a href="#" class="text-center border-info "> Accounts Summary </a></h5>
                </div>
                <div class="col-3 ak abc   float-left offset-2">
                    <i class="fa fa-inr   K   fa-color" style="font-size:42px"></i>
                    <h5><a href="#" class="text-center border-info "> Account Statement </a></h5>
                </div>

            </div>
            <br>
            <br>

            <div class="col-12 mt-5">
                <div class="col-3 ak abc   float-left offset-2">
                    <img src="/img/fdrd.PNG" alt="FDRD">
<%--                    <i  style="font-size:42px"></i>--%>
                    <h5><a href="#" class=" ml-5 "> FD and RD </a></h5>
                </div>
                <div class="col-3 ak abc   float-left offset-2 ">
                    <i class="fa fa-user-circle-o   K   fa-color" style="font-size:42px"></i>
                    <h5><a href="#" class=" ml-4 "> View Account </a></h5>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="common_modals.jsp"%>
</body>

</html>