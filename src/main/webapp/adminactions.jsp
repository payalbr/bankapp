<!DOCTYPE html>
<html>
<head>
    <title>Admin Actions</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 20px;
            background-color: #f4f4f4;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        a {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            text-decoration: none;
            color: #fff;
            background-color: #ff00e1;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #ff00e1;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Admin Actions</h2>
        <a href="addcustomer.jsp">Add Customer</a><br>
        <a href="showcust">Show Customer</a><br>
        <a href="delete.jsp">Delete Customer</a>
        <a href="search.jsp">Search Customer</a>
        <a href="update.jsp">Update Customer</a>
    </div>
</body>
</html>
