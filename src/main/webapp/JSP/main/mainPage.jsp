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

    <form>
        <button formaction="/menuPage" > Menu </button>
        <button formaction="/ordersPage" > Orders </button>

        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <button formaction="/logout" > Logout </button>
                <button formaction="/admin" > Admin </button>
                <br>Welcome: ${pageContext.request.userPrincipal.name}
            </c:when>
            <c:otherwise>
                <button formaction="/login" > Sign In </button>
                <button formaction="/registrationPage" > Registration </button>
            </c:otherwise>
        </c:choose>
    </form>

    <br><b>Clients:</b><br>
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


    <br><br><b>Create client:</b><br>
    <form action="/addClient" th:object="${client}" method="post">
        Name: <input type="text" name="name">
        Address: <input type="text" name="address">
        Telephone number: <input type="text" name="telephoneNumber">
        Contact person: <input type="text" name="contactPerson">
        <input type="submit" value="Create">
    </form>


    <br><b>Update client:</b><br>
    <form action="/chooseClient" method="get">
        Input client's name: <input type="text" name="clientName" value="${clientToUpdating.name}">
        <input type="hidden" name="operation" value="Updating">
        <input type="submit" value="Updating">
    </form>
    <c:if test="${clientToUpdating != null}">
        <c:import url="updateClient.jsp" >
            <c:param name="clientToUpdating" value="${clientToUpdating}" />
        </c:import>
    </c:if>


    <br><b>Delete client:</b><br>
    <form action="/chooseClient" method="get">
        Input client's name: <input type="text" name="clientName" value="${clientToDeleting.name}">
        <input type="hidden" name="operation" value="Deleting">
        <input type="submit" value="Deleting">
    </form>
    <c:if test="${clientToDeleting != null}">
        <c:import url="deleteClient.jsp" >
            <c:param name="clientToDeleting" value="${clientToDeleting}" />
        </c:import>
    </c:if>


    <br><b>Show client's orders:</b><br>
    <form action="/showOrders" method="post">
        Input client's name: <input type="text" name="clientName" value="${clientToShow_orders.name}">
        <input type="submit" value="Show orders">
    </form>
    <c:if test="${clientToShow_orders != null}">
        <c:import url="orders.jsp" >
            <c:param name="orders" value="${orders}" />
            <c:param name="clientToShow_orders" value="${clientToShow_orders}" />
            <c:param name="menu" value="${menu}" />
            <c:param name="dishesTypeList" value="${dishesTypeList}" />
        </c:import>
    </c:if>

</body>
</html>
