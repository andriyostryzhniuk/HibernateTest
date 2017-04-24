<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hibernate test Orders</title>
</head>
<style type="text/css">
    th, td {
        border: 1px solid dimgray;
        padding-left: 3px;
        padding-right: 5px;
    }
</style>
<body>

    <div style="width: 100%;">
        <div style="float:left; width: 40%">

            <b>Orders:</b><br>
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

        </div>

        <div style="float:left;">

            <br><br><b>Create order:</b><br>
            <form action="/addOrder" method="post">
                Date: <input type="date" name="date"><br><br>
                Client: <select name="clientId">
                    <option value="Choose client">Choose client</option>

                    <c:forEach var="client" items="${clientsList}">
                        <option value="${client.id}"> ${client.name} </option>
                    </c:forEach>
                </select>
                Cost: <input type="text" name="cost" style="width: 100px;" >
                Discount: <input type="text" name="discount" style="width: 100px;" >
                Paid: <input type="text" name="paid" style="width: 100px;" >
                <input type="submit" value="Create">
            </form>


            <br><b>Update order:</b><br>
            <form action="/chooseOrder" method="get">
                Date: <input type="date" name="date" value="${orderToUpdating.date}">
                Client: <select name="clientId">
                    <option value="Choose client">Choose client</option>

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
                <input type="hidden" name="operation" value="Updating">
                <input type="submit" value="Updating">
            </form>
            <c:if test="${orderToUpdating != null}">
                <c:import url="updateOrders.jsp" >
                    <c:param name="orderToUpdating" value="${orderToUpdating}" />
                    <c:param name="date" value="${date}" />
                    <c:param name="clientsList" value="${clientsList}" />
                </c:import>
            </c:if>


            <br><b>Delete order:</b><br>
            <form action="/chooseOrder" method="get">
                Date: <input type="date" name="date" value="${orderToDeleting.date}">
                Client: <select name="clientId">
                <option value="Choose client">Choose client</option>

                <c:forEach var="client" items="${clientsList}">
                    <c:choose>
                        <c:when test="${client.id == orderToDeleting.client.id}">
                            <option value="${client.id}" selected> ${client.name} </option>
                        </c:when>
                        <c:when test="${client.id != orderToDeleting.client.id}">
                            <option value="${client.id}"> ${client.name} </option>
                        </c:when>
                    </c:choose>
                </c:forEach>

            </select>
                <input type="hidden" name="operation" value="Deleting">
                <input type="submit" value="Deleting">
            </form>
            <c:if test="${orderToDeleting != null}">
                <c:import url="deleteOrders.jsp" >
                    <c:param name="orderToDeleting" value="${orderToDeleting}" />
                </c:import>
            </c:if>

        </div>
    </div>
    <%--<div style="clear:both"></div>--%>

</body>
</html>
