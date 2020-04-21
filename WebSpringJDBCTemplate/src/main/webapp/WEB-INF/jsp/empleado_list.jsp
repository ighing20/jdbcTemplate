<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Empleado Lista</title>
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Empleado Lista</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="row">Empleado Id</th>
					<th scope="row">Nombre</th>
					<th scope="row">Apellido</th>
					<th scope="row">Email</th>
					<th scope="row">Telefono</th>
					<th scope="row">Edit</th>
					<th scope="row">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empleado_list }" var="empleado">
					<tr>
						<td>${empleado.idEmpleado }</td>
						<td>${empleado.nombre }</td>
						<td>${empleado.apellido }</td>
						<td>${empleado.email }</td>
						<td>${empleado.telefono }</td>
						<td><spring:url
								value="/empleado/update/${empleado.idEmpleado }" var="updateURL" />
							<a class="btn btn-success" href="${updateURL }" role="button">Actualizar</a>
						</td>
						<td><spring:url
								value="/empleado/delete/${empleado.idEmpleado }" var="deleteURL" />
							<a class="btn btn-danger" href="${deleteURL }" role="button">Eliminar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/empleado/add" var="addURL" />
		<a class="btn btn-success" href="${addURL }" role="button">Nuevo 
			Empleado</a>
	</div>
</body>
</html>