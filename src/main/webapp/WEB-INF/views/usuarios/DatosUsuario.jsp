<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="code.figueroa.models.usuario.*"%>
<%@page import="code.figueroa.services.user.*"%>
<%
UserServices usuarioList = new UserServicesImpl();
List<Usuario> listaUsuario = usuarioList.listar();
%>
<%@ include file="../../layout/navbar.jsp"%>
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
		<a href="Registro" name="accion" value="registrar"
			class="btn btn-success mb-3">Crear Nuevo</a>


		<!-- BotÃ³n Crear -->

		<main class="col-md-9 col-lg-10 p-4" id="contenido-principal">
			<!-- Tabla -->
			<div class="container py-4">

				<div class="card shadow">

					<div class="card-header fw-bold">Lista de Usuarios</div>

					<div class="card-body">

						<div class="table-responsive">

							<table class="table table-hover align-middle">

								<thead class="table-dark">
									<tr>
										<th>Nickname</th>
										<th>Nombre</th>
										<th>Email</th>
										<th>Rol</th>
										<th class="text-center">Acciones</th>
									</tr>
								</thead>
								<tbody>
									<% for (Usuario u : listaUsuario) { %>
									<tr>
										<td><%= u.getNickName() %></td>
										<td><%= u.getNombre() + " " + u.getApellido() %></td>
										<td><%= u.getCorreo() %></td>
										<td><span class="badge bg-secondary"> <%= u.getRol().Nombre() %>
										</span></td>
										<td class="text-center">
											<div class="d-flex justify-content-center gap-2">
												<form action="Actualizar" method="GET" class="m-0">
													<input type="hidden" name="email"
														value="<%=u.getCorreo()%>">
													<button type="submit" class="btn btn-primary btn-sm"
														name="accion" value="editar">Editar</button>
												</form>
												<form action="Delete" method="POST" class="m-0">
													<input type="hidden" name="email"
														value="<%=u.getCorreo()%>">
													<button type="submit" class="btn btn-danger btn-sm"
														name="accion" value="eliminar">Eliminar</button>
												</form>
											</div>
										</td>
									</tr>
									<%  } %>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>

	<!-- Bootstrap JS (opcional para componentes) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>