<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Empleado</title>
<link
	href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<spring:url value="/empleado/save" var="saveURL" />
		<h2>Empleado</h2>
		<form:form modelAttribute="empleadoForm" method="post"
			action="${saveURL }" cssClass="form">
			<form:hidden path="idEmpleado" />
			<div class="form-group">
				<lable for="nombre">Nombre</lable>
				<form:input path="nombre" cssClass="form-control" id="nombre" />
			</div>
			<div class="form-group">
				<lable for="apellido">Apellido</lable>
				<form:input path="apellido" cssClass="form-control" id="apellido" />
			</div>
			<div class="form-group">
				<lable for="email">Email</lable>
				<form:input path="email" cssClass="form-control" id="email" />
			</div>
			<div class="form-group">
				<lable for="telefono">Telefono</lable>
				<form:input path="telefono" cssClass="form-control" id="telefono" />
			</div>
			<button type="submit" class="btn btn-success">Guardar</button>
		</form:form>
	</div>
</body>
</html>