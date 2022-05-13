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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body {
            background-image: url('image.png');
            background-size: cover;
            height: 100px;
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
    <title>Bank Details</title>
</head>

<body>
<div class="topnav">
    <a class="active" href="#Wipro Bank">Wipro Bank</a>
    <h2>CUSTOMER PORTAL</h2>
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


</body>

</html>