<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="client" scope="session" value="${clientToUpdating}" />

<form action="/updateClient" method="post" >
    Name: <input type="text" name="name" value="${clientToUpdating.name}">
    Address: <input type="text" name="address" value="${clientToUpdating.address}">
    Telephone number: <input type="text" name="telephoneNumber" value="${clientToUpdating.telephoneNumber}">
    Contact person: <input type="text" name="contactPerson" value="${clientToUpdating.contactPerson}">
    <input type="submit" value="Update">
</form>