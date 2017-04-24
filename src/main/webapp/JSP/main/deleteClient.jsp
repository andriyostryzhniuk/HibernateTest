<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="client" scope="session" value="${clientToDeleting}" />

<table>
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Telephone Number</th>
        <th>Contact person</th>
    </tr>
    <tr>
        <td>${clientToDeleting.name}</td>
        <td>${clientToDeleting.address}</td>
        <td>${clientToDeleting.telephoneNumber}</td>
        <td>${clientToDeleting.contactPerson}</td>
    </tr>
</table>
<form action="/deleteClient" method="get">
    <input type="submit" value="Delete">
</form>
