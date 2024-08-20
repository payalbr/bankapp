<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deposit Money</title>
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
        .summary-box p {
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <div class="box">
        <form action="deposit" method="post">
            <h2>Deposit Money</h2>
            Enter Account Number: <input type="text" name="accountnum" required>
            <br>
            Enter Deposit Amount: <input type="number" name="amount" step="0.01" min="0" required>
            <br>
            <input type="submit" value="Deposit Money">
        </form>
    </div>

</body>
</html>
