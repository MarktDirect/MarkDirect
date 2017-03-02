<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="links.jsp"></jsp:include>
<title>Login usuario</title>
</head>
<body>
<div class="section container row col-md-offset-3 col-md-6">

<h1>FORMULARIO DE LOGIN</h1>
	<form role="form" action="home" method="get"
	class="form-group input-group">
		<input type="text" name="usuario" placeholder="Introduce tu usuario" class="form-control"/>
		<input type="password" name="password"
			placeholder="Introduce tu contraseña" class="form-control"/> <input type="submit"
			value="registrate" class="btn btn-info"/>
		<p>${mensajeerror}</p>

</div>
	

	</form>

</body>
</html>