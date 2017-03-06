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
		<form role="form" action="usuarios" method="post" class="form-group">
			<h2>Gestión de Usuarios</h2>
			<input type=submit value="Bloquear Usuario" role="button" class="btn btn-trigger" data-toggle="modal"
				data-target="#modalBlock"/> <label class="label label-danger">${mensaje}</label>
		</div>
	</div>
		<div class="usuarios-info table-responsive">
			<table class="table table-responsive table-hover">
				<tr>
					<th>email</th>
					<th>genero</th>
					<th>nacimiento</th>
					<th>bloqueado</th>
				</tr>
				<c:forEach items="${usuario}" var="Usuario">
					<tr>
						<td>
							${Usuario.userEmail}
						</td>
						<td>
							${Usuario.userGen}
						</td>
						<td>
							${Usuario.userBorn}
						</td>
						<td>
						    <input type="checkbox" name="bloquear" value="${Usuario.userEmail}">Bloquear<br>
						</td>
					</tr>
				</c:forEach>
			</table>
			</form>
		</div>
</body>
</html>