<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12.03.2023
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>

<body>
<jsp:include page="header.jsp"/>
<form action="/register" method="post">
  <input type="text" placeholder="Email">
  <br>
  <input type="text" placeholder="Username">
  <br>
  <input type="text" placeholder="Full name">
  <br>
  <input type="text" placeholder="Password">
  <br>
  <button>Sign up</button>
</form>
<a href="auth.jsp"> Sign in</a>
<jsp:include page="footer.jsp"/>
</html>
</body>
