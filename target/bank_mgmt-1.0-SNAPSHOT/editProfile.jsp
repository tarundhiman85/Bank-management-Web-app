<%@ page import="org.hibernate.Session" %>
<%@ page import="com.project.helper.FactoryProvider" %><%--
  Created by IntelliJ IDEA.
  User: Tarun Dhiman
  Date: 02-06-2022
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
    <%@include file="/common_css_js.jsp"%>
</head>
<body class="back">
<%@include file="navbar.jsp"%>
<%
    int userId=Integer.parseInt(request.getParameter("user_id").trim());
    Session s= FactoryProvider.getFactory().openSession();
    Users user = s.get(Users.class,userId);
    s.close();
%>
<div class="container-fluid">

    <div class="row mt-5">
        <div class="col-md-4 offset-md-4">
            <div class="card">
                <div class="card-body px-5">
                    <%@include file="message.jsp"%>
                    <%@include file="errorMsg.jsp"%>
                    <h4 class="text-center my-3">Create Account</h4>
                    <form action="UpdateUserServlet" method="post">
                        <div>
                            <label>Email</label>
                            <label for="email"></label><input name="email" required type="email" value="<%=user.getUserEmail()%>" class="use-keyboard-input form-control" id="email" placeholder="Enter Email Address" aria-describedby="emailHelp"><br>
                        </div>

                        <div>
                            <label>Password</label>
                            <label for="password"></label><input name="password" value="<%=user.getUserPassword()%>" required type="password" class="use-keyboard-input form-control" id="password" placeholder="Enter Password" ><br>
                        </div>

                        <div class="form-group">
                            <label for="fullName">Full Name</label>
                            <input name="fullName" value="<%=user.getUserName()%>" required type="text" style="border:1px solid #72d3f1;" class="use-keyboard-input form-control" id="fullName" placeholder="Enter your name here" aria-describedby="emailHelp"><br>
                        </div>

                        <div class="form-group">
                            <label for="fathername">Fathers Name</label>
                            <input name="fathers_name" value="<%=user.getFatherName()%>" required type="text" style="border:1px solid #72d3f1;" class="use-keyboard-input form-control" id="fathername" placeholder="Enter your name here" aria-describedby="emailHelp" >
                        </div>

                        <div class="form-group">
                            <label for="dob">D.O.B</label>
                            <input name="dob" value="<%=user.getDob()%>" required type="date" class="form-control" id="dob" placeholder="Enter your DOB here" onclick="dobValidate();" aria-describedby="emailHelp">
                        </div>

                        <div class="form-group">
                            <label for="gender">Gender</label>
                            <select name="gender" id="gender" required class="form-control">
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Others">Others</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="pan_no">PAN Number</label>
                            <input name="pan_Number1" value="<%=user.getPanNo()%>" required type="text" class="use-keyboard-input form-control" id="pan_no" placeholder="Enter your PAN Number" aria-describedby="emailHelp" >
                        </div>

                        <div class="form-group">
                            <label for="phone" >User Phone</label>
                            <input name="user_phone" value="<%=user.getMobilePhone()%>" required type="number" class="use-keyboard-input form-control" id="phone" placeholder="Enter your phone" aria-describedby="emailHelp" >
                        </div>

                        <div class="form-group">
                            <label for="phone" >Landline Number</label>
                            <input name="LNumber" value="<%=user.getLandline()%>" required type="number" class="use-keyboard-input form-control" id="phone2" placeholder="Enter your Landline Number else -1" aria-describedby="emailHelp" >
                        </div>
                        <input type="hidden" value="<%=user.getUserId()%>" name="user_id">
                        <div class="container text-center">
                            <button id="register">Update</button>
                            <button type="reset" id="reset">Reset</button>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
