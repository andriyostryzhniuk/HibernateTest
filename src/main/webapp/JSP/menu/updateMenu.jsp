<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="menu" scope="session" value="${dishToUpdating}" />

<form action="/updateMenu" method="post">
    Type: <select name="dishesTypeId">

    <c:forEach var="dishesType" items="${dishesTypeList}">

        <c:choose>
            <c:when test="${dishesType.id == dishToUpdating.type.id}">
                <option value="${dishesType.id}" selected> ${dishesType.type} </option>
            </c:when>
            <c:when test="${dishesType.id != dishToUpdating.type.id}">
                <option value="${dishesType.id}" > ${dishesType.type} </option>
            </c:when>
        </c:choose>

    </c:forEach>

    </select>
    Name: <input type="text" name="name" value="${dishToUpdating.name}">
    Price: <input type="text" name="price" value="${dishToUpdating.price}">
    Mass: <input type="text" name="mass" value="${dishToUpdating.mass}">
    <input type="submit" value="Update">
</form>