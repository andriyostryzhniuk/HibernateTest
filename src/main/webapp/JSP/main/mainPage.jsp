<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hibernate Test</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="/resources/jquery-3.2.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

    <form>
        <button formaction="/menuPage" > Menu </button>
        <button formaction="/ordersPage" > Orders </button>

        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <button formaction="/logout" > Logout </button>
                <%--<sec:authorize access="hasAuthority('ADMIN')">--%>
                <sec:authorize url="/admin">
                    <button formaction="/admin" > Admin </button>
                </sec:authorize>
            </c:when>
            <c:otherwise>
                <button formaction="/login" > Sign In </button>
                <button formaction="/registrationPage" > Registration </button>
            </c:otherwise>
        </c:choose>

        <button formaction="/bootsrapPage" > Bootsrap Page </button>
    </form>

    Welcome: <c:out value="${pageContext.request.userPrincipal.name}" default="guest" />

    <br><b>Clients:</b><br>
    <div class="table-responsive">
        <table class="table table-hover table-bordered">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Telephone Number</th>
                    <th>Contact person</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="client" items="${clientList}">
                    <tr>
                        <td>${client.name}</td>
                        <td>${client.address}</td>
                        <td>${client.telephoneNumber}</td>
                        <td>${client.contactPerson}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


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
