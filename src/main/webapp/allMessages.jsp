<%@ page import="by.sterlikov.webbookofreviewsandsuggestions.Model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>all messages</title>
</head>
<body>
<h1>Список всех сообщений</h1>
<%
  List<User> users = (List<User>) request.getAttribute("messages");
  for(User user:users){
    out.println(user);
  }
%>


<ul>
    <c:forEach var="user" items="${messages}">
        <c:if test="${user.login=='sergey'}">
        <li><c:out value="${user}" /></li>
        </c:if>
    </c:forEach>
</ul>

<ul>
    <c:forEach var="user" items="${messages}">
        <c:if test="${user.login=='pavel'}">
            <li><c:out value="${user}"/></li>
        </c:if>
    </c:forEach>
</ul>
<a href="deletingAll.jsp">Deleting all messages</a>
</body>
</html>
