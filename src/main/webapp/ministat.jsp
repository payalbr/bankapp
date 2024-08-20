<!-- ministat.jsp -->
<html>
<head>
    <title>Mini Statement</title>
</head>
<body>
    <h1>Customer Details</h1>
    <p>Account Number: ${customer.accountnum}</p>
    <p>Name: ${customer.name}</p>
    <p>Account Balance: ${customer.accountbal}</p>

    <h2>Transaction History</h2>
    <c:choose>
        <c:when test="${not empty transactions}">
            <ul>
                <c:forEach var="transaction" items="${transactions}">
                    <li>${transaction}</li>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <p>No transactions found.</p>
        </c:otherwise>
    </c:choose>

    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>
</body>
</html>
