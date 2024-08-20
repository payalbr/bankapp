<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wolters.bankapp.pojos.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Details</title>
</head>
<body>
    <h2>Customer Details</h2>
    <c:if test="${not empty customer}">
        <p>Account Number: ${customer.accountnum}</p>
        <p>Name: ${customer.name}</p>
        <p>Account Balance: ${customer.accountbal}</p>
    </c:if>
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>
    <a href="search.jsp">Search Again</a>
</body>
</html>
