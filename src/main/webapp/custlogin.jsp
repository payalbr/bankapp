<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            text-align: center;
            margin-top: 50px;
        }
        .box {
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            display: inline-block;
            width: 300px;
        }
        .box input {
            padding: 10px;
            margin-bottom: 10px;
            width: 100%;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .box input[type="submit"] {
            background-color: #ff00e1;
            color: white;
            cursor: pointer;
        }
        .box input[type="submit"]:hover {
            background-color: #d600c7;
        }
        .message, .errorMessage {
            color: #d600c7;
            font-weight: bold;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="box">
        <form action="custlogin" method="post">
            <label for="accountnum">Enter Account Number:</label>
            <input type="text" id="accountnum" name="accountnum" required>
            <br><br>
            <label for="password">Enter Password:</label>
            <input type="password" id="password" name="password" required>
            <br><br>
            <input type="submit" value="Submit">
        </form>

        <!-- Display messages -->
        <% 
            String message = (String)request.getAttribute("message");
            if (message != null) {
        %>
        <div class="message"><%= message %></div>
        <% } %>

        <% 
            String errorMessage = (String)request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
        <div class="errorMessage"><%= errorMessage %></div>
        <% } %>
    </div>
</body>
</html>
