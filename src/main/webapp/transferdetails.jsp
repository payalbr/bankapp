<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transfer Details</title>
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
        .details-box {
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            display: inline-block;
            width: 300px;
            margin: 20px;
        }
        .details-box p {
            margin: 10px 0;
        }
        .summary {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="box">
        <h2>Transfer Details</h2>
        
        <c:if test="${not empty message}">
            <div class="message">${message}</div>
        </c:if>

        <div class="details-box">
            <h3>Sender Details</h3>
            <c:if test="${not empty fromCustomer}">
                <p><strong>Account Number:</strong> ${fromCustomer.accountnum}</p>
                <p><strong>Name:</strong> ${fromCustomer.name}</p>
                <p><strong>Account Balance:</strong> ${fromCustomer.accountbal}</p>
            </c:if>
        </div>

        <div class="details-box">
            <h3>Receiver Details</h3>
            <c:if test="${not empty toCustomer}">
                <p><strong>Account Number:</strong> ${toCustomer.accountnum}</p>
                <p><strong>Name:</strong> ${toCustomer.name}</p>
                <p><strong>Account Balance:</strong> ${toCustomer.accountbal}</p>
            </c:if>
        </div>

        <a href="custactions.jsp">Back to Customer Actions</a>
    </div>
</body>
</html>
