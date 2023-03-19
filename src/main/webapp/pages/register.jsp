<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<form action="/register" method="post">
    <div class="container">
        <div class="row align-items-center h-100">
            <div class="col-md-8 offset-md-5">
                <p>Registration:</p>
                <div class="col-sm-4 my-auto">
                    <p><input type="text" class="form-control" name="email" placeholder="Email"></p>
                    <p><input type="text" class="form-control" name="fullName" placeholder="Full Name"></p>
                    <p><input type="text" class="form-control" name="username" placeholder="Username"></p>
                    <p><input type="password" class="form-control" name="password" placeholder="Password"></p>
                    <p><input type="url" class="form-control" name="avatar" placeholder="Avatar"></p>
                    <div class="d-grid gap-2">
                        <button class="btn btn-primary">Sign up</button>
                    </div>
                    <p style="color: red">${message}</p>
                </div>
            </div>
        </div>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>