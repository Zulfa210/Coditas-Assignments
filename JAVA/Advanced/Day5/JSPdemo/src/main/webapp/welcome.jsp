<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Name: <%= request.getParameter("name") %>
<br>
Password: <%= request.getParameter("password") %>
<%
String name = request.getParameter("name");
String password = request.getParameter("password");
application.setAttribute("name",  name);
application.setAttribute("password",  password);
 response.setHeader("refresh", "3,URL =hello.jsp");

 pageContext.setAttribute("name", name,PageContext.SESSION_SCOPE);
  pageContext.setAttribute("password", password,PageContext.SESSION_SCOPE );

   pageContext.setAttribute("name", name,PageContext.APPLICATION_SCOPE);
   pageContext.setAttribute("password", password,PageContext.APPLICATION_SCOPE );

   pageContext.setAttribute("name", name,PageContext.PAGE_SCOPE);
   pageContext.setAttribute("password", password,PageContext.PAGE_SCOPE );

    pageContext.setAttribute("name", name,PageContext.REQUEST_SCOPE);
    pageContext.setAttribute("password", password,PageContext.REQUEST_SCOPE );
 %>

 <c:set var="name" value="Zulfa Attar"></c:set>
 <c:out value="${name}"></c:out>
 <c:if test="${3>2}">
 <h2>Inside If Block</h2>
 </c:if>
</body>
</html>