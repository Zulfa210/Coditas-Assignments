<html>
<body>
<h1>Hello Page</h1>
Name: <%= application.getAttribute("name") %>
<br>
Password: <%= application.getAttribute("password") %>
<br>
<h3> Page Context</h3>
<h3> SESSION_SCOPE</h3>
Name: <%=  pageContext.getAttribute("name",PageContext.SESSION_SCOPE) %>
<br>
Password: <%= pageContext.getAttribute("password",PageContext.SESSION_SCOPE ) %>
<br>
<h3> APPLICATION_SCOPE</h3>
Name: <%=pageContext.getAttribute("name",PageContext.APPLICATION_SCOPE) %>
<br>
Password: <%= pageContext.getAttribute("password",PageContext.APPLICATION_SCOPE ) %>
<br>
<h3> PAGE_SCOPE</h3>
Name: <%=  pageContext.getAttribute("name",PageContext.PAGE_SCOPE) %>
<br>
Password: <%= pageContext.getAttribute("password",PageContext.PAGE_SCOPE ) %>
<br>
<h3> REQUEST_SCOPE</h3>
Name: <%= pageContext.getAttribute("name",PageContext.REQUEST_SCOPE) %>
<br>

Password: <%=  pageContext.getAttribute("password",PageContext.REQUEST_SCOPE ) %>
<br>


</body>
</html>