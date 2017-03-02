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
	<script type="text/javascript">
		
	</script>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="jumbotron">
		<h2>Gestión de Promociones</h2>
		<a href="#" role="button" class="btn btn-info" data-toggle="modal"
		data-target="#modalPromo">Añadir Promoción</a>
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
							<label for="promoSince">Válido desde</label> <input type="text"
								name="promoSince" class="form-control" />
						</div>
						<div class="form-group">
							<label for="promoTo">Válido hasta</label> <input type="text"
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
							<span>Rango de edad</span>
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
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	
	<div>${listaPromos}</div>
	<div class="promo-info">
		<table class="table table-hover table-responsive">
			<tr>
				<th>Título</th>
				<th>Validez</th>
				<th>Descripción</th>
				<th>Imagen</th>
				<th>Major</th>
				<th>Minor</th>
				<th>Id</th>
				<th>Sexo</th>
				<th>Edad</th>
			</tr>
			
			<c:forEach items="${listaPromos}" var="promo">
				<tr>
					<td>Titulo 1</td>
					<td>Validez 1</td>
					<td>Descripción 1</td>
					<td>Imagen 1</td>
					<td>Major 1</td>
					<td>Minor 1</td>
					<td>Id 1</td>
					<td>Sexo 1</td>
					<td>Edad 1</td>
				</tr>
			</c:forEach>
			
			
			
			
			
			<tr>
				<td>Titulo 1</td>
				<td>Validez 1</td>
				<td>Descripción 1</td>
				<td>Imagen 1</td>
				<td>Major 1</td>
				<td>Minor 1</td>
				<td>Id 1</td>
				<td>Sexo 1</td>
				<td>Edad 1</td>
			</tr>
			<tr>
				<td>Titulo 2</td>
				<td>Validez 2</td>
				<td>Descripción 2</td>
				<td>Imagen 2</td>
				<td>Major 2</td>
				<td>Minor 2</td>
				<td>Id 2</td>
				<td>Sexo 2</td>
				<td>Edad 2</td>
			</tr>
		</table>
	</div>

</body>
</html>