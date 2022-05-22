
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
          <h4 class="text-center my-3">View Account</h4>
          <form action="RegisterServlet" method="post">

            <div class="form-group">
              <label for="name">User Full Name </label>
              <input name="user_name" style="border:1px solid #72d3f1;" required type="text" class="form-control" id="name" placeholder="Enter your full name here" aria-describedby="emailHelp" >
            </div>
            <div class="form-group">
              <label for="f-name">Father Name</label>
              <input name="father_name" style="border:1px solid #72d3f1;" required type="text" class="form-control" id="f-name" placeholder="Enter your father name" aria-describedby="emailHelp" >
            </div>
            <div class="form-group">
              <label for="email">User Email</label>
              <input name="User_email" required type="email" class="form-control" id="email" placeholder="Enter your email here" aria-describedby="emailHelp" >
            </div>
            <div class="form-group">
              <label for="DOB">D.O.B.</label>
              <input name="User_dob" required type="date" class="form-control" id="DOB" >
            </div>
            <div class="form-group">
               <lable for="gender">Gender</lable>

                <input required type="radio" name="gender">Male
                <input required type="radio" name="gender">Female

            </div>
            <div class="form-group">
               <label for="phone">Mobile Number</label>
               <input name="User_phone" style="border:1px solid #72d3f1;" required type="number" class="form-control" id="phone" placeholder="Enter your number here" aria-describedby="emailHelp">
            </div>

            <div class="form-group">
              <label for="landline">Landline number</label>
              <input name="user_landline" required type="number" class="form-control" id="landline" placeholder="Enter your landline number" aria-describedby="emailHelp" >
            </div>

            <div class="form-group">
               <label for="pan">Pan Number</label>
               <input name="user_pan" required type="number" class="form-control" id="pan" placeholder="Enter your pan number" aria-describedby="emailHelp">
            </div>

            <div class="form-group">
              <lable for="phone">User Address</lable>
              <textarea name="user_address" required style="height: 150px" class="form-control" placeholder="Enter your address"></textarea>

            </div>

            <div class="form-group">
               <lable for="id">User ID</lable>
               <input name="User_id" required type="number" class="form-control" id="id" placeholder="Enter your User id here" aria-describedby="emailHelp">
            </div>

            <div class="form-group">
              Type of Account &nbsp
              <select name="account_type" class="btn1" required>
                <option value="saving">Saving</option>
                <option value="current">Current</option>
              </select>
            </div>
            <div class="form-group">
               <label for="balance">Opening Balance</label>
               <input name="open-balance"  required type="number" class="form-control" id="balance" placeholder="Enter your opening balance" aria-describedby="emailHelp">
            </div>
            <div class="form-group">
              <label for="card" >User Card Number</label>
              <input name="user_card" required type="number"  class="form-control" id="card" placeholder="Enter your card number" aria-describedby="emailHelp" >
            </div>
            <div class="form-group">
              <lable for="custom">Customer ID</lable>
              <input name="custom_id" required type="number" class="form-control" id="custom" placeholder="Enter your Customer id here" aria-describedby="emailHelp">

            </div>


          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
