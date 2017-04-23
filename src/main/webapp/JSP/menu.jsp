<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table>
    <tr>
        <th>Type</th>
        <th>Name</th>
        <th>Price</th>
        <th>Mass</th>
        <th>Services</th>
    </tr>
    <c:forEach var="dish" items="${menu}">
        <tr>
            <td>${dish.type.type}</td>
            <td>${dish.name}</td>
            <td>${dish.price}</td>
            <td>${dish.mass}</td>
            <td>${dish.orderingMenuList[0].servings}</td>
        </tr>
    </c:forEach>

</table>
