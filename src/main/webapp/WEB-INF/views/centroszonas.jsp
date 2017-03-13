<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="links.jsp"></jsp:include>
<title>Mi centro</title>
</head>
<body>
	<div class="header-contain">
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="home-header">
		<div align="center">
			<h2>Mi centro</h2>
			<hr style="backgound-color: #f9e553;"/>
		</div>
	</div>
	</div>
	<div class="home-wrapper row col-md-12">
		<div class="col-md-6 info-centros">
			<h3>Información</h3>
			<table class="table table-responsive">
				<tr>
					<th>Nombre</th>
					<td>${listaCentros[0].centerName}</td>
				</tr>
				<tr>
					<th>Descripción</th>
					<td>${listaCentros[0].centerDescription}</td>
				</tr>
				<tr>
					<th>Teléfono</th>
					<td>952 309 600</td>
				</tr>
				<tr>
					<th>Email</th>
					<td>info@juanlucas.com</td>
				</tr>
			</table>
			<div class="col-md-2"></div>
			<iframe class="map" width="350" height="250" style="border: 0"
				src="https://www.google.com/maps/embed/v1/place?q=Calle%20Armengual%20de%20la%20Mota%2039%2029007%20M%C3%A1laga&key=AIzaSyDAPKFlWgnKm43BqSfLrgeYK_IDcEsVMyE"></iframe>
		</div>
		<div class="col-md-6 info-zonas">
			<h3>Zonas de control <a href="#" data-toggle="modal"
				data-target="#modalZonas"><span class="badge" style="background-color: green; width: 50px; height: 25px;"><i class="fa fa-plus fa-lg" aria-hidden="true" style="margin-top: 4px;"></i></span></a></h3>
			<h4 style=" font-size: 12px;">${mensaje}</h4>
			<table class="table table-responsive">
				<tr>
					<th>Situación</th>
					<th>Major</th>
					<th>Minor</th>
					<th>Editar</th>
				</tr>
				<c:forEach items="${listaZonas}" var="zona" begin="1">
					<tr>
					<td hidden="hidden" id="controlzoneId">${zona.controlzoneId}</td>
					<td id="controlzoneEmplacement">${zona.controlzoneEmplacement}</td>
					<td id="controlzoneMajor">${zona.controlzoneMajor}</td>
					<td id="controlzoneMinor">${zona.controlzoneMinor}</td>
					<td><a role="button" data-id="${zona.controlzoneId}"
							onclick="showEditModal(this);"><i class="fa fa-pencil-square-o fa-lg" style="color: black" aria-hidden="true"></i></a>
							&nbsp;<i class="fa fa-trash-o fa-lg" aria-hidden="true"></i></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
		<!-- Modal Añadir-->
	<div id="modalZonas" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Añadir Zona</h4>
				</div>
				<form class="form" action="zonas" method="POST">
					<div class="modal-body">
						<div class="form-group">
							<label for="controlzoneMajor">Major</label> <input type="text"
								name="controlzoneMajor" class="form-control" required="required"/>
						</div>
						<div class="form-group">
							<label for="controlzoneMinor">Minor</label> <input
								type="text" name="controlzoneMinor" class="form-control" required="required"/>
						</div>
						<div class="form-group">
							<label for="controlzoneEmplacement">Situación</label> <input type="text"
								name="controlzoneEmplacement" class="form-control" required="required"/>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-success" value="Dar de alta" />
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
			<!-- Modal  Editar-->
	<div id="modalEdit" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Editar Zona</h4>
				</div>
				<form class="form" action="#" method="POST">
					<div class="modal-body">
						<div class="form-group">
							<label for="edit-controlzoneMajor">Major</label> <input type="text"
								name="controlzoneMajor" class="form-control" id="edit-controlzoneMajor" required="required"/>
						</div>
						<div class="form-group">
							<label for="edit-controlzoneMinor">Minor</label> <input
								type="text" name="controlzoneMinor" id="edit-controlzoneMinor" class="form-control" required="required"/>
						</div>
						<div class="form-group">
							<label for="edit-controlzoneEmplacement">Situación</label> <input type="text"
								name="controlzoneEmplacement" class="form-control" id="edit-controlzoneEmplacement" required="required"/>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-success" value="Editar" />
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
	function showEditModal(promo) {
		//Recogemos el modal
		var modalEdit = $("#modalEdit");
		//Recogemos todos los parámetros de la promoción
		var controlzoneId= $(promo).closest("tr").find("#controlzoneId").html();
		var controlzoneEmplacement= $(promo).closest("tr").find("#controlzoneEmplacement").html();
		var controlzoneMajor = $(promo).closest("tr").find("#controlzoneMajor").html();
		var controlzoneMinor = $(promo).closest("tr").find("#controlzoneMinor").html();
		
		//Los volcamos en el formulario que se encuentra en el modal
		$("#edit-controlzoneEmplacement").val(controlzoneEmplacement);
		$("#edit-controlzoneMajor").val(controlzoneMajor);
		$("#edit-controlzoneMinor").val(controlzoneMinor);
		
		//mostramos el modal
		modalEdit.modal("show");		
	}
	</script>
</body>
</html>