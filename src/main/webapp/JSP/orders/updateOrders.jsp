<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="orders" scope="session" value="${orderToUpdating}" />

<form action="/updateOrders" method="post">
    Date: <input type="date" name="date" value="${orderToUpdating.date}"><br><br>
    Client: <select name="clientId">

    <c:forEach var="client" items="${clientsList}">
        <c:choose>
            <c:when test="${client.id == orderToUpdating.client.id}">
                <option value="${client.id}" selected> ${client.name} </option>
            </c:when>
            <c:when test="${client.id != orderToUpdating.client.id}">
                <option value="${client.id}"> ${client.name} </option>
            </c:when>
        </c:choose>
    </c:forEach>

    </select>
    Cost: <input type="text" name="cost" value="${orderToUpdating.cost}" style="width: 100px;" >
    Discount: <input type="text" name="discount" value="${orderToUpdating.discount}" style="width: 100px;" >
    Paid: <input type="text" name="paid" value="${orderToUpdating.paid}" style="width: 100px;" >
    <input type="submit" value="Update">
</form>
