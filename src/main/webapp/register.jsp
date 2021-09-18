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
                    <h4 class="text-center my-3">Sign Up Here</h4>
                    <form action="RegisterServlet" method="post">

                        <div class="form-group">
                            <label for="email">User Email</label>
                            <input name="user_email" required type="email" class="form-control" id="email" placeholder="Enter your email here" aria-describedby="emailHelp" >
                        </div>
                        <div class="form-group">
                            <label for="name">User Name</label>
                            <%--                            <input name="user_name" required type="text"  class="form-control" id="name" placeholder="Enter your name here" aria-describedby="emailHelp" >--%>
                            <input name="user_name" style="border:1px solid #72d3f1;" required type="text" class="form-control" id="name" placeholder="Enter your name here" aria-describedby="emailHelp" >

                        </div>
                        <div class="form-group">
                            <label for="password" >User Password</label>
                            <input name="user_password" type="password" required class="form-control" id="password" placeholder="Enter your password" aria-describedby="emailHelp" >
                        </div>
                        <div class="form-group">
                            <label for="phone" >User Phone</label>
                            <input name="user_phone" required type="number" class="form-control" id="phone" placeholder="Enter your phone" aria-describedby="emailHelp" >
                        </div>

                        <div class="form-group">
                            Type of Account &nbsp
                           <select name="account_type" class="btn1" required>
                               <option value="saving">Saving</option>
                               <option value="current">Current</option>
                           </select>
                        </div>
                        <div class="form-group">
                            <label for="phone">User Address</label>
                            <textarea name="user_address" required style="height: 150px" class="form-control" placeholder="Enter your Address">
                           </textarea>
                        </div>
                        <a href="login.jsp" class="text-center d-block mb-2">If Already a User Click Here</a>
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
