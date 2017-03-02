<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>Gestión de Promociones</h1>
	<a href="#" role="button" class="btn btn-info" data-toggle="modal"
		data-target="#modalPromo">Añadir Promoción</a>

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
							<label for="promo-titulo">Título</label> <input type="text"
								name="promo-titulo" class="form-control" />
						</div>
						<div class="form-group">
							<label for="promo-descripcion">Descripción</label> <input
								type="text" name="promo-descripcion" class="form-control" />
						</div>
						<div class="form-group">
							<label for="promo-validez">Validez</label> <input type="text"
								name="promo-validez" class="form-control" />
						</div>
						<div class="form-group">
							<label for="promo-img"> URL Imagen</label> <input type="text"
								name="promo-img" class="form-control" />
						</div>
						<div class="form-group">
							<label for="promo-zona">Zona de Control</label> <input
								type="text" name="promo-zona" class="form-control" />
						</div>
						<div class="form-group">
							<select name="promo-edad" class="form-control">
								<option value="0-20">0-20</option>
								<option value="21-35">21-35</option>
								<option value="36-50">36-50</option>
								<option value="+50">+50</option>
								<option value="todos">Todos</option>
							</select>
						</div>
						<div class="form-group">
							<select name="promo-sexo" class="form-control">
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