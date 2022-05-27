<%@ page import="com.project.entities.Payee" %>
<%@ page import="com.project.dao.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.helper.FactoryProvider" %><%--
  Created by IntelliJ IDEA.
  User: shubh
  Date: 22-05-2022
  Time: 03:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Payee</title>
    <%@include file="/common_css_js.jsp"%>
</head>
<body class="back">
<%@include file="navbar.jsp"%>
<div class="container-fluid">
    <div class="row al">
        <div class="col-md-4">
            <div class="card mt-3">
                <div class="card-body">
                    <%@include file="message.jsp"%>
                    <%--                    by jsp get list of payee--%>
                    <%Users user = (Users) session.getAttribute("current-User");
                        List<Payee> payeeList = new UserDao(FactoryProvider.getFactory()).getPayeeList(user.getUserId());
                    %>

                    <table class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Payee Name</th>
                            <th>Account Number</th>
                            <th>IFSC Code</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% if(payeeList!=null && payeeList.size()>0){ %>
                        <% for(Payee payee:payeeList){ %>
                        <tr>
                            <td><%=payee.getpName()%></td>
                            <td><%=payee.getpAccountNumber()%></td>
                            <td><%=payee.getpIFSC()%></td>
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

