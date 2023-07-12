<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add message page</title>
</head>
<body>
<h1><%= "Enter your Email and Login" %>
</h1>
<br/>
<form action="/messages" method="post">
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Email address</label>
        <input type="email" class="form-control" id="exampleFormControlInput1" name="eMail" placeholder="name@example.com">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Your Message</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" name="message" rows="3"></textarea>
    </div>
    <div class="d-grid gap-2">
        <button class="btn btn-primary" type="submit">Send</button>
        <button class="btn btn-primary" type="reset">Reset</button>
    </div>
</form>
</body>
</html>
