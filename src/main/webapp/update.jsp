
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wolters.bankapp.pojos.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Customer</title>
</head>
<body>
    <h2>Update Customer Name</h2>

    <form action="/update" method="get">
        Enter Customer Account Number <input type="text" name="accountnum"/><br>
        <input type="submit" name="Update Customer Name"/>
        </form>
</body>
</html>
