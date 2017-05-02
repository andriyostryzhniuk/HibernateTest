<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>

    <form action="/register" method="post" >
        <div style="margin-bottom:  10px">
            <input type="text" name="username" placeholder="Enter Username" required>
        </div>

        <div style="margin-bottom:  10px">
            <input type="password" name="password" placeholder="Enter Password" required>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <input type="submit" value="Register">
    </form>

</body>
</html>
