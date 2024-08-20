<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login</title>
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
            background-color: #ff00e1;
        }
    </style>
</head>
<body>
    <div class="box">
        <form action=" adminlogin" >
            Enter User id:<input type="text" name="username" >
            <br>   <br>
            Enter password:<input type="text"  name="password" >
            <br>   <br>
            <input type="submit" name="adminlogin">

        </form>   
    </div>
</body>
</html>
