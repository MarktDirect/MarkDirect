<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>MarkDirect - Activa Juan Lucas</title>
	<jsp:include page="links.jsp"></jsp:include>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<header>
	<h1> MarkDirect - Activa Juan Lucas </h1>
</header>
	<jsp:include page="navbar.jsp"></jsp:include>
	<a href="promos" role="button" class="btn btn-info">Ver promociones</a>
</body>
</html>
