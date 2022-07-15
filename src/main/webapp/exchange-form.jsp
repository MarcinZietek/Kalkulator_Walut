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
        <tr>
            <td><label>Currency</label></td>
            <td><input type="hidden" name="currency" value="${currencyId.currency}"/>${currencyId.currency}</td>
        </tr>
        <tr>
            <td><label>Rates</label></td>
            <td><input type="hidden" name="rates" value="${currencyId.rates}"/>${currencyId.rates}</td>
        </tr>
        <tr>
            <td><label>Exchange amount</label></td>
            <td><input type="number" min="1" name="amount" value="${currencyId.amount}"/></td>
        </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Exchange"/></td>
        </tr>
        </tbody>
    </table>
</form>
<a href="/homePageServlet">Back to index page</a>
</body>
</html>
