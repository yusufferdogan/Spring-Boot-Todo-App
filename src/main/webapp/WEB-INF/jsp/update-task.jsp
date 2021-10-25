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
        input[type=checkbox] {
            display: inline-block;
            margin-right: 190px;
        }

        button {
            padding: 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>Update Task</h2>
    <form:form action="update-task" method="post" modelAttribute="task">
    <form:hidden path="id" />
        <form:label path="taskName">Enter Task Name</form:label>
        <form:input path="taskName"/><br/>

        <form:label path="taskDescription">Enter Task Description:</form:label>
        <form:textarea path="taskDescription"/><br/>

        <form:label path="isDone">is Completed</form:label>
        <form:checkbox path="isDone"/><br/>

        <form:button>Update Task</form:button>
    </form:form>
</div>
</body>
</html>