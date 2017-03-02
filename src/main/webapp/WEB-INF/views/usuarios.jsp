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
</head>
<body>
	<div class="header-contain">
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="jumbotron">
			<h2>Gestión de Usuarios</h2>
			<a href="#" role="button" class="btn btn-trigger" data-toggle="modal"
				data-target="#modalBlock">Bloquear Usuario</a>
		</div>
	</div>
		<!-- Falta el modal del bloqueo, pero como todavía no sabemos que hay que hacer 
		para bloquear lo dejamos de momento -->
		<div class="usuarios-info table-responsive">
			<table class="table table-responsive table-hover">
				<!-- el filtrar no está terminado, pero la idea sería que al buscar tag filtrará los
		pretendientes a través de este buscador -->
				<tr>
					<th>nombre</th>
					<th>genero</th>
					<th>email</th>
					<th>edad</th>
				</tr>
				<c:forEach items="${lista}" var="Usuario">
					<tr>
						<td>
							<!--${Usuario.usuario}-->
						</td>
						<td>
							<!--${Usuario.genero}-->
						</td>
						<td>
							<!--${Usuario.email}-->
						</td>
						<td>
							<!--${Usuario.edad}-->
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>