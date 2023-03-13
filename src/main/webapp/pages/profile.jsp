<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 13.03.2023
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<jsp:include page="header.jsp"/>
    <p>${user.username}</p>
    <p>${user.password}</p>
    <p>${user.email}</p>
    <p>${user.fullname}</p>
    <p>${user.createAt}</p>
    <p>${user.updateAt}</p>
    <jsp:include page="footer.jsp"/>
</body>
</html>
