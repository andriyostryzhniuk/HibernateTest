<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Hibernate Test Menu</title>
</head>
<style type="text/css">
    th, td {
        border: 1px solid dimgray;
        padding-left: 3px;
        padding-right: 5px;
    }
</style>
<body>

    Menu: <br>
    <table>
        <tr>
            <th>Type</th>
            <th>Name</th>
            <th>Price</th>
            <th>Mass</th>
        </tr>
        <c:forEach var="dish" items="${menu}">
            <tr>
                <td>${dish.type.type}</td>
                <td>${dish.name}</td>
                <td>${dish.price}</td>
                <td>${dish.mass}</td>
            </tr>
        </c:forEach>

    </table>

    <%--<br><br>Create dish:<br>
    <form action="/addDish" th:object="${client}" method="post">
        Type: <select name="type">
        <c:forEach var="dishesType" items="${dishesTypeList}">
            <option value="${dishesType.id}" label="${dishesType.type}" />
        </c:forEach>
    </select>
        Name: <input type="text" name="name">
        Price: <input type="text" name="price">
        Mass: <input type="text" name="mass">
        <input type="submit" value="Create">
    </form>--%>


    <%--<br>Update dish:<br>
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


    <br>Delete dish:<br>
    <form action="/chooseClient" method="get">
        Input client's name: <input type="text" name="clientName" value="${clientToDeleting.name}">
        <input type="hidden" name="operation" value="Deleting">
        <input type="submit" value="Deleting">
    </form>
    <c:if test="${clientToDeleting != null}">
        <c:import url="deleteClient.jsp" >
            <c:param name="clientToDeleting" value="${clientToDeleting}" />
        </c:import>
    </c:if>--%>

</body>
</html>