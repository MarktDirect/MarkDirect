<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión de Promociones</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<div class="header-contain">
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="jumbotron">
		<h2>Gestión de Promociones</h2>
		<a href="#" role="button" class="btn btn-trigger" data-toggle="modal"
		data-target="#modalPromo">Añadir Promoción</a>
	</div>
</div>
	<!-- Modal -->
	<div id="modalPromo" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Añadir Promoción</h4>
				</div>
				<form class="form" action="altaPromos" method="POST">
					<div class="modal-body">
						<div class="form-group">
							<label for="promoName">Título</label> <input type="text"
								name="promoName" class="form-control" />
						</div>
						<div class="form-group">
							<label for="promoDescription">Descripción</label> <input
								type="text" name="promoDescription" class="form-control" />
						</div>
						<div class="form-group">
							<label for="promoSince">Válido desde</label> <input type="date"
								name="promoSince" class="form-control" />
						</div>
						<div class="form-group">
							<label for="promoTo">Válido hasta</label> <input type="date"
								name="promoTo" class="form-control" />
						</div>
						<div class="form-group">
							<label for="promoImage"> URL Imagen</label> <input type="text"
								name="promoImage" class="form-control" />
						</div>
						<div class="form-group">
							<label for="promo_controlZoneId">Zona de Control</label> 
							<select name="promo_controlZoneId" class="form-control">
								<option value="0">Genérica</option>
								<option value="1">Zona 1</option>
								<option value="2">Zona 2</option>
								<option value="3">Zona 3</option>
							</select>
						</div>
						<div class="form-group">
							<span>Rango de edad</span><br/>
							<label for="promoMinAge">Edad mínima</label>
							<input type="text" name="promoMinAge" class="form-control" />
							<label for="promoMinAge">Edad máxima</label>
							<input type="text" name="promoMaxAge" class="form-control" />
						</div>
						<div class="form-group">
							<label for="promoGen">Género</label>
							<select name="promoGen" class="form-control">
								<option value="H">Hombre</option>
								<option value="M">Mujer</option>
								<option value="Todos">Todos</option>
							</select>
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
				<th>Título</th>
				<th>Descripción</th>
				<th>Válida desde</th>
				<th>Válida hasta</th>
				<th>Activa</th>
				<th>Creación</th>
				<th>Edad min</th>
				<th>Edad max</th>
				<th>Género</th>
				<th>Zona</th>
			</tr>
			<c:forEach items="${listaPromos}" var="promo">
				<tr>
					<td>${promo.promoName}</td>
					<td>${promo.promoDescription}</td>
					<td>${promo.promoSince}</td>
					<td>${promo.promoTo}</td>
					<td>${promo.promoState}</td>
					<td>${promo.promoCreate}</td>
					<td>${promo.promoMinAge}</td>
					<td>${promo.promoMaxAge}</td>
					<td>${promo.promoGen}</td>
					<td>${promo.promo_controlzoneId}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>