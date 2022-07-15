<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Rates page</title>
</head>
<body>
<h3>List of values</h3>
<br>
<hr>
<table border="1">
    <tr>
        <th>Currency</th>
        <th>Rate</th>
        <th>EURO</th>
        <th>Action</th>
    </tr>
    <c:forEach var="tempValue" items="${kalkulatorList}" varStatus="counter">

        <c:url var="tempLink" value="/exchangeServlet">
            <c:param name="command" value="Exchange"/>
            <c:param name="currencyId" value="${tempValue.id}"/>
        </c:url>
        <tr>
            <td><input type="hidden" name="currency" value="${tempValue.currency}">${tempValue.currency}</td>

            <td><input type="hidden" name="rates" value="${tempValue.rates}">${tempValue.rates}</td>

            <td><input type="hidden" name="amount" value="1 Euro"/>1 EURO</td>
            <td><a href="${tempLink}">Exchange</a></td>
        </tr>
    </c:forEach>
</table>
<hr>
<br>
<a href="/homePageServlet">Back to main page</a>
</body>
</html>