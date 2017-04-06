<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hibernate Test</title>
</head>
<style type="text/css">
    th, td {
        border: 1px solid dimgray;
        padding-left: 3px;
        padding-right: 5px;
    }
</style>
<body>
    Clients:
    <br>
    <table>
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Telephone Number</th>
            <th>Contact person</th>
        </tr>
        <c:forEach var="client" items="${clientList}">
            <tr>
                <td>${client.name}</td>
                <td>${client.address}</td>
                <td>${client.telephoneNumber}</td>
                <td>${client.contactPerson}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
