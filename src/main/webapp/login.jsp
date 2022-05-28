
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="/common_css_js.jsp"%>
</head>
<body class="back">
<%@include file="navbar.jsp"%>
<div class="container-fluid">
    <div class="row al">
        <div class="col-md-4">
<div class="card mt-3">
    <div class="card-header custom-bg">
        <h3>Login Here</h3>
    </div>
    <div class="card-body">
        <%@include file="message.jsp"%>
        <form action="LoginServlet" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <div class="container text-center">
                <button type="submit" id="register">Login</button>
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
