<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Close RD Account</title>
  <%@include file="/common_css_js.jsp"%>
</head>
<body class="back">
<%@include file="navbar.jsp"%>
<div class="container-fluid">
  <div class="row mt-5">
    <div class="col-md-4 offset-md-4">
      <div class="card">
        <div class="card-body px-5">
          <h4 class="text-center my-3">Close RD Account Here</h4>
          <form action="RegisterServlet" method="post">

            <div class="form-group">
              <label for="get1" >RD Account Number :</label>
              <input name="user_phone" required type="number" class="form-control" id="get1" placeholder="Enter Account Number">
            </div>

            <div class="form-group">
              <label for="get" >Saving/Current Account Number :</label>
              <input name="user_phone" required type="number" class="form-control" id="get" placeholder="Enter Account Number">
            </div>

            <div class="form-group">
              <label for="get" >RD Amount :</label>
              <input name="user_phone" required type="number" class="form-control" id="get2" placeholder="Enter RD Amount ">
            </div>


            <div class="form-group">

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
