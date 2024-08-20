<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transfer Money</title>
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
            margin-bottom: 20px;
        }
        .box input, .box select {
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
            background-color: #ff00b3;
        }
        .message {
            color: green;
            font-weight: bold;
        }
        .error-message {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="box">
        <form action="transfer" method="post">
            <h2>Transfer Money</h2>
            From Account Number: <input type="text" name="fromAccountnum" required>
            <br>
            To Account Number: <input type="text" name="toAccountnum" required>
            <br>
            Amount: <input type="number" name="amount" step="0.01" min="0" required>
            <br>
            <input type="submit" value="Transfer Money">
        </form>
    </div>
    
    <c:if test="${not empty message}">
        <div class="message">${message}</div>
    </c:if>
    
    <c:if test="${not empty errorMessage}">
        <div class="error-message">${errorMessage}</div>
    </c:if>

    <a href="custactions.jsp">Back to Customer Actions</a>
</body>
</html>
