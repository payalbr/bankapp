<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Details</title>
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
        <h2>Customer Details</h2>

        <c:if test="${not empty customer}">
            <p><strong>Account Number:</strong> ${customer.accountnum}</p>
            <p><strong>Name:</strong> ${customer.name}</p>
            <p><strong>Account Balance:</strong> ${customer.accountbal}</p>
        </c:if>

        <c:if test="${not empty errorMessage}">
            <div class="error-message">${errorMessage}</div>
        </c:if>

        <a href="custactions.jsp">Back to Customer Actions</a>
    </div>
</body>
</html>
