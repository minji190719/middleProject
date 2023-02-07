<%@ tag language="java" pageEncoding="UTF-8" description="Main Wrapper Tag" %>

<html lang="kor">
	<head>
		<meta charset="UTF-8" />
		<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge" /> -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.15.10/dist/css/uikit.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
        <script src="https://cdn.jsdelivr.net/npm/uikit@3.15.10/dist/js/uikit.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/uikit@3.15.10/dist/js/uikit-icons.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script
            src="https://kit.fontawesome.com/c08363d7dd.js"
            crossorigin="anonymous"
        ></script>
        <script src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
	</head>
	<body>
        <jsp:doBody></jsp:doBody>
        <%--
        <script src="${pageContext.request.contextPath}/js/header.js"></script>
        --%>
	</body>
</html>