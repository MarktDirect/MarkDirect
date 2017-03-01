<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login usuario</title>
</head>
<body>

	<h1>FORMULARIO DE LOGIN</h1>
	<form role="form" action="validar" method="get">
		<input type="text" name="usuario" placeholder="Introduce tu usuario" />
		<input type="password" name="password"
			placeholder="Introduce tu contraseña" /> <input type="submit"
			value="registrate" />
		<p>${mensajeerror}</p>


	</form>

</body>
</html>