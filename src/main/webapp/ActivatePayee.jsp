<%@ page import="com.project.entities.Payee" %>
<%@ page import="com.project.dao.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.helper.FactoryProvider" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Activate Payee</title>
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
          <%--                    by jsp get list of payee--%>
          <%
            Users user = (Users) session.getAttribute("current-User");
            List<Payee> payeeList = new UserDao(FactoryProvider.getFactory()).getPayeeList(user.getUserId());
          %>

          <table class="table table-striped table-bordered">
            <thead>
            <tr>
              <th>Payee Name</th>
              <th>Account Number</th>
              <th>IFSC Code</th>
              <th>Activate</th>
            </tr>
            </thead>
            <tbody>
            <% if(payeeList!=null && payeeList.size()>0){ %>
            <% for(Payee payee:payeeList){ %>
            <tr>
              <td><%=payee.getpName()%></td>
              <td><%=payee.getpAccountNumber()%></td>
              <td><%=payee.getpIFSC()%></td>
              <td>
                <%if(!payee.isActivated()) {%>
                  <form action="PayeeServlet" method="post">
                    <input type="hidden" id="hiddenSubmit" value="Activate" name="PayeeOp"/>

                    <input type="hidden" id="hiddenSubmitId" value="<%=payee.getpID()%>" name="payeeId"/>
                    <input class="btn btn-primary" type="submit" value="Activate">
                </form>
                <%}else{%>
                  <button class="btn btn-primary" disabled>Activated</button>
                <%}%>
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
</div>
</body>
</html>

