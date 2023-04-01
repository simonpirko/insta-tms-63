<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row align-items-center h-100">
        <div class="col-md-8 offset-md-5">
            <form action="/createPost" method="post">
                <p>Create post</p>
                <div class="col-sm-4 my-auto">
                    <p><input type="text" class="form-control" name="url" placeholder="Url"></p>
                    <p><input type="text" class="form-control" name="description" placeholder="Description"></p>
                    <div class="d-grid gap-2">
                        <p style="color: red">${message}</p>
                        <button class="btn btn-success">Create post</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<jsp:include page="footer.jsp"/>
</body>
</html>
