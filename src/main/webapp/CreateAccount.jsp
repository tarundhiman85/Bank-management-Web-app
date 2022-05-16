<%--
  Created by IntelliJ IDEA.
  User: shubh
  Date: 13-05-2022
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <%@include file="/common_css_js.jsp"%>
</head>
<body class="back">
<%@include file="navbar.jsp"%>
<div class="container-fluid">
    <div class="row mt-5">
        <div class="col-md-4 offset-md-4">
            <div class="card">
                <div class="card-body px-5">
                    <h4 class="text-center my-3">Create Account</h4>
                    <form action="CreateAccount" method="post">

                        <div class="form-group">
                            <label>User Name</label>
                            <input name="first_name" style="border:1px solid #72d3f1;" required type="text" class="form-control" id="firstname" placeholder="Enter your first name here" aria-describedby="emailHelp" ><br>
                            <input name="last_name" style="border:1px solid #72d3f1;" required type="text" class="form-control" id="lastname" placeholder="Enter your last name here" aria-describedby="emailHelp" >
                        </div>

                        <div class="form-group">
                            <label>Fathers Name</label>
                            <input name="fathers_name" style="border:1px solid #72d3f1;" required type="text" class="form-control" id="fathername" placeholder="Enter your name here" aria-describedby="emailHelp" >
                        </div>

                        <div class="form-group">
                            <label for="dob">D.O.B</label>
                            <input name="dob" required type="date" class="form-control" id="dob" placeholder="Enter your name here" aria-describedby="emailHelp">
                        </div>

                        <div class="form-grouo">
                            <label for="gender">Gender</label>
                            <select name="gender" id="gender" required class="form-control">
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Others">Others</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="address">Permanent Address</label>
                            <textarea name="user_address" placeholder="Enter your Permanent Address" required style="height: 150px" class="form-control" id="address">
                           </textarea>
                        </div>

                        <div class="form-group">
                            <label for="address">Present Address</label>
                            <textarea name="present_address" placeholder="Enter your Present Address" required style="height: 150px" class="form-control" id="presentaddress" >
                           </textarea>
                        </div>

                        <div class="form-group">
                            <label for="panno" >PAN Number</label>
                            <input name="pan_number" style="border:1px solid #72d3f1;" required type="number" class="form-control" id="panno" placeholder="Pan Number" aria-describedby="emailHelp" >
                        </div>

                        <div class="form-group">
                            <label for="phone" >User Phone</label>
                            <input name="user_phone" style="border:1px solid #72d3f1;" required type="number" class="form-control" id="phone" placeholder="Enter your phone" aria-describedby="emailHelp" >
                        </div>

                        <div class="form-group">
                            Type of Account &nbsp
                            <select name="account_type" class="btn1" required>
                                <option value="saving">Saving</option>
                                <option value="current">Current</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>Opening Balance</label>
                            <input name="opening_balance" style="border:1px solid #72d3f1;" class="form-control" required type="number" min="5000" id="balance" placeholder="Minimum 5000 ">
                        </div>
                        <a href="login.jsp" class="text-center d-block mb-2">If Already have an Click Here</a>
                        <div class="container text-center">
                            <button id="deposit1">Register</button>
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
