<%
    String eMessage=(String) session.getAttribute("errorMsg");
    if(eMessage!=null){
%>
<div class="alert alert-success alert-dismissible fade show" role="alert">
    <strong><%=eMessage%></strong>
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>
<%
        session.removeAttribute("errorMsg");
    }
%>