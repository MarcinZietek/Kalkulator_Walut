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
<form action="/exchangeServlet" method="post">
<table border="1">
    <tr>
        <th>ID</th>
        <th>Currency</th>
        <th>Rate</th>
        <th>Amount</th>
        <th>Action</th>
    </tr>
    <c:forEach var="tempValue" items="${kalkulatorList}" varStatus="counter">
        <tr>
            <td><input type="hidden" name="id" value="${counter.index}">${counter.index}</td>
            <td><input type="hidden" name="currency" value="${tempValue.currency}">${tempValue.currency}</td>

            <td><input type="hidden" name="rates" value="${tempValue.rates}">${tempValue.rates}</td>

            <td><input type="number" name="amount"  placeholder="enter amount"/></td>
            <td><input type="submit" value="Exchange"></td>
            <td><a href='${pageContext.request.contextPath}/exchangeServlet?id=${counter.index}'>Exchange</a></td>
        </tr>
    </c:forEach>
</table>
</form>
<br>
<a href="/managerListServlet">Back to list page</a>
<hr>
<br>
<a href="/homePageServlet">Back to main page</a>
</body>
</html>