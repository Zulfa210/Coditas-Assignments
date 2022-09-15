<html>
<body>
<h2>Hello World!</h2>
<%@ page import = "java.time.LocalDate" %>

<%
     out.println("Using out implicit object<br>");
     LocalDate date = LocalDate.now();
     out.println("Today's Date is: " + date + "<br>");
     out.println("Tomorrow's Date is: " + date.plusDays(1) + "<br>");
     out.println("Yesterday's Date is: " + date.minusDays(1));


%>
<br>
<form action="welcome.jsp">
Name: <input type = "text" name = "name"><br>
Password: <input type = "password" name = "password"><br>
<input type = "submit" >
</form>
</body>
</html>
