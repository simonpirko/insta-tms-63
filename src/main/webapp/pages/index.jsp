<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<body>
<c:set var="message" value="${requestScope.get(\"message\")}"/>
<jsp:include page="header.jsp"/>

<c:if test="${not empty message}">
    ${message}
</c:if>

<jsp:include page="footer.jsp"/>
</body>
</html>