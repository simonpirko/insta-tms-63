<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Comments</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <form action="/comment" method="post">
        <div class="row align-items-center h-100">
            <div class="col-md-7 offset-md-5">
                <div class="col-sm-5 my-auto">
                    <p>Comments</p>
                    <ul>
                        <c:forEach items="${comments}" var="comment">
                            <li>${comment}</li>
                        </c:forEach>
                    </ul>
                    <label for="comment" class="form-label">leave comment</label>
                    <textarea class="form-control" id="comment" rows="1"
                              name="body" placeholder="comment"></textarea>
                    <div class="d-grid gap-2">
                        <p style="color: red">${message}</p>
                        <button class="btn btn-success flex-grow-0">post</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <jsp:include page="footer.jsp"/>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
