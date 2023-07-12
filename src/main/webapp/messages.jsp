<%@ page import="by.sterlikov.webbookofreviewsandsuggestions.Model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All messages</title>
</head>
<body>
<%
    List<User> users = (List<User>) request.getAttribute("messages");
    for(User user:users){
        out.println(user);
    }
%><br>
</body>
</html>
