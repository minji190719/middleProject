<%@ tag language="java" pageEncoding="UTF-8" description="Main Wrapper Tag" %>

<html lang="kor">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script
            src="https://kit.fontawesome.com/c08363d7dd.js"
            crossorigin="anonymous"
        ></script>
        <script src="<%= request.getContextPath() %>/js/jquery-3.6.1.min.js"></script>
		
    </head>
    <body>
        <jsp:doBody></jsp:doBody>
    </body>
</html>