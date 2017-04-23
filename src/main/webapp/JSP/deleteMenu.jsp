<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="menu" scope="session" value="${dishToDeleting}" />

<table>
    <tr>
        <th>Type</th>
        <th>Name</th>
        <th>Price</th>
        <th>Mass</th>
    </tr>
    <tr>
        <td>${dishToDeleting.type.type}</td>
        <td>${dishToDeleting.name}</td>
        <td>${dishToDeleting.price}</td>
        <td>${dishToDeleting.mass}</td>
    </tr>
</table>
<form action="/deleteDish" method="get">
    <input type="submit" value="Delete">
</form>

