<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Registration Form</title>
    <style type="text/css">
        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
            text-align: left;
        }
        input[type=text], input[type=password], select {
            width: 200px;
        }

        button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>User Registration</h2>
    <form:form action="register" method="post" modelAttribute="user">
        <form:label path="email">E-mail:</form:label>
        <form:input path="email"/><br/><br/>

        <form:label path="password">Password:</form:label>
        <form:password path="password"/><br/><br/>

        <form:button>Register</form:button>
    </form:form><br/><br/>
    <a type="button" class="btn btn-success"
       href="/login">Have an Account ? Login</a>
</div>
</body>
</html>