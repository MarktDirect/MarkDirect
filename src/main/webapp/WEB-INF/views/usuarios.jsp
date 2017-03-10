<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="links.jsp"></jsp:include>
<title>Usuarios</title>
<script type="text/javascript" src="resources/script/usersform.js"></script>
</head>
<body>
	<form role="form" method="post" class="form-group">
	<div class="header-contain">
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="jumbotron">
			
				<h2>Gestión de Usuarios</h2>
				<button type=submit value="BloquearUsuario" role="button"
					class="btn btn-trigger" data-toggle="modal" formaction="usuario"
					data-target="#modalBlock">Bloquear Usuario</button> <label class="label label-danger">${mensajeblock}</label>
					<button type=submit value="DesbloquearUsuario" role="button" 
					class="btn btn-trigger" data-toggle="modal" formaction="usuarios"
					data-target="#modalBlock">Desbloquear Usuario</button> <label class="label label-danger">${mensajedesblock}</label>
		</div>
	</div>
	<div class="usuarios-info table-responsive">
		<table class="table table-responsive table-hover">
			<tr>
				<th>Email</th>
				<th>Genero</th>
				<th>Nacimiento</th>
				<th>Bloqueado</th>
				<th>Bloquear Usuarios</th>
				<th>Desbloquear usuarios</th>
			</tr>
			<c:forEach items="${usuario}" var="Usuario">
				<tr>
					<td>${Usuario.userEmail}</td>
					<td>${Usuario.userGen}</td>
					<td>${Usuario.userAge}</td>
					<td>${Usuario.userBlock}</td>
					<td><input type="checkbox" name="bloquear"
						value="${Usuario.userEmail}">Bloquear<br></td>
					<td><input type="checkbox" name="desbloquear"
						value="${Usuario.userEmail}">Desbloquar<br></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</form>
</body>
</html>