
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
                <div class="card-body">
                    <%@include file="message.jsp"%>
                    <form action="LoginServlet" method="post">
                        <div class="form-group">
                            <h3>Fund Transfer</h3>
                        </div>

                        <div class="form-group">
                            <label for="Account Number">Account Number</label>
                            <input name="Account Number" type="text" style="border:1px solid #72d3f1;" class="form-control" id="Account Number" aria-describedby="emailHelp" placeholder="Enter receiver's account number">
                        </div>

                        <div class="form-group">
                            <label for="name">Name</label>
                            <input name="name" type="text" style="border:1px solid #72d3f1;" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter receiver's name">
                        </div>

                        <div class="form-group">
                            <label for="ifsc">IFSC Code</label>
                            <input name="ifsc" type="text" style="border:1px solid #72d3f1;" class="form-control" id="ifsc" aria-describedby="emailHelp" placeholder="Enter your IFSC code">
                        </div>

                        <div class="form-group">
                            <label for="amount">Amount</label>
                            <input name="amount" type="number" class="form-control" id="amount" aria-describedby="emailHelp" placeholder="Enter Amount">
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Enter your password">
                        </div>

                        <div class="container text-center">
                            <button type="submit" id="register">Transfer</button>
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
