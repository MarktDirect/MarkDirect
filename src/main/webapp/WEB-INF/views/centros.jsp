<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>


<html>
<head>

<jsp:include page="links.jsp"></jsp:include>

<title>Alta Centro</title>
</head>
<body>
<div class="header-contain">
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="jumbotron">
			<h2>Gestión de Centros</h2>
			<a href="#" role="button" class="btn btn-trigger" data-toggle="modal"
				data-target="#modalCentros">Añadir Centro</a>
		</div>
	</div>
	<!-- Modal -->
	<div id="modalCentros" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Añadir Centro</h4>
				</div>
				<form class="form" action="altaCentro" method="POST">
					<div class="modal-body">
						<div class="form-group">
							<label for="centerNombre">Nombre</label> <input type="text"
								name="centerNombre" class="form-control" />
						</div>
						<div class="form-group">
							<label for="centerDireccion">Dirección</label> <input
								type="text" name="centerDireccion" class="form-control" />
						</div>
						<div class="form-group">
							<label for="centerDescription">Descripción</label> <input
								type="text" name="centerDescription" class="form-control" />
						</div>
						<div class="form-group">
							<label for="centerTipo">Tipo</label> <input type="text"
								name="centerTipo" class="form-control" />
						</div>
						<div class="form-group">
							<label for="centerSubtipo">Subtipo</label> <input type="text"
								name="centerSubtipo" class="form-control" />
						</div>

						<div class="modal-footer">
							<input type="submit" class="btn btn-info" value="Dar de alta" />
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<table class="table">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Dirección</th>
					<th>Descripción</th>
					<th>Tipo</th>
					<th>Sutipo</th>
					<th>Ver Centro</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>