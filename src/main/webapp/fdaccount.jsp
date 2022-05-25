<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FD Account</title>
    <%@include file="/common_css_js.jsp"%>
</head>
<body class="back">
<%@include file="navbar.jsp"%>
<div class="container-fluid">
    <div class="row mt-5">
        <div class="col-md-4 offset-md-4">
            <div class="card">
                <div class="card-body px-5">
                    <h4 class="text-center my-3">Open FD Account Here</h4>
                    <form action="RegisterServlet" method="post">


                        <div class="form-group">
                            <label for="kal" >From Account :</label>
                            <input name="user_phone" required type="number" class="form-control" id="kal" placeholder="Enter Account Number">
                        </div>

                        <div class="form-group">
                            <label for="phone" >Deposit Amount :</label>
                            <input name="deposit_amount" required type="number" class="form-control" id="phone4" placeholder="Enter Deposit Amount" aria-describedby="emailHelp" >
                        </div>

                        <div class="form-group">
                            <label for="phone" >Tenure Of Deposit :</label><br>
                            <select name="tenure" class="btn1" required>
                                <option value="saving">--Select--</option>
                                <option value="saving">6 Months</option>
                                <option value="current">12 Months</option>
                                <option value="current">18 Months</option>
                                <option value="current">24 Months</option>
                                <option value="current">30 Months</option>
                                <option value="current">36 Months</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="kt" >Current Interest Rate  :</label><br>

                            <input type="radio" id="kt" name="fav_language" value="Regular Deposit" >
                            <label for="kt"> 6.5% </label>

                        </div>

                        <div class="form-group">
                            <%--@declare id="phone"--%><label for="phone" >Maturity Amount  :</label>
                            <input name="user_phone" required type="number" class="form-control" id="phone1" placeholder="Enter Maturity Amount" >
                        </div>

                        <div class="form-group">
                            <label for="start" >Maturity Date  :</label><br>
                            <!--<input name="user_phone" required type="number" class="form-control" id="phone" placeholder="DD/MM/YY">-->
                            <input type="date" id="start" name="trip-start" class="form-control"
                                   value="2018-07-22"
                                   min="2018-01-01" max="2030-12-31">
                        </div>



                        <div class="form-group">

                            <input type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
                            <label for="vehicle1"> I wish to save this asa my FD template for further use. </label><br>
                            <input type="checkbox" id="vehicle2" name="vehicle1" value="Bike">
                            <label for="vehicle2"> I accept the Terms and Conditions of the Bank. </label><br>

                        </div>

                        <div class="container text-center">
                            <button id="deposit1">Confirm</button>
                            <button type="reset" id="reset">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
