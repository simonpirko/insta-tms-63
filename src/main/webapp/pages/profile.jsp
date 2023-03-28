<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div style="max-width: 700px">
        <div class="card flex-grow-1 " style="border-radius: 15px; border: none">
            <div class="d-flex">
                <div class="flex-shrink-0"><img src="${sessionScope.user.avatar}"
                                                class="rounded-circle d-flex" style="width: 50px"
                                                alt="Avatar"/></div>
                <div class="flex-grow-1 ms-3">
                    <h5>@${sessionScope.user.username}</h5>
                    <p class="mb-2 pb-1">
                    <p>Personal information:</p>
                    <p>Full name - ${sessionScope.user.fullName}</p>
                    <p>E-mail - ${sessionScope.user.email}</p>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
