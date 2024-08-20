<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wolters.bankapp.pojos.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Customer Name</title>
</head>
<body>
    <h2>Update Customer Name</h2>

    <c:choose>
        <c:when test="${not empty customer}">
            <form action="/makeup" method="post">
                <input type="hidden" name="accountnum" value="${customer.accountnum}"/>
                <p>Current Name: ${customer.name}</p>
                <label for="newName">New Name:</label>
                <input type="text" id="newName" name="newName" value="" required/>
                <button type="submit">Update Name</button>
            </form>
        </c:when>
        <c:otherwise>
            <p>${message}</p>
        </c:otherwise>
    </c:choose>

</body>
</html>
