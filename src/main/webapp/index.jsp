<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1><%= "Enter your login" %>
</h1>
<br/>
<form action="/login" method="post">
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Your Login</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" name="login" placeholder="Your login">
    </div>
    <div class="d-grid gap-2">
        <button class="btn btn-primary" type="submit">Login</button>
        <button class="btn btn-primary" type="reset">Reset</button>
    </div>
</form>
</body>
</html>