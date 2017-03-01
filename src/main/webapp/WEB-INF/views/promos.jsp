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
	<jsp:include page="navbar.jsp"></jsp:include>
	<h1>Gestión de Promociones</h1>
	<a href="#" role="button" class="btn btn-info">Añadir Promoción</a>
	<form class="form" action="altaPromos" method="POST">
		<div class="form-group">
			<label for="promo-titulo">Título</label>
			<input type="text" name="promo-titulo" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="promo-descripcion">Descripción</label>
			<input type="text" name="promo-descripcion" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="promo-validez">Validez</label>
			<input type="text" name="promo-validez" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="promo-img"> URL Imagen</label>
			<input type="text" name="promo-img" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="promo-zona">Zona de Control</label>
			<input type="text" name="promo-zona" class="form-control"/>
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
		<input type="submit" class="btn btn-info" value="Dar de alta"/>
	</form>
</body>
</html>