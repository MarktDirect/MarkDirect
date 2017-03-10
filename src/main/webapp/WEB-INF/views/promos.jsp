<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión de Promociones</title>
<jsp:include page="links.jsp"></jsp:include>
<script type="text/javascript"
	src="resources/script/promosvalidation.js"></script>
<script type="text/javascript" src="resources/script/promosform.js"></script>
</head>
<body data-ng-app="promoModulo"
	data-ng-controller="promoControlador as vm">
	<div class="header-contain">
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="jumbotron">
			<h2>Gestión de Promociones</h2>
			<a href="#" role="button" class="btn btn-trigger" data-toggle="modal"
				data-target="#modalPromo" data-ng-click="vm.cargarDatos()">
				Añadir Promoción</a> <span class="label label-danger">${mensaje}</span>
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
								name="promo_catNivel2" class="form-control" required="required"
								id="level2" data-ng-model="cat2">

								<%-- Rellenar dinámicamente--%>
								<option data-ng-repeat="x in vm.listaCategorias2"
									value="{{x.id}}">{{x.category}}</option>
							</select>

						</div>

						<!-- <div class="col-md-6"> -->
						<div class="form-group">
							<label for="promo_catNivel1">Categoría de nivel 1</label>

							<%-- Rellenar dinámicamente--%>
							<select name="promo_catNivel1" class="form-control"
								required="required" id="level1" data-ng-model="cat1">
								
								<option data-ng-repeat="x in vm.listaCategorias1 | filtrocat2:cat2" value="{{x.id}}">{{x.category}}</option>
								<!--  COGITATUS CON LOS ESPACIOS SOBRE LOS : DEL FILTRO, QUE NO FUNCIONA!!!!!! -->

							</select>
						</div>

						<div class="form-group">

							<label for="promo_idProduct">ID Producto</label>
							<!-- <input type="text" name="promo_idProduct" id="promoSince"
													class="form-control" required="required" /> -->
							<select name="promo_idProduct" class="form-control" id="producto"
								required="required">
								<%-- Rellenar dinámicamente--%>
								<option data-ng-repeat="x in vm.listaProductos | filtrocat1:cat1" value="{{x.id}}">{{x.id}} {{x.name}}</option>
								
							</select>
						</div>


						<div class="form-group row">
							<div class="col-md-6">

								<label for="promoSince">Válido desde</label> <input type="date"
									name="promoSince" class="form-control" required="required"
									id="minordate" />
							</div>
							<div class="col-md-6">
								<label for="promoTo">Válido hasta</label> <input type="date"
									name="promoTo" class="form-control" required="required"
									id="majordate" />
							</div>
						</div>

						<div class="form-group">
							<label for="promoImage"> URL Imagen</label> <input type="text"
								name="promoImage" class="form-control" required="required" />
						</div>
						<div class="form-group row">
							<div class="col-md-6">
								<label for="promo_controlZoneId">Zona de Control</label> <select
									name="promo_controlZoneId" class="form-control"
									required="required">
									<option value="0">Promoción Genérica</option>
									<option value="1">Zona 1</option>
									<option value="2">Zona 2</option>
									<option value="3">Zona 3</option>
								</select>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="promoGen">Género</label> <select name="promoGen"
										class="form-control" required="required">
										<option value="H">Hombre</option>
										<option value="M">Mujer</option>
										<option value="Todos">Todos</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-6">
								<label for="promoMinAge">Edad mínima</label> <input type="text"
									name="promoMinAge" class="form-control" required="required"
									id="minorage" />
							</div>
							<div class="col-md-6">
								<label for="promoMaxAge">Edad máxima</label> <input type="text"
									name="promoMaxAge" class="form-control" required="required"
									id="majorage" />
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-info" value="Dar de alta"
							id="okbutton" />
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
					<td hidden="hidden" id="promoId">${promo.promoId}</td>
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
					<td><span id="promoMinAge">${promo.promoMinAge}</span>-<span
						id="promoMaxAge">${promo.promoMaxAge}</span></td>
					<td id="promoGen">${promo.promoGen}</td>
					<td id="promo_controlzoneId">${promo.promo_controlzoneId}</td>
					<%--Arreglar que solo salen los valores de la primera promoción que hay en la lista, no la que le toca --%>
					<td><button type="button" data-id="${promo.promoId}"
							class="btn btn-default editButton" onclick="showEditModal(this);" data-ng-click="vm.cargarDatos()">Editar</button></td>
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
					<form class="form" action="editPromos" method="GET">
						<div class="modal-body">
							<div class="form-group row">
								<div class="col-md-6">
									<img id="show-promoImage" src=""
										style="height: auto; width: 200px;" />
									<div class="form-group">
										<label for="promoImage"> URL Imagen</label> <input type="text"
											name="promoImage" id="edit-promoImage" class="form-control"
											required="required" />
									</div>
								</div>
								<div class="col-md-6">
									<input type="text" hidden="hidden" id="edit-promoId"
										name="promoId" /> <label for="promoName">Título</label> <input
										type="text" name="promoName" id="edit-promoName"
										class="form-control" required="required" /> <label
										for="promoDescription">Descripción</label>
									<textarea name="promoDescription" id="edit-promoDescription"
										class="form-control" required="required" rows="4"
										draggable="false" style="resize: none;"></textarea>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-6">
									<label for="promo_catNivel2">Categoría de nivel 2</label> <select
										name="promo_catNivel2" class="form-control"
										required="required" id="edit-promo_catNivel2" data-ng-model="categoria2">
										<%-- Rellenar dinámicamente--%>
										<option data-ng-repeat="x in vm.listaCategorias2" value="{{x.id}}" data-ng-selected="theCategory2({{x.id}})">{{x.category}}</option>
			
									</select>
								</div>
								<div class="col-md-6">
									<label for="promo_catNivel1">Categoría de nivel 1</label> <select
										name="promo_catNivel1" class="form-control"
										required="required" id="edit-promo_catNivel1" data-ng-model="categoria1">
										<%--Mejora: Rellenar dinámicamente--%>
										<option data-ng-repeat="x in vm.listaCategorias1 | filtrocat2:categoria2" value="{{x.id}}" data-ng-selected="theCategory1({{x.id}})">{{x.category}}</option>
										
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="promo_idProduct">ID Producto</label>
								<select name="promo_idProduct" class="form-control" required="required" id="edit-promo_idProduct">
									<option data-ng-repeat="x in vm.listaProductos | filtrocat1:categoria1" value="{{x.id}}" data-ng-selected="theProduct({{x.id}})">{{x.id}} {{x.name}}</option>
								</select> 
								<!-- <input
									type="date" name="promo_idProduct" class="form-control"
									required="required" id="edit-promo_idProduct" /> -->
							</div>
							<div class="form-group row">
								<div class="col-md-6">
									<label for="promoSince">Válido desde</label> <input type="date"
										name="promoSince" id="edit-promoSince" class="form-control"
										required="required" />
								</div>
								<div class="col-md-6">
									<label for="promoTo">Válido hasta</label> <input type="date"
										name="promoTo" id="edit-promoTo" class="form-control"
										required="required" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-6">
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
								<div class="col-md-6">
									<div class="form-group">
										<label for="promoGen">Género</label> <select name="promoGen"
											class="form-control" required="required" id="edit-promoGen">
											<option value="H">Hombre</option>
											<option value="M">Mujer</option>
											<option value="Todos">Todos</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-6">
									<label for="promoMinAge">Edad mínima</label> <input type="text"
										name="promoMinAge" class="form-control" required="required"
										id="edit-promoMinAge" />
								</div>
								<div class="col-md-6">
									<label for="promoMaxAge">Edad máxima</label> <input type="text"
										name="promoMaxAge" class="form-control" required="required"
										id="edit-promoMaxAge" />
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-info" value="Editar"
								id="submit" />
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
			var promoId= $(promo).closest("tr").find("#promoId").html();
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
			$("#edit-promoId").val(promoId);
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
			$('#show-promoImage').attr("src",promoImage); 
			
			//mostramos el modal
			modalEdit.modal("show");
			
			//Para selected de angular en filtros dinámico
			$scope.id = promo_idProduct;
			$scope.categoria1 = promo_catNivel1;
			$scope.categoria2 = promo_catNivel2;
			
		}
		
	</script>
</body>