<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hibernate test Orders</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="/resources/jquery-3.2.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container-fluid">
        <div class="col-md-5">

            <b>Orders:</b><br>
            <div class="table-responsive">
                <table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Client</th>
                            <th>Cost</th>
                            <th>Discount</th>
                            <th>Paid</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${orders}">
                            <tr>
                                <td>${order.date}</td>
                                <td>${order.client.name}</td>
                                <td>${order.cost}</td>
                                <td>${order.discount}</td>
                                <td>${order.paid}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
            </table>
        </div>
    </div>

        <div class="col-md-7">

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
