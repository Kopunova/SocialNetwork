<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>UserPage</title>
</head>
<body>

<form action="<c:url value="/"/>" method="POST">
    <input type="submit" value="To Main" name="ToMain"/>
</form>

<H1>UserPage</H1>
</body>
</html>
