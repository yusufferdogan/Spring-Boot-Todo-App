<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration Success</title>
    <style type="text/css">
        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
            text-align: left;
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
    <h2>Registration Succeeded!</h2>
    <span>Welcome :</span><span>${user.email}</span><br/>

    <a type="button" class="btn btn-success"
       href="/TaskList">Go to the Tasks</a>
</div>
</body>
</html>