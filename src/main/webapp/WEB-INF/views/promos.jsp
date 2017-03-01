<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestión de Promociones</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<h1>Gestión de Promociones</h1>
	<a href="#" role="button" class="btn btn-info">Añadir Promoción</a>
	<form>
		<label for="promo-titulo">Título</label>
		<input type="text" name="promo-titulo" />
		<label for="promo-descripcion">Descripción</label>
		<input type="text" name="promo-descripcion" />
		<label for="promo-validez">Validez</label>
		<input type="text" name="promo-validez" />
		<label for="promo-img"> URL Imagen</label>
		<input type="text" name="promo-img" />
		<label for="promo-zona">Zona de Control</label>
		<input type="text" name="promo-zona" />
		<select name="promo-edad">
			<option value="0-20">0-20</option>
			<option value="21-35">21-35</option>
			<option value="36-50">36-50</option>
			<option value="+50">+50</option>
			<option value="todos">Todos</option>
		</select>
		<select name="promo-sexo">
			<option value="H">Hombre</option>
			<option value="M">Mujer</option>
			<option value="Todos">Todos</option>

			
		</select>
	</form>
</body>
</html>