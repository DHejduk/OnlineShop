
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container" id="container">
    <form:form action="/login" method="post" modelAttribute="userLogin">
        <h1>Sign In To Your Account</h1>
        <form:input type="text" placeholder="Username"/>
        <form:input type="password" placeholder="Password"/>
        <!--            <input type="repassword" placeholder="Repeat password"/>-->
        <button>Sign In</button>
    </form:form>
</div>
<script src="script.js"></script>
</body>
</html>