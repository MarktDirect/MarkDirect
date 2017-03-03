<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Gestión de Zonas de Control</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<div class="header-contain">
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="jumbotron">
			<h2>Gestión de Zonas de Control</h2>
			<a href="#" role="button" class="btn btn-trigger" data-toggle="modal"
				data-target="#modalZonas">Añadir Zona</a>
		</div>
	</div>
	<!-- Modal -->
	<div id="modalZonas" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Añadir Zona</h4>
				</div>
				<form class="form" action="altaZonas" method="POST">
					<div class="modal-body">
						<div class="form-group">
							<label for="controlzoneMajor">Major</label> <input type="text"
								name="controlzoneMajor" class="form-control" />
						</div>
						<div class="form-group">
							<label for="controlzoneMinor">Minor</label> <input
								type="text" name="controlzoneMinor" class="form-control" />
						</div>
						<div class="form-group">
							<label for="controlzoneEmplacement">Situación</label> <input type="text"
								name="controlzoneEmplacement" class="form-control" />
						</div>
						<div class="form-group">
							<label for="controlzone_centerId">Centro</label> <input type="text"
								name="controlzone_centerId" class="form-control" />
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-info" value="Dar de alta" />
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Tabla con las promos de la base de datos -->
	<div class="promo-info table-responsive">
		<table class="table table-hover">
			<tr>
				<th>Id</th>
				<th>Major</th>
				<th>Minor</th>
				<th>Situación</th>
				<th>Centro</th>
			</tr>
			<c:forEach items="${listaZonas}" var="zona">
				<tr>
					<td>${zona.controlzoneId}</td>
					<td>${zona.controlzoneMajor}</td>
					<td>${zona.controlzoneMinor}</td>
					<td>${zona.controlzoneEmplacement}</td>
					<td>${zona.centers_centerId}</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>