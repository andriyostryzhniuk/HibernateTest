<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="/resources/jquery-3.2.1.min.js"></script>
    <script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container">
        <h1>My First Bootstrap Page</h1>
        <p>This is some text.</p>
    </div>

    <div class="container-fluid">
        <h1>My First Bootstrap Page</h1>
        <p>This is some text.</p>
    </div>

    <div class="container-fluid">
        <p>Resize the browser window to see the effect.</p>
        <div class="row">
            <div class="col-xs-3" style="background-color:lavender;">.col-xs-3</div>
            <div class="col-sm-3" style="background-color:lavenderblush;">.col-sm-3</div>
            <div class="col-md-3" style="background-color:lavender;">.col-md-3</div>
            <div class="col-lg-3" style="background-color:lavenderblush;">.col-lg-3</div>
        </div>
    </div>

</body>
</html>
