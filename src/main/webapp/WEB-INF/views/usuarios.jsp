<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="links.jsp"></jsp:include>
<title>Usuarios</title>
<script type="text/javascript" src="resources/script/usersform.js"></script>
<script>

$(document).ready( function () {
    $('#table-users').DataTable( {
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
    
    $('#table-users_length').hide();
} );
</script>
</head>
<body>
	<form role="form" method="post" class="form-group">
		<div class="header-contain">
			<jsp:include page="navbar.jsp"></jsp:include>
			<div class="home-header">
				<div align="center">
					<h2>Gestión de usuarios</h2>
					<p>
						<button type=submit value="BloquearUsuario" role="button"
							class="btn btn-trigger" data-toggle="modal" formaction="usuario"
							data-target="#modalBlock">Bloquear seleccionados</button>
						<button type=submit value="DesbloquearUsuario" role="button"
							class="btn btn-trigger" data-toggle="modal" formaction="usuarios"
							data-target="#modalBlock">Desbloquear seleccionados</button>
					</p>
					<label class="label label-info" style="font-weight: lighter;">${mensajeblock}</label> <label
						class="label label-info" style="font-weight: lighter;">${mensajedesblock}</label>
					<hr style="backgound-color: #f9e553;" />
				</div>
			</div>
		</div>

		<div class="usuarios-info">
			<table class="table table-responsive table-bordered table-users"
				id="table-users">
				<thead>
					<tr class="table-users-header">
						<th>Email</th>
						<th>Genero</th>
						<th>Edad</th>
						<th>Bloqueado</th>
						<th data-orderable="false">Bloquear</th>
						<th data-orderable="false">Desbloquear</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuario}" var="Usuario">
						<tr>
							<td>${Usuario.userEmail}</td>
							<td>${Usuario.userGen}</td>
							<td>${Usuario.userAge}</td>
							<td><c:choose>
									<c:when test="${Usuario.userBlock == 1}">
										<i class="fa fa-lock fa-lg" aria-hidden="true"></i>
									</c:when>
									<c:otherwise>
										<i class="fa fa-unlock fa-lg" aria-hidden="true"></i>
									</c:otherwise>
								</c:choose></td>
							<td><input type="checkbox" name="bloquear"
								value="${Usuario.userEmail}"><br></td>
							<td><input type="checkbox" name="desbloquear"
								value="${Usuario.userEmail}"><br></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
	<footer> </footer>
</body>
</html>