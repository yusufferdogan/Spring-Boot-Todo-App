<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Adding Task</title>
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
    <h2>Adding Task</h2>
    <form:form action="add-task" method="post" modelAttribute="task">
        <form:hidden path="id" />
        <form:label path="taskName">Enter Task Name</form:label>
        <form:input path="taskName"/><br/><br/><br/>

        <form:label path="taskDescription">Enter Task Description:</form:label>
        <form:textarea path="taskDescription"/><br/><br/><br/>

        <form:label path="isDone">is Completed</form:label>
        <form:checkbox path="isDone"/><br/><br/><br/>

        <form:button>Add Task</form:button>
    </form:form>
</div>
</body>
</html>