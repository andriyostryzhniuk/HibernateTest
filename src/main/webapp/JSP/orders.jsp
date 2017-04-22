<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="client" scope="session" value="${clientToShow_orders}" />

<table>
    <tr>
        <th>Date</th>
        <th>Cost</th>
        <th>Discount</th>
        <th>Paid</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.date}</td>
            <td>${order.cost}</td>
            <td>${order.discount}</td>
            <td>${order.paid}</td>
        </tr>
    </c:forEach>

</table>

<br>
Show order menu:
<form action="/showMenu" method="post" >
    <input type="date" name="date">
    <input type="submit" value="Show menu">
</form>

<c:if test="${menu != null}">
    <c:import url="menu.jsp" >
        <c:param name="menu" value="${menu}" />
    </c:import>
</c:if>