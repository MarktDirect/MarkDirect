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
<body data-ng-app="promosModule" data-ng-controller="promosController as vm">
	<div class="header-contain">
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="jumbotron">
			<h2>Gestión de Promociones</h2>
			<a href="#" role="button" class="btn btn-trigger" data-toggle="modal"
				data-target="#modalPromo">Añadir Promoción</a> <span class="label label-danger">${mensaje}</span>
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
				<form class="form" action="promos" method="POST">
					<div class="modal-body">
						<div class="form-group">
							<label for="promoName">Título</label> <input type="text"
								name="promoName" class="form-control" required="required" />
						</div>
						<div class="form-group">
							<label for="promoDescription">Descripción</label> <input
								type="text" name="promoDescription" class="form-control"
								required="required" />
						</div>
						<div class="form-group">
							<label for="promo_catNivel2">Categoría de nivel 2</label> <select
								name="promo_catNivel2" class="form-control" required="required">
								<%-- Rellenar dinámicamente--%>
								<option value="1">Electrónica de consumo</option>
								<option value="2">Pequeño Electrodoméstico</option>
								<option value="3">Grandes Electrodomésticos</option>
							</select>
						</div>
						<div class="form-group">
							<label for="promo_catNivel1">Categoría de nivel 1</label> <select
								name="promo_catNivel1" class="form-control" required="required">
								<%-- Rellenar dinámicamente--%>
								<option value="1">Categoría 1</option>
								<option value="1">Categoría 2</option>
								<option value="1">Categoría 3</option>
							</select>
						</div>
						<div class="form-group">
												<label for="promo_idProduct">ID Producto</label> <input
													type="text" name="promo_idProduct" id="promoSince"
													class="form-control" required="required" />
											</div>
						<div class="form-group">
							<label for="promoSince">Válido desde</label> <input type="date"
								name="promoSince" class="form-control" required="required" />
						</div>
						<div class="form-group">
							<label for="promoTo">Válido hasta</label> <input type="date"
								name="promoTo" class="form-control" required="required" />
						</div>
						<div class="form-group">
							<label for="promoImage"> URL Imagen</label> <input type="text"
								name="promoImage" class="form-control" required="required" />
						</div>
						<div class="form-group">
							<label for="promo_controlZoneId">Zona de Control</label> <select
								name="promo_controlZoneId" class="form-control"
								required="required">
								<option value="0">Promoción Genérica</option>
								<option value="1">Zona 1</option>
								<option value="2">Zona 2</option>
								<option value="3">Zona 3</option>
							</select>
						</div>
						<div class="form-group">
							<span>Rango de edad</span><br /> <label for="promoMinAge">Edad
								mínima</label> <input type="text" name="promoMinAge"
								class="form-control" required="required" /> <label
								for="promoMaxAge">Edad máxima</label> <input type="text"
								name="promoMaxAge" class="form-control" required="required" />
						</div>
						<div class="form-group">
							<label for="promoGen">Género</label> <select name="promoGen"
								class="form-control" required="required">
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
			<tr align="center">
				<th>Título</th>
				<th>Categoría</th>
				<th>Producto</th>
				<th>Activa</th>
				<th>Edad</th>
				<th>Género</th>
				<th>Zona</th>
				<th>Editar</th>
			</tr>
			<c:forEach items="${listaPromos}" var="promo">
				<tr>
					<td><a href="#" class="popover-promo" title="Descripción"
						data-toggle="popover" data-trigger="hover" data-placement="bottom"
						data-content="${promo.promoDescription}">${promo.promoName}</a></td>
					<%-- Necesitamos tener la descripción (oculta- ya que está en el popover) para poder cogerla en el formulario --%>
					<td hidden="hidden">${promo.promoDescription}</td>
					<td hidden="hidden">${promo.promo_catNivel2}</td>
					<td>${promo.promo_catNivel1}</td>
					<td>${promo.promo_idProduct}</td>
					<td hidden="hidden">${promo.promoSince}</td>
					<td hidden="hidden">${promo.promoTo}</td>
					<td align="center"><c:choose>
							<c:when test="${promo.promoState == 1}">
								<i class="fa fa-check-circle-o fa-lg" aria-hidden="true"></i>
							</c:when>
							<c:otherwise>
								<i class="fa fa-times fa-lg" aria-hidden="true"></i>
							</c:otherwise>
						</c:choose></td>
					<td>${promo.promoMinAge}-${promo.promoMaxAge}</td>
					<td>${promo.promoGen}</td>
					<td>${promo.promo_controlzoneId}</td>
					<%--Arreglar que solo salen los valores de la primera promoción que hay en la lista, no la que le toca --%>
					<td id="btn-triggerModal"><a href="#" role="button"
						class="btn btn-default" data-toggle="modal"
						data-target="#modalEdit">Editar</a></td>
					<td id="td-modalEdit">
						<!-- Modal de edición de promociones-->
						<div id="modalEdit" class="modal fade" role="dialog">
							<div class="modal-dialog">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Editar promoción</h4>
									</div>
									<form class="form" action="altaPromos" method="POST">
										<div class="modal-body">
											<div class="form-group">
												<label for="promoName">Título</label> <input type="text"
													name="promoName" id="promoName" class="form-control"
													required="required" />
											</div>
											<div class="form-group">
												<label for="promoDescription">Descripción</label> <input
													type="text" name="promoDescription" id="promoDescription"
													class="form-control" required="required" />
											</div>
											<div class="form-group">
												<label for="promo_catNivel2">Categoría de nivel 2</label> <select
													name="promo_catNivel2" class="form-control"
													required="required">
													<%-- Rellenar dinámicamente--%>
													<option value="1">Electrónica de consumo</option>
													<option value="2">Pequeño Electrodoméstico</option>
													<option value="3">Grandes Electrodomésticos</option>
												</select>
											</div>
											<div class="form-group">
												<label for="promo_catNivel1">Categoría de nivel 1</label> <select
													name="promo_catNivel1" class="form-control"
													required="required">
													<%-- Rellenar dinámicamente--%>
													<option value="1">Categoría 1</option>
													<option value="1">Categoría 2</option>
													<option value="1">Categoría 3</option>
												</select>
											</div>
											<div class="form-group">
												<label for="promo_idProduct">ID Producto</label> <input
													type="date" name="promo_idProduct" id="promoSince"
													class="form-control" required="required" />
											</div>
											<div class="form-group">
												<label for="promoSince">Válido desde</label> <input
													type="date" name="promoSince" id="promoSince"
													class="form-control" required="required" />
											</div>
											<div class="form-group">
												<label for="promoTo">Válido hasta</label> <input type="date"
													name="promoTo" id="promoTo" class="form-control"
													required="required" />
											</div>
											<div class="form-group">
												<label for="promoImage"> URL Imagen</label> <input
													type="text" name="promoImage" id="promoImage"
													class="form-control" required="required" />
											</div>
											<div class="form-group">
												<label for="promo_controlZoneId">Zona de Control</label> <select
													name="promo_controlZoneId" class="form-control"
													required="required" id="promo_controlZoneId"">
													<%--Utilizamos un if para que aparezca marcada la opción real de la promoción --%>
													<option value="0">Genérica</option>
													<option value="1">Zona 1</option>
													<option value="2">Zona 2</option>
													<option value="3">Zona 3</option>
												</select>
											</div>
											<div class="form-group">
												<span>Rango de edad</span> <br /> <label for="promoMinAge">Edad
													mínima</label> <input type="text" name="promoMinAge"
													class="form-control" required="required" id="promoMinAge" />
												<label for="promoMaxAge">Edad máxima</label> <input
													type="text" name="promoMaxAge" class="form-control"
													required="required" id="promoMaxAge" />
											</div>
											<div class="form-group">
												<label for="promoGen">Género</label> <select name="promoGen"
													class="form-control" required="required" id="promoGen">
													<option value="H">Hombre</option>
													<option value="M">Mujer</option>
													<option value="Todos">Todos</option>
												</select>
											</div>
										</div>
										<div class="modal-footer">
											<input type="submit" class="btn btn-info" value="Dar de alta" />
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Cerrar</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</td>
				</tr>

			</c:forEach>
		</table>
	</div>
	<!-- TODO pasarlo a un documento js propio -->
	<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});

		$('td').on(
				'click',
				function() {
					$("#promoName").val(
							$(this).closest('tr').children()[0].textContent);
					$("#promoDescription").val(
							$(this).closest('tr').children()[1].textContent);
					$('#promo_catNivel2').val(
							$(this).closest('tr').children()[2].textContent);
					$('#promo_catNivel1').val(
							$(this).closest('tr').children()[3].textContent);
					$('#promo_idProduct').val(
							$(this).closest('tr').children()[4].textContent);
					$("#promoSince").val(
							$(this).closest('tr').children()[5].textContent);
					$("#promoTo").val(
							$(this).closest('tr').children()[6].textContent);

				});
	</script>
</body>