<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="links.jsp"></jsp:include>
<title>Login usuario</title>
</head>
<body id="login-body">
	<div class="img-login" align="center">
		<img alt="logo-activa" src="resources/img/logo.png" width= "30%" style="margin-top: 30px;">
	</div>
	<!-- Modal estático -->
	<div class="modal show modal-login">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Login Administrador</h4>
					
				</div>
				<div class="modal-body">
					<!-- form -->
					<form role="form" action="home" method="post" class="form-group">
						<input type="text" name="admin" placeholder="Introduce tu usuario" class="form-control" required="required"/> 
						<input type="password" name="adminPassword" placeholder="Introduce tu contraseña" class="form-control" required="required" />
				</div>
				<div class="modal-footer">
					<p class="label label-danger">${mensajeerror}</p>
					<p class="label label-danger">${mensajedespedida}</p>
					<input type="submit" value="acceder" class="btn btn-trigger" />
				</div>
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>