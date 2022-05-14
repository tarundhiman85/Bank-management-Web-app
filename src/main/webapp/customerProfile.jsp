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
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        h2 {
            color: aliceblue;
            font-family: 'Times New Roman', Times, serif;
            font-size: 20px;
            padding-top: 40px;

        }
        .fa-color {
            color: rgb(255, 166, 0);
        }
        .topnav a.active{
            float: left;
            color: white;
            text-align: center;
            background-color: rgb(40, 87, 112);
            text-decoration: none;
            font-size: 17px;
        }
    </style>
    <title>Customer Portal</title>
</head>

<body class="back">
<%@include file="navbar.jsp"%>
<div class="topnav">
    <a class="active" href="#">XYZ Bank</a>
<%--    <h2>CUSTOMER PORTAL</h2>--%>
    <div class="container mt-5">
        <div class="row">
            <div class="col-12">
                <div class="col-3 border-right  float-left offset-1">
                    <i class="fa fa-bank ml-5  fa-color" style="font-size:30px "></i>
                    <h5><a href="#" class="text-center"> Accounts Summary </a></h5>
                </div>
                <div class="col-3 border-right float-left offset-1 ">
                    <i class="fa fa-inr ml-5   fa-color" style="font-size:30px"></i>
                    <h5><a href="#" class="text-center"> Account Statement </a></h5>
                </div>

            </div>
            <br>
            <br>

            <div class="col-12 mt-5">
                <div class="col-3 border-right float-left offset-1 ">
                    <i class="fa-solid fa-sack-dollar ml-4   fa-color" style="font-size:30px"></i>
                    <h5><a href="#" class="text-center"> FD and RD </a></h5>
                </div>
                <div class="col-3 border-right float-left offset-1 ">
                    <i class="fa fa-user-circle-o ml-5    fa-color" style="font-size:30px"></i>
                    <h5><a href="#" class="text-center"> View Account </a></h5>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="common_modals.jsp"%>
</body>

</html>