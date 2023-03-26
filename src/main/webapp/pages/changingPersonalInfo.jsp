<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>change personal info</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <jsp:include page="header.jsp"/>
  <div class="row align-items-center h-100">
    <div class="col-md-8 offset-md-5">
      <form action="/changePassword" method="post">
        <p>Change personal info:</p>
        <div class="col-sm-4 my-auto">
          <p>E-mail Address</p>
          <p><input type="text" class="form-control" name="email" placeholder="${email}"></p>
          <p>Full Name</p>
          <p><input type="text" class="form-control" name="fullName" placeholder="${fullName}"></p>
          <p>Avatar</p>
          <p><input type="text" class="form-control" name="avatar" placeholder="${avatar}"></p>
          <div class="d-grid gap-2">
            <p style="color: red">${message}</p>
            <button class="btn btn-success">save</button>
          </div>
        </div>
      </form>
    </div>
  </div>
  <jsp:include page="footer.jsp"/>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
