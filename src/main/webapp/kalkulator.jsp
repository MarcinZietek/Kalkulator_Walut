<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin's page</title>
</head>
<body>
<h3>List of values</h3>
<br>
<input type="button" value="Add Values"
       onclick="window.location.href='add-admin-values-form.jsp'; return false;"/>
</br>
<hr>
<table border="1">
    <tr>
        <th>Currency</th>
        <th>Rate</th>
        <th>Action</th>
    </tr>
    <c:forEach var="tempValue" items="${kalkulatorList}" varStatus="counter">
        <tr>
            <td>${tempValue.currency}</td>
            <td>${tempValue.rates}</td>
<%--            <td>${tempValue.allowance}</td>--%>
            <td><a href='${pageContext.request.contextPath}/managerEditServlet?id=${counter.index}'>Edit</a></td>
            <td><a href='${pageContext.request.contextPath}/managerDelServlet?id=${counter.index}'>Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/managerListServlet">Back to list page</a>
<hr>
<br>
<a href="/HomePageServlet">Back to main page</a>
</body>
</html>