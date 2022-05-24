<%--
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
                    <form action="LoginServlet" method="post">
                        <div class="form-group">
                            <h3>View payee</h3>
                        </div>

                        <div class="form-group">
                            <label for="Account Number">Account Number</label>
                            <input name="Account Number" type="text" style="border:1px solid #72d3f1;" class="form-control" id="Account Number" aria-describedby="emailHelp" placeholder="Enter payee's account number">
                        </div>

                        <div class="form-group">
                            <label for="name">Name</label>
                            <input name="name" type="text" style="border:1px solid #72d3f1;" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter payee's name">
                        </div>

                        <div class="form-group">
                            <label for="ifsc">IFSC Code</label>
                            <input name="ifsc" type="text" style="border:1px solid #72d3f1;" class="form-control" id="ifsc" aria-describedby="emailHelp" placeholder="Enter your IFSC code">
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Enter your password">
                        </div>

                        <div class="container text-center">
                            <button type="submit" id="register">View</button>
                            <button type="reset" id="reset">Cancel</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>



