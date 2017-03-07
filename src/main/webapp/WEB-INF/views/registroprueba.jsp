<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form role="form" action="registrarusuario" method="post">
<input type="email" required="required" class="form-control" 
name="email" placeholder="Introduce tu E-mail">
<input type="password" name="password" placeholder="Introduce tu pass">
<input type="text" name="age" placeholder="Introduce tu edad">
<input type="text" name="sex" placeholder="Introduce tu sexo">
<input type="submit" value="registrate" class="btn btn-info" />
</form>


</body>
</html>