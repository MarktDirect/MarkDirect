<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<jsp:include page="links.jsp"></jsp:include>

<title>Alta Centro</title>
</head>
<body>
	<div class="header-contain">
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="jumbotron">
			<h2>Gestión de Centros</h2>
			<a href="#" role="button" class="btn btn-trigger" data-toggle="modal"
				data-target="#modalCentros">Añadir Centro</a>
		</div>
	</div>
	<!-- Modal -->
	<div id="modalCentros" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Añadir Centro</h4>
				</div>
				<form class="form" action="altaCentro" method="POST">
					<div class="modal-body">
						<div class="form-group">
							<label for="centerName">Nombre</label> <input type="text"
								name="centerName" class="form-control" />
						</div>
						<div class="form-group">
							<label for="centerAddres">Dirección</label> <input type="text"
								name="centerAddres" class="form-control" />
						</div>
						<div class="form-group">
							<label for="centerDescription">Descripción</label> <input
								type="text" name="centerDescription" class="form-control" />
						</div>
						<div class="form-group">
							<label for="centerType">Tipo</label> <input type="text"
								name="centerType" class="form-control" />
						</div>
						<div class="form-group">
							<label for="centerSubtype">Subtipo</label> <input type="text"
								name="centerSubtype" class="form-control" />
						</div>

						<div class="modal-footer">
							<input type="submit" class="btn btn-info" value="Dar de alta" />
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Tabla con las promos de la base de datos -->
	<div class="center-info table-responsive">
		<table class="table table-hover">
			<tr>
				<th>Nombre</th>
				<th>Dirección</th>
				<th>Descripción</th>
				<th>Tipo</th>
				<th>Sutipo</th>
				<th>Ver Centro</th>
			</tr>	
			<c:forEach items="${listaCentros}" var="center">
				<tr>
					<td>${center.centerName}</td>
					<td>${center.centerAddres}</td>
					<td>${center.centerDescription}</td>
					<td>${center.centerType}</td>
					<td>${center.centerSubtype}</td>	
					<td></td>				
				</tr>
			</c:forEach>
		</table>
	</div>	
</body>
</html>
