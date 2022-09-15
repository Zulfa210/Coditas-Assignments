<jsp:useBean id = "obj" class="model.Employee"/>
<% obj = (model.Employee) session.getAttribute("employee") %>
<%= obj.getFirstName()%>
<%= obj.getLastName()%>
<%= obj.getAddress()%>
<%= obj.getContact()%>
