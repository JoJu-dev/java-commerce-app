<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="code.figueroa.models.usuario.*"%>
<%@page import="code.figueroa.services.user.*"%>
<%
 UserServices usuarioList = new UserServicesImpl();
 List<Usuario> listaUsuario = usuarioList.listar();
%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Ejemplo Tabla CRUD</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h2 class="mb-4">Panel Administrativo de Usuarios</h2>

		<!-- BotÃ³n Crear -->
		<a href="Registro" class="btn btn-success mb-3" >Crear Nuevo</a>

		<main class="col-md-9 col-lg-10 p-4" id="contenido-principal">
			<!-- Tabla -->
			<table class="table table-bordered table-striped">
				<thead class="table-dark">
					<tr>
						<th>NickNme</th>
						<th>Nombre</th>
						<th>Email</th>
						<th>Acciones</th>
						<th>Rol</th>
					</tr>
				</thead>
				<tbody>
					<!-- Ejemplo de fila -->
					<% for(Usuario u : listaUsuario){ %>
					<tr>
						<td><%= u.getNickName()%></td>
						<td><%= u.getNombre() + " " + u.getApellido()%></td>
						<td><%=u.getCorreo()%></td>
						<td><%=u.getRol().Nombre()%></td>
						<td><a href="editar?id=1" class="btn btn-primary btn-sm">Editar</a>
							<a href="eliminar?id=1" class="btn btn-danger btn-sm">Eliminar</a>
						</td>
					</tr>
					<% } %>
				</tbody>
			</table>
			</main>
	</div>

	<!-- Bootstrap JS (opcional para componentes) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>