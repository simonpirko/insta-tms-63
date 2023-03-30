<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Instagram</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<c:if test="${sessionScope.user == null}">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Instagram</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/register">Registration</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/auth">Authorization</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</c:if>

<c:if test="${sessionScope.user != null}">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/pages/account.jsp">Instagram</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent2">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="#">My posts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/create-post">Create post</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/edit-password">Edit password</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/edite-personal-info">Edit personal info</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/delete-account">Delete account</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: darkred" href="/logout">Logout</a>
                </li>
            </ul>
            <form action="/searching-profile" method="post" class="d-flex">
                <input class="form-control me-2" name="username" placeholder="Username">
                <button class="btn btn-outline-success" type="submit">find</button>
            </form>
        </div>
    </div>
</nav>
</c:if>



