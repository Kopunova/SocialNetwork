<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Social Network</title>
</head>
<body>
<img src="/controllersrc/main/resources/olala-logo.png" alt="здесь должна быть картинка">
<H1>Welcome to Ola-la Network!</H1>

<form action="<c:url value="/user-page"/>" method="POST">
    Email: <input type="text" name="email" value=""/> <br>
    Password: <input type="text" name=password"" value=""/> <br>
    <input type="submit" value="Log in" name="LogIn"/> <a href="/registration">Sign up</a>
</form>

<a href="/all-users">See all users</a>

</body>
</html>


















