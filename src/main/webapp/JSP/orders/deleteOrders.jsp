<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="orders" scope="session" value="${orderToDeleting}" />

<table>
    <tr>
        <th>Date</th>
        <th>Client</th>
        <th>Cost</th>
        <th>Discount</th>
        <th>Paid</th>
    </tr>
    <tr>
        <td>${orderToDeleting.date}</td>
        <td>${orderToDeleting.client.name}</td>
        <td>${orderToDeleting.cost}</td>
        <td>${orderToDeleting.discount}</td>
        <td>${orderToDeleting.paid}</td>
    </tr>

</table>
<form action="/deleteOrders" >
    <input type="submit" value="Delete">
</form>

