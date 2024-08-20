<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mini Statement Request</title>
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
        <form action="ministatement" method="get">
            <h2>Request Mini Statement</h2>
            Enter Account Number: <input type="text" name="accountnum" required>
            <br>
            <input type="submit" value="Get Mini Statement">
        </form>
    </div>
</body>
</html>
