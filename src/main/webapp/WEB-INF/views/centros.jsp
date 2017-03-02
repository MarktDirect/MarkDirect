<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>


<html>
<head>

<jsp:include page="links.jsp"></jsp:include>

<title>Alta Centro</title>
</head>
<body>
	<!-- Modal content-->
	<!--<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">Añadir Centro</h4>
		</div>
		<form class="form" action="altaCentro" method="POST">
			<div class="modal-body">
				<div class="form-group">
					<label for="centro-nombre">NOMBRE</label> <input type="text"
						name="centro-nombre" class="form-control" />
				</div>
				<div class="form-group">
					<label for="centro-direccion">DIRECCIÓN</label> <input type="text"
						name="centro-direccion" class="form-control" />
				</div>
				<div class="form-group">
					<label for="centro-descripcion">DESCRIPCIÓN</label> <input
						type="text" name="centro-descripcion" class="form-control" />
				</div>
				<div class="form-group">
					<label for="centro-tipo">TIPO</label> <input type="text"
						name="centro-tipo" class="form-control" />
				</div>
				<div class="form-group">
					<label for="centro-subtipo">SUBTIPO</label> <input type="text"
						name="centro-subtipo" class="form-control" />
				</div>

				<div class="modal-footer">
					<input type="submit" class="btn btn-info" value="Dar de alta" />
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</form>
	</div>-->

	<div class="col-md-12">
		<table class="table">
			<thead>
				<tr>
					<th>NOMBRE</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>DIRECCIÓN</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>DESCRIPCIÓN</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>

				<tr>
					<td>TIPO</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>SUBTIPO</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>ACTIVO</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>VER CENTRO</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>