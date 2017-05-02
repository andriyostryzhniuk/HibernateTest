<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login page</title>
</head>
<body>

    <form action="/login" method="post">

        <c:if test="${param.error != null}">
                <p>Invalid username or password.</p>
        </c:if>

        <c:if test="${param.logout != null}">
                <p>You have been logged out successfully.</p>
        </c:if>

        <div style="margin-bottom:  10px">
            <input type="text" name="username" placeholder="Enter Username" required>
        </div>

        <div style="margin-bottom:  10px">
            <input type="password" name="password" placeholder="Enter Password" required>
        </div>
        <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />

        <input type="submit" value="Log in">

    </form>

</body>
</html>
