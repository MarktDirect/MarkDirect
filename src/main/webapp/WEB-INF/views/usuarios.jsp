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
		<div class="home-header">
		<div align="center">
			<h2>Gestión de usuarios</h2>
			<p><button type=submit value="BloquearUsuario" role="button"
					class="btn btn-trigger" data-toggle="modal" formaction="usuario"
					data-target="#modalBlock">Bloquear seleccionados</button>
					<button type=submit value="DesbloquearUsuario" role="button" 
					class="btn btn-trigger" data-toggle="modal" formaction="usuarios"
					data-target="#modalBlock">Desbloquear seleccionados</button></p>
					<label class="label label-info">${mensajeblock}</label>
					<label class="label label-info">${mensajedesblock}</label>
			<hr style="backgound-color: #f9e553;"/>
		</div>
	</div>
	</div>
	
	<div class="usuarios-info">
		<table class="table table-responsive table-bordered table-users">
			<tr class="table-users-header">
				<th>Email</th>
				<th>Genero</th>
				<th>Nacimiento</th>
				<th>Bloqueado</th>
				<th>Bloquear</th>
				<th>Desbloquear</th>
			</tr>
			<c:forEach items="${usuario}" var="Usuario">
				<tr>
					<td>${Usuario.userEmail}</td>
					<td>${Usuario.userGen}</td>
					<td>${Usuario.userAge}</td>
					<td>
					<c:choose>
							<c:when test="${Usuario.userBlock == 1}">
								<i class="fa fa-lock fa-lg" aria-hidden="true"></i>
							</c:when>
							<c:otherwise>
								<i class="fa fa-unlock fa-lg" aria-hidden="true"></i>
							</c:otherwise>
						</c:choose>					
					</td>
					<td><input type="checkbox" name="bloquear"
						value="${Usuario.userEmail}"><br></td>
					<td><input type="checkbox" name="desbloquear"
						value="${Usuario.userEmail}"><br></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</form>
		<footer>
	</footer>
</body>
</html>