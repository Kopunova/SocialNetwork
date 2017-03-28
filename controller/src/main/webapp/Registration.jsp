<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Registration form</title>
</head>
<body>

<form action="<c:url value="/"/>" method="POST">
    <input type="submit" value="To Main" name="ToMain"/>
</form>

<H1>Registration form</H1>
<form action="<c:url value="/user-page"/>" method="POST">
    Email: <input type="text" name="email" value=""/> <br>
    Name: <input type="text" name="name" value=""/> <br>
    Password: <input type="text" name="password" value=""/> <br>
    <input type="submit" value="Add a photo" name="AddPhoto"/> <br>
    <input type="submit" value="Sign up" name="SignUp"/>
</form>

</body>
</html>



































