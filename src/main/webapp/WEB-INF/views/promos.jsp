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
				data-target="#modalPromo">Añadir Promoción</a> <span>${mensaje}</span>
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
								name="promoName" class="form-control" required="required" />
						</div>
						<div class="form-group">
							<label for="promoDescription">Descripción</label> <input
								type="text" name="promoDescription" class="form-control"
								required="required" />
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
								<option value="0">Genérica</option>
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
				<th>Válida desde</th>
				<th>Válida hasta</th>
				<th>Activa</th>
				<th>Creación</th>
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
					<td>Categoría A</td>
					<td>${promo.promoSince}</td>
					<td>${promo.promoTo}</td>
					<td align="center">
					<c:choose>
							<c:when test="${promo.promoState == 1}">
								<i class="fa fa-check-circle-o fa-lg" aria-hidden="true"></i>
							</c:when>
							<c:otherwise>
								<i class="fa fa-times fa-lg" aria-hidden="true"></i>
							</c:otherwise>
					</c:choose>
					</td>
					<td>${promo.promoCreate}</td>
					<td>${promo.promoMinAge}- ${promo.promoMaxAge}</td>
					<td>${promo.promoGen}</td>
					<td>${promo.promo_controlzoneId}</td>
					<%--Arreglar que solo salen los valores de la primera promoción que hay en la lista, no la que le toca --%>
					<td><a href="#" role="button" class="btn btn-default"
						data-toggle="modal" data-target="#modalEdit" onclick="showEdit();">Editar</a></td>	
						<td style="display: none" id="td-modalEdit">
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
														name="promoName" class="form-control" required="required" value="${promo.promoName}" />
												</div>
												<div class="form-group">
													<label for="promoDescription">Descripción</label> <input
														type="text" name="promoDescription" class="form-control"
														required="required" value="${promo.promoDescription}"/>
												</div>
												<div class="form-group">
													<label for="promoSince">Válido desde</label> <input
														type="date" name="promoSince" class="form-control"
														required="required" value="${promo.promoSince}"/>
												</div>
												<div class="form-group">
													<label for="promoTo">Válido hasta</label> <input type="date"
														name="promoTo" class="form-control" required="required" value="${promo.promoTo}"/>
												</div>
												<div class="form-group">
													<label for="promoImage"> URL Imagen</label> <input type="text"
														name="promoImage" class="form-control" required="required" value="${promo.promoImage}" />
												</div>
												<div class="form-group">
													<label for="promo_controlZoneId">Zona de Control</label> 
													<select name="promo_controlZoneId" class="form-control"
														required="required">
														<%--Utilizamos un if para que aparezca marcada la opción real de la promoción --%>
														<option value="0" <c:if test="${promo.promo_controlzoneId.equals(0)}">selected="selected"</c:if>>Genérica</option>
														<option value="1" <c:if test="${promo.promo_controlzoneId.equals(1)}">selected="selected"</c:if>>Zona 1</option>
														<option value="2" <c:if test="${promo.promo_controlzoneId.equals(2)}">selected="selected"</c:if>>Zona 2</option>
														<option value="3" <c:if test="${promo.promo_controlzoneId.equals(3)}">selected="selected"</c:if>>Zona 3</option>
													</select>
												</div>
												<div class="form-group">
													<span>Rango de edad</span>
													<br /> 
													<label for="promoMinAge">Edad mínima</label> 
														<input type="text" name="promoMinAge" class="form-control" required="required" value="${promo.promoMinAge}"/> 
														<label for="promoMaxAge">Edad máxima</label> 
														<input type="text" name="promoMaxAge" class="form-control" required="required" value="${promo.promoMaxAge}"/>
												</div>
												<div class="form-group">
													<label for="promoGen">Género</label> 
													<select name="promoGen" class="form-control" required="required">
														<option value="H" <c:if test="${promo.promoGen.equals('H')}">selected="selected"</c:if>>Hombre</option>
														<option value="M" <c:if test="${promo.promoGen.equals('H')}">selected="selected"</c:if>>Mujer</option>
														<option value="Todos" <c:if test="${promo.promoGen.equals('Todos')}">selected="selected"</c:if>>Todos</option>
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
		$(document).ready(function(){
   		 $('[data-toggle="popover"]').popover();   
	});
		function showEdit() {
			$('#td-modalEdit').fadeIn();
		}
</script>
</body>
</html>