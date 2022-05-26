<%--
  Created by IntelliJ IDEA.
  User: shubh
  Date: 22-05-2022
  Time: 09:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Online Bank Management</title>
    <%@include file="/common_css_js.jsp"%>
</head>
<body class="back">
<%@include file="navbar.jsp"%>

<div class="container">
    <%@include file="message.jsp"%>
    <h3  style="text-align: center; color: #72d3f1; padding-top: 5%">
        PAYEE DETAILS
    </h3>
    <div class="row">
        <div class="col-sm">
            <a href="AddPayee.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-user-plus" style="font-size: 30px"></i><br>
                    <label>Add Payee</label>
                </div>
            </a>
        </div>

        <div class="col-sm">
            <a href="ActivatePayee.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-circle-check" style="font-size: 30px"></i><br>
                    <label>Activate Payee</label>
                </div>
            </a>
        </div>

        <div class="col-sm">
            <a href="DeletePayee.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-user-xmark" style="font-size: 30px"></i><br>
                    <label>Delete Payee</label>
                </div>
            </a>

        </div>
        <div class="col-sm">
            <a href="ViewPayee.jsp">
                <div class="Payee-box">
                    <i class="fa-solid fa-users-viewfinder" style="font-size: 30px"></i><br>
                    <label>View Payee</label>
                </div>
            </a>
        </div>
    </div>
</div>
<%@include file="common_modals.jsp"%>
</body>
</html>