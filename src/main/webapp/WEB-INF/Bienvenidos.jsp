<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="code.figueroa.services.login.*"%>
<%
LoginServices sessionServices = new LoginServicesImpl();
var nombreSession = sessionServices.getSessionUserName(request,"usuario");
%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Panel Principal</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/contenido-principal.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<!-- 🔵 NAVBAR SUPERIOR -->
	<nav class="navbar navbar-dark bg-primary">
		<div class="container-fluid">
			<span class="navbar-brand"> Bienvenido <strong><%=nombreSession.getNickName()%>
					,</strong> Rol <strong><%=nombreSession.getRol().Nombre()%></strong>
			</span> <a href="logout" class="btn btn-light">Logout</a>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">

			<!-- 🟢 MENU LATERAL 100% ALTURA -->
			<nav class="col-md-3 col-lg-2 d-md-block bg-light vh-100 p-3">
				<ul class="nav nav-pills flex-column">

					<li class="nav-item"><a class="nav-link" href="#"
						onclick="cargarContenido('loginServlet')">🏠 Inicio</a></li>

					<li class="nav-item"><a class="nav-link" href="#"
						onclick="cargarContenido('DatosUsuario')">👤 Usuarios</a></li>
					<li class="nav-item"><a class="nav-link" href="#">📊
							Reportes</a></li>

					<li class="nav-item"><a class="nav-link" href="#">⚙️
							Configuración</a></li>

				</ul>
			</nav>

			<main class="col-md-9 col-lg-10 p-4" id="contenido-principal">
				<!-- Navbar -->
				<nav class="navbar shadow-sm p-3 mb-4">
					<div class="container-fluid">
						<h5 class="mb-0 fw-bold">Panel Principal</h5>
						<div>
							<span class="me-3 text-muted"> <i
								class="bi bi-person-circle"></i> <%=nombreSession.getNombre()%> <%=nombreSession.getApellido() %>
							</span> <span class="badge bg-success"><%=nombreSession.getRol().Nombre()%></span>
						</div>
					</div>
				</nav>
				<div class="container-fluid">
					<!-- Bienvenida -->
					<div class="alert alert-light shadow-sm border-0 rounded-4 mb-4">
						<h4 class="fw-bold">Bienvenido, <%=nombreSession.getNickName()%></h4>
						<p class="mb-0 text-muted"><%=nombreSession.getRol().Descripcion() %></p>
					</div>
				</div>
			</main>

		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
