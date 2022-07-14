<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 14.07.2022
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Exchange form</title>
</head>
<body>

<form action="/exchangeServlet" method="post">
    <table>
        <tbody>
<%--        <c:forEach var="tempValue" items="${kalkulatorList}" varStatus="counter">--%>
            <tr>
                <td><label>Currency</label></td>
                <p>${kalkulator.currency}</p>
<%--                <td><input value="${kalkulator.currency}"/></td>--%>
            </tr>
            <tr>
                <td><label>Rates</label></td>
                <p>${kalkulator.rates}</p>
<%--                <td><input value="${kalkulator.rates}"/></td>--%>
            </tr>
            <tr>
                <td><label>Exchange amount</label></td>
                <p>${amount}</p>
<%--                <td><input value="${kalkulator.amount}"/></td>--%>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Exchange"/></td>
            </tr>
<%--        </c:forEach>--%>
        </tbody>
    </table>
</form>
<a href="/homePageServlet">Back to index page</a>
</body>
</html>
