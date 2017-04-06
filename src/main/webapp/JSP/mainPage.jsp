<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
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

    <br><br>Create client:<br>
    <form action="/addClient" th:object="${client}" method="post">
        Name: <input type="text" name="name">
        Address: <input type="text" name="address">
        Telephone number: <input type="text" name="telephoneNumber">
        Contact person: <input type="text" name="contactPerson">
        <input type="submit" value="Submit">
    </form>

    <br><br>Update client:<br>
    <form action="/chooseClient" method="get">
        Input client's name: <input type="text" name="clientName" value="${clientName}">
        <input type="submit" value="Submit">
    </form>
    <c:if test="${clientToUpdating != null}">
        <c:import url="updateClient.jsp" >
            <c:param name="clientToUpdating" value="${clientToUpdating}" />
        </c:import>
    </c:if>

</body>
</html>
