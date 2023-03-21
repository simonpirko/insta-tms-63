<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12.03.2023
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="/auth" method="post">
    <input type="text" placeholder="Username">
    <br>
    <input type="text" placeholder="Password">
    <br>
    <td><input type="checkbox" name="RememberMe"
               value="Check me out" /></td>
    <td>Check me out</td>
    <br>
    <button>Sign in</button>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
