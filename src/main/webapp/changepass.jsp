<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wolters.bankapp.pojos.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Customer Password</title>
</head>
<body>
    <h2>Update Customer Password</h2>

    <c:choose>
        <c:when test="${not empty customer}">
            <form action="/updatepass" method="post">
                <input type="hidden" name="accountnum" value="${customer.accountnum}"/>
                <p>Current Password: ${customer.password}</p>
                <label for="newPass">New Name:</label>
                <input type="text" id="newPassword" name="newPassword" value="" required/>
                <button type="submit">Update Password</button>
            </form>
        </c:when>
        <c:otherwise>
            <p>${message}</p>
        </c:otherwise>
    </c:choose>

</body>
</html>
