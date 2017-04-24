<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hibernate test Orders</title>
</head>
<body>

    Orders: <br>
    <table>
        <tr>
            <th>Date</th>
            <th>Client</th>
            <th>Cost</th>
            <th>Discount</th>
            <th>Paid</th>
        </tr>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.date}</td>
                <td>${order.client.name}</td>
                <td>${order.cost}</td>
                <td>${order.discount}</td>
                <td>${order.paid}</td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
