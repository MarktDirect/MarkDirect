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
				data-target="#modalPromo">Añadir Promoción</a> <span
				class="label label-danger">${mensaje}</span>
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
								<%--Mejora: Rellenar dinámicamente--%>
								<option value="1">Accesorios TV</option>
								<option value="2">Cuidado Personal</option>
								<option value="3">Cuidado del Hogar</option>
								<option value="4">Radio</option>
								<option value="5">Lavadora</option>
								<option value="6">Frigorífico</option>
								<option value="7">Auriculares</option>
								<option value="8">Cámara de Video</option>
								<option value="9">Cámara Fotografica</option>
								<option value="10">Hifi Pro</option>
								<option value="11">Microondas</option>
								<option value="12">Proyector</option>
								<option value="13">Televisor</option>
								<option value="14">Reproductor</option>
								<option value="15">Tablet</option>
								<option value="16">Tarjeta Memoria</option>
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
						data-content="${promo.promoDescription}" id="promoName">${promo.promoName}</a></td>
					<%-- Necesitamos tener la descripción (oculta- ya que está en el popover) para poder cogerla en el formulario --%>
					<td hidden="hidden" id="promoDescription">${promo.promoDescription}</td>
					<td hidden="hidden" id="promo_catNivel2">${promo.promo_catNivel2}</td>
					<td id="promo_catNivel1">${promo.promo_catNivel1}</td>
					<td id="promo_idProduct">${promo.promo_idProduct}</td>
					<td hidden="hidden" id="promoSince">${promo.promoSince}</td>
					<td hidden="hidden" id="promoTo">${promo.promoTo}</td>
					<td align="center"><c:choose>
							<c:when test="${promo.promoState == 1}">
								<i class="fa fa-check-circle-o fa-lg" aria-hidden="true"></i>
							</c:when>
							<c:otherwise>
								<i class="fa fa-times fa-lg" aria-hidden="true"></i>
							</c:otherwise>
						</c:choose></td>
						<td hidden="hidden" id="promoImage">${promo.promoImage}</td>
					<td><span id="promoMinAge">${promo.promoMinAge}</span>-<span id="promoMaxAge">${promo.promoMaxAge}</span></td>
					<td id="promoGen">${promo.promoGen}</td>
					<td id="promo_controlzoneId">${promo.promo_controlzoneId}</td>
					<%--Arreglar que solo salen los valores de la primera promoción que hay en la lista, no la que le toca --%>
					<td><button type="button" data-id="${promo.promoId}" class="btn btn-default editButton" onclick="showEditModal(this);">Editar</button></td>
				</tr>
			</c:forEach>
		</table>
		
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
													name="promoName" id="edit-promoName" class="form-control"
													required="required" />
											</div>
											<div class="form-group">
												<label for="promoDescription">Descripción</label> <input
													type="text" name="promoDescription" id="edit-promoDescription"
													class="form-control" required="required" />
											</div>
											<div class="form-group">
												<label for="promo_catNivel2">Categoría de nivel 2</label> <select
													name="promo_catNivel2" class="form-control"
													required="required" id="edit-promo_catNivel2">
													<%-- Rellenar dinámicamente--%>
													<option value="1">Electrónica de consumo</option>
													<option value="2">Pequeño Electrodoméstico</option>
													<option value="3">Grandes Electrodomésticos</option>
												</select>
											</div>
											<div class="form-group">
												<label for="promo_catNivel1">Categoría de nivel 1</label> <select
													name="promo_catNivel1" class="form-control"
													required="required" id="edit-promo_catNivel1">
													<%--Mejora: Rellenar dinámicamente--%>
													<option value="1">Accesorios TV</option>
													<option value="2">Cuidado Personal</option>
													<option value="3">Cuidado del Hogar</option>
													<option value="4">Radio</option>
													<option value="5">Lavadora</option>
													<option value="6">Frigorífico</option>
													<option value="7">Auriculares</option>
													<option value="8">Cámara de Video</option>
													<option value="9">Cámara Fotografica</option>
													<option value="10">Hifi Pro</option>
													<option value="11">Microondas</option>
													<option value="12">Proyector</option>
													<option value="13">Televisor</option>
													<option value="14">Reproductor</option>
													<option value="15">Tablet</option>
													<option value="16">Tarjeta Memoria</option>
												</select>
											</div>
											<div class="form-group">
												<label for="promo_idProduct">ID Producto</label> <input
													type="date" name="promo_idProduct"
													class="form-control" required="required" id="edit-promo_idProduct"/>
											</div>
											<div class="form-group">
												<label for="promoSince">Válido desde</label> <input
													type="date" name="promoSince" id="edit-promoSince"
													class="form-control" required="required"/>
											</div>
											<div class="form-group">
												<label for="promoTo">Válido hasta</label> <input type="date"
													name="promoTo" id="edit-promoTo" class="form-control"
													required="required" />
											</div>
											<div class="form-group">
												<label for="promoImage"> URL Imagen</label> <input
													type="text" name="promoImage" id="edit-promoImage"
													class="form-control" required="required" />
											</div>
											<div class="form-group">
												<label for="promo_controlzoneId">Zona de Control</label> <select
													name="promo_controlzoneId" class="form-control"
													required="required" id="edit-promo_controlzoneId">
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
													class="form-control" required="required" id="edit-promoMinAge" />
												<label for="promoMaxAge">Edad máxima</label> <input
													type="text" name="promoMaxAge" class="form-control"
													required="required" id="edit-promoMaxAge" />
											</div>
											<div class="form-group">
												<label for="promoGen">Género</label> <select name="promoGen"
													class="form-control" required="required" id="edit-promoGen">
													<option value="H">Hombre</option>
													<option value="M">Mujer</option>
													<option value="Todos">Todos</option>
												</select>
											</div>
										</div>
										<div class="modal-footer">
											<input type="submit" class="btn btn-info" value="Editar" />
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Cerrar</button>
										</div>
									</form>
								</div>
							</div>
						</div>
	</div>
	<!-- TODO pasarlo a un documento js propio -->
	<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
		
		function showEditModal(promo) {
			//Recogemos el modal
			var modalEdit = $("#modalEdit");
			//Recogemos todos los parámetros de la promoción
			var promoName= $(promo).closest("tr").find("#promoName").html();
			var promoDescription = $(promo).closest("tr").find("#promoDescription").html();
			var promo_catNivel2 = $(promo).closest("tr").find("#promo_catNivel2").html();
			var promo_catNivel1 = $(promo).closest("tr").find("#promo_catNivel1").html();
			var promo_idProduct = $(promo).closest("tr").find("#promo_idProduct").html();
			var promoSince = $(promo).closest("tr").find("#promoSince").html();
			var promoTo = $(promo).closest("tr").find("#promoTo").html();
			var promoImage = $(promo).closest("tr").find("#promoImage").html();
			var promoMinAge = $(promo).closest("tr").find("#promoMinAge").html();
			var promoMaxAge = $(promo).closest("tr").find("#promoMaxAge").html();
			var promoGen = $(promo).closest("tr").find("#promoGen").html();
			var promo_controlzoneId = $(promo).closest("tr").find("#promo_controlzoneId").html();
			
			//Los volcamos en el formulario que se encuentra en el modal
			$("#edit-promoName").val(promoName);
			$("#edit-promoDescription").val(promoDescription);
			$("#edit-promo_catNivel2").val(promo_catNivel2);
			$("#edit-promo_catNivel1").val(promo_catNivel1);
			$("#edit-promo_idProduct").val(promo_idProduct);
			$("#edit-promoSince").val(promoSince);
			$("#edit-promoTo").val(promoTo);
			$("#edit-promoImage").val(promoImage);
			$("#edit-promoMinAge").val(promoMinAge);
			$("#edit-promoMaxAge").val(promoMaxAge);
			$("#edit-promoGen").val(promoGen);
			$("#edit-promo_controlzoneId").val(promo_controlzoneId);
			
			//mostramos el modal
			modalEdit.modal("show");
		}
	</script>
</body>