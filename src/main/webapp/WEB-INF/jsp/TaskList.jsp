<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>

<%--<!DOCTYPE HTML>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8" />--%>
<%--    <title>Task List</title>--%>
<%--    <style type="text/css">--%>

<%--        label {--%>
<%--            display: inline-block;--%>
<%--            width: 200px;--%>
<%--            margin: 5px;--%>
<%--            text-align: left;--%>
<%--        }--%>
<%--        input[type=text], input[type=password], select {--%>
<%--            width: 200px;--%>
<%--        }--%>

<%--        button {--%>
<%--            background-color: #4CAF50; /* Green */--%>
<%--            border: none;--%>
<%--            color: white;--%>
<%--            padding: 15px 32px;--%>
<%--            text-align: center;--%>
<%--            text-decoration: none;--%>
<%--            display: inline-block;--%>
<%--            font-size: 16px;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Task List</h1>--%>
<%--<div>--%>
<%--    <a type="button" class="btn btn-primary btn-md" href="/add-task">Add Todo</a>--%>
<%--</div>--%>

<%--<br/><br/>--%>
<%--<div>--%>
<%--    <table border="1">--%>
<%--        <tr>--%>
<%--            <th>Task Name</th>--%>
<%--            <th>Task Description</th>--%>
<%--            <th>Id</th>--%>
<%--            <th>Is Completed</th>--%>
<%--            <th>------------</th>--%>
<%--            <th>------------</th>--%>

<%--        </tr>--%>
<%--        <c:forEach  items="${tasks}" var ="task">--%>

<%--            <tr>--%>
<%--                <td>${task.taskName}</td>--%>
<%--                <td>${task.taskDescription}</td>--%>
<%--                <td>${task.id}</td>--%>
<%--                <td>${task.isDone}</td>--%>

<%--                <td>--%>
<%--                    <a type="button" class="btn btn-success"--%>
<%--                       href="/update-task?id=${task.id}">Update</a>--%>
<%--                </td>--%>
<%--                    <td>--%>
<%--                        <a type="button" class="btn btn-warning"--%>
<%--                           href="/delete-task?id=${task.id}">Delete</a>--%>
<%--                    </td>--%>

<%--            </tr>--%>

<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>

<%--</html>--%>

<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Task List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<br><br><br>
<body class="container">
<h1><strong> Task List </strong></h1>
<div>
    <a type="button" class="btn btn-primary btn-md" href="/add-task">Add Todo</a>
</div>

<br/><br/>
<div>
    <!-- <table border="1">
        <tr>
            <th>Task Name</th>
            <th>Task Description</th>
            <th>Id</th>
            <th>Is Completed</th>
            <th>------------</th>
            <th>------------</th>

        </tr>
        <c:forEach  items="${tasks}" var ="task">

            <tr>
                <td>${task.taskName}</td>
                <td>${task.taskDescription}</td>
                <td>${task.id}</td>
                <td>${task.isDone}</td>

                <td>

                </td>
                    <td>

                    </td>

            </tr>

        </c:forEach>
    </table> -->

    <table class="table table-bordered" style="text-align: center;">
        <thead>
        <tr>
            <th scope="col">Task Name</th>
            <th scope="col">Task Description</th>
            <th scope="col">Task ID</th>
            <th scope="col">Is Completed</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tasks}" var="task">

            <tr>
                <td>${task.taskName}</td>
                <td>${task.taskDescription}</td>
                <td>${task.id}</td>
                <td>${task.isDone}</td>
                <td><a type="button" class="btn btn-success" href="/update-task?id=${task.id}"><strong> Update</strong></a>
                </td>
                <td><a type="button" class="btn btn-warning" href="/delete-task?id=${task.id}"><strong> Delete</strong></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>

</html>