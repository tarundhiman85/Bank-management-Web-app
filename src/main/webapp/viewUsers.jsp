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
    <h3  style="text-align: center; color: #72d3f1; padding-top: 5%">
        View Users
    </h3>
    <div class="row al">
            <div class="card mt-3">
                <div class="card-body" style="max-width: 95%; margin: auto">
                    <%@include file="message.jsp"%>
                    <%--                    by jsp get list of payee--%>
                    <%Users user = (Users) session.getAttribute("current-User");
                        List<Users> users = new UserDao(FactoryProvider.getFactory()).getAllUsers();
                    %>

                    <table class="table table-striped table-bordered" style="color:#72d3f1; margin: auto; max-width: 90% ">
                        <thead>
                        <tr>
                            <th>User Id</th>
                            <th>Name</th>
                            <th>Account Number</th>
                            <th>Account Type</th>
                            <th>IFSC Code</th>
                            <th>Phone Number</th>
                            <th>Balance</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% if(users!=null && users.size()>0){ %>
                        <% for(Users u:users){ %>
                        <tr>
                            <td><%=u.getUserId()%></td>
                            <td><%=u.getUserName()%></td>
                            <td><%=u.getAccountNo()%></td>
                            <td><%=u.getAccountType().toUpperCase()%></td>
                            <td><%=u.getIfscCode()%></td>
                            <td><%=u.getMobilePhone()%></td>
                            <td><%=u.getBalance()%></td>
                            <td><%=u.getUserEmail()%></td>
                            <td><%=u.getUserAddress()%></td>
                            <td>
                                <a href="editProfile.jsp?user_id=<%=u.getUserId()%>" style="font-size: 17px; text-decoration: none" class="link">Update</a>
                                <a href="DeleteUserServlet?user_id=<%=u.getUserId()%>" style="font-size: 17px; text-decoration: none" class="link">Delete</a>
                            </td>
                        </tr>
                        <% }
                        }%>
                        </tbody>

                    </table>
                </div>
            </div>

    </div>
</div>
</body>
</html>

