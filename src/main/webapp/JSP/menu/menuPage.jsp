<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <div style="width: 100%;">
        <div style="float:left; width: 40%">

            <b>Menu:</b><br>
            <table>
                <tr>
                    <th>Type</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Mass</th>
                </tr>
                <c:forEach var="dish" items="${menuList}">
                    <tr>
                        <td>${dish.type.type}</td>
                        <td>${dish.name}</td>
                        <td>${dish.price}</td>
                        <td>${dish.mass}</td>
                    </tr>
                </c:forEach>

            </table>

        </div>


        <div style="float:left;">

            <br><br><b>Create dish:</b><br>
            <form action="/addDish" method="post">
                Type: <select name="dishesTypeId">
                    <option value="Choose type">Choose type</option>

                    <c:forEach var="dishesType" items="${dishesTypeList}">
                        <option value="${dishesType.id}"> ${dishesType.type} </option>
                    </c:forEach>
                </select>
                Name: <input type="text" name="name">
                Price: <input type="text" name="price" style="width: 100px;" >
                Mass: <input type="text" name="mass" style="width: 100px;" >
                <input type="submit" value="Create">
            </form>


            <br><b>Update dish:</b><br>
            <form action="/chooseDish" method="get">
                Input dish: <input type="text" name="dishesName" value="${dishToUpdating.name}">
                <input type="hidden" name="operation" value="Updating">
                <input type="submit" value="Updating">
            </form>
            <c:if test="${dishToUpdating != null}">
                <c:import url="updateMenu.jsp" >
                    <c:param name="dishToUpdating" value="${dishToUpdating}" />
                </c:import>
            </c:if>


            <br><b>Delete dish:</b><br>
            <form action="/chooseDish" method="get">
                Input dish: <input type="text" name="dishesName" value="${dishToDeleting.name}">
                <input type="hidden" name="operation" value="Deleting">
                <input type="submit" value="Deleting">
            </form>
            <c:if test="${dishToDeleting != null}">
                <c:import url="deleteMenu.jsp" >
                    <c:param name="dishToDeleting" value="${dishToDeleting}" />
                </c:import>
            </c:if>

        </div>
    </div>

</body>
</html>