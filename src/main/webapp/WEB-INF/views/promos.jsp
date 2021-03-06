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
		<div class="home-header">
		<div align="center">
			<h2>Gestión de promociones</h2>
			<a href="#" role="button" class="btn btn-trigger" data-toggle="modal"
				data-target="#modalPromo" data-ng-click="vm.cargarDatos()">
				Añadir Promoción</a> <span class="label label-info">${mensaje}</span>
			<hr style="backgound-color: #f9e553;"/>
		</div>
	</div>
	</div>
	<!-- Modal Añadir Promoción-->
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
								<label for="promo_controlzoneId">Zona de Control</label> <select
									name="promo_controlzoneId" class="form-control"
									required="required">
									<c:forEach items="${listaZonas}" var="zona">
										<option value="${zona.controlzoneId}">${zona.controlzoneEmplacement}</option>
									</c:forEach>
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
	<div class="promo-info">
		<table class="table table-responsive table-bordered table-promos" id="table-promos">
			<thead>
			<tr align="center" class="table-promos-header">
				<th hidden="hidden">ID</th>
				<th hidden="hidden">Descripción</th>
				<th hidden="hidden">Categoría Nivel 2</th>
				<th hidden="hidden">Categoría Nivel 1</th>
				<th hidden="hidden" >Desde</th>
				<th hidden="hidden">Hasta</th>
				<th hidden="hidden">Imagen</th>
				<th data-orderable="false">Título</th>
				<th data-orderable="false">Categoría</th>
				<th data-orderable="false">Producto</th>
				<th hidden="hidden">Referencia Producto</th>
				<th data-orderable="false">Activa</th>
				<th>Edad</th>
				<th>Género</th>
				<th>Zona</th>
				<th hidden="hidden">Zona nombre</th>
				<th data-orderable="false">Editar</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${listaPromos}" var="promo">
				<tr>
					<td hidden="hidden" id="promoId">${promo.promoId}</td>
					<td><a href="#" class="popover-promo" title="Descripción"
						data-toggle="popover" data-trigger="hover" data-placement="bottom"
						data-content="${promo.promoDescription}" id="promoName">${promo.promoName}</a></td>
					<%-- Necesitamos tener la descripción (oculta- ya que está en el popover) para poder cogerla en el formulario --%>
					<td hidden="hidden" id="promoDescription">${promo.promoDescription}</td>
					<td hidden="hidden" id="promo_catNivel2">${promo.promo_catNivel2}</td>
					<td hidden="hidden" id="promo_catNivel1">${promo.promo_catNivel1}</td>
						<c:forEach items="${listaCat1}" var="cat1">
							<c:if test="${cat1.id eq promo.promo_catNivel1}">
								<td id="catNivel1">${cat1.category}</td>
							</c:if>
						</c:forEach>
					<td hidden="hidden" id="promo_idProduct">${promo.promo_idProduct}</td>
					<td>
						<c:forEach items="${listaProductos}" var="producto">
								<c:if test="${producto.id eq promo.promo_idProduct}">
										${producto.productName}
								</c:if>
						</c:forEach>
					</td>
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
					<td hidden="hidden" id="promo_controlzoneId">${promo.promo_controlzoneId}</td>
					<td>
						<c:forEach items="${listaZonas}" var="zona">
								<c:if test="${zona.controlzoneId eq promo.promo_controlzoneId}">
										${zona.controlzoneEmplacement}
								</c:if>
						</c:forEach>
					</td>
					<td><a role="button" data-id="${promo.promoId}"
							onclick="showEditModal(this);" data-ng-click="vm.cargarDatos()"><i class="fa fa-pencil-square-o fa-lg" style="color: black" aria-hidden="true"></i></a>
						<a role="button" data-id="${promo.promoId}" 
							onclick="showDeleteModal(this);"><i class="fa fa-trash-o fa-lg" style="color: black" aria-hidden="true"></i></a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
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
										name="promoId" /> 
										<label for="promoName">Título</label> 
										<input type="text" name="promoName" id="edit-promoName"
										class="form-control" required="required" /> <label
										for="promoDescription">Descripción</label>
									<textarea name="promoDescription" id="edit-promoDescription"
										class="form-control" required="required" rows="4"
										draggable="false" style="resize: none;"></textarea>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-6">
									<label for="promo_catNivel2">Categoría de nivel 2</label> 
										<select class="form-control" name="promo_catNivel2" id="edit-promo_catNivel2">
											<c:forEach items="${listaCat2}" var="categoria2">
													<option value="${categoria2.id}"> ${categoria2.category}</option>
											</c:forEach>
										</select>
									
								</div>
								<div class="col-md-6">
									<label for="promo_catNivel1">Categoría de nivel 1</label> 
										<select class="form-control" name="promo_catNivel1" id="edit-promo_catNivel1">
											<c:forEach items="${listaCat1}" var="categoria1">
													<option value="${categoria1.id}"> ${categoria1.category}</option>
											</c:forEach>
										</select>
									
								</div>
							</div>
							<div class="form-group">
								<label for="promo_idProduct">ID Producto</label>
									<select class="form-control" name="promo_idProduct" id="edit-promo_idProduct">
											<c:forEach items="${listaProductos}" var="producto">
													<option value="${producto.id}"> ${producto.productName}</option>
											</c:forEach>
										</select>
								
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
									<label for="promo_controlzoneId">Zona de Control</label> 
										<select
										name="promo_controlzoneId" class="form-control"
										required="required" id="edit-promo_controlzoneId">
											<c:forEach items="${listaZonas}" var="zona">
													<option value="${zona.controlzoneId}"> ${zona.controlzoneEmplacement}</option>
											</c:forEach>
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
	
	<!-- Modal Eliminar -->
	<div id="modalDelete" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Eliminar Promoción</h4>
				</div>
				<form class="form" action="deletePromo" method="POST">
					<div class="modal-body">
						<p>¿Estás seguro que quieres eliminar la promoción?</p>
						<input type="hidden" id="deletePromo" name="promoId"/>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-danger" value="Eliminar" />
						<button type="button" class="btn btn-default" data-dismiss="modal">Volver</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<!-- TODO pasarlo a un documento js propio -->
	<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		    $('#table-promos').DataTable( {
	    		"language": {
	        "lengthMenu": "Mostrar _MENU_ usuarios por página",
	        "zeroRecords": "No se ha encontrado nada - lo sentimos!",
	        "info": "Mostrando página _PAGE_ de _PAGES_",
	        "infoEmpty": "No se ha encontrado nada - lo sentimos!",
	        "infoFiltered": "(filtrado por  _MAX_ registros totales)",
	        "search":         "Buscar:",
	        "paginate": {
	            "first":      "Primero",
	            "last":       "Último",
	            "next":       "Siguiente",
	            "previous":   "Anterior"
	        },
	        }
	    });
		    $('[type=search]').attr('class', 'input-sm');
		    $('[type=search]').attr('style', 'width: 300px;');
		    
		    $('#table-promos_length').hide();

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
			/*
			$scope.id = promo_idProduct;
			$scope.categoria1 = promo_catNivel1;
			$scope.categoria2 = promo_catNivel2;
			*/
					
		}
		
		function showDeleteModal(promo) {
			var modalDelete = $("#modalDelete");
			var promoId= $(promo).closest("tr").find("#promoId").html();
			$("#deletePromo").val(promoId);
			modalDelete.modal("show");		
		}
		
	</script>
		<footer>
	</footer>
</body>