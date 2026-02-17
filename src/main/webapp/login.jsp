<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%
Map<String,String> errores = (Map<String,String>) request.getAttribute("errores");
%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap 5 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- CSS propio -->
<link rel="stylesheet" href="css/login.css">
</head>
<body class="bg-light">

	<div class="container">
		<div class="row justify-content-center align-items-center vh-100">
			<div class="col-12 col-sm-10 col-md-6 col-lg-4">

				<div class="card shadow-sm">
					<div class="card-body p-4">

						<!-- LOGO -->
						<div class="text-center mb-3">
							<img src="img/LogoWhite.png" alt="Logo" class="img-fluid"
								style="max-height: 80px;">
						</div>

						<h3 class="text-center mb-4">Iniciar Sesión</h3>
<%
								if(errores != null && errores.containsKey("isTrue")){
								out.println("<small class='alert alert-danger py-1 px-2 mt-1 mb-0 small'>"+errores.get("isTrue")+"</small>");
								}
							%>
						<form action="loginServlet" method="post">

							<div class="mb-3">
								<label for="user" class="form-label">Usuario</label> 
								
								<input
									type="text" class="form-control" id="user" name="user"
									placeholder="Ingrese su usuario">
							</div>
							
							<div class="mb-3">
								<label for="password" class="form-label">Contraseña</label> <input
									type="password" class="form-control" id="password"
									name="password" placeholder="Ingrese su contraseña">
							</div>
						
							<div class="d-grid mb-3">
								<button type="submit" class="btn btn-primary">Ingresar
								</button>
							</div>

							<div class="text-center">
								<a href="#" class="text-decoration-none"> ¿Olvidaste tu
									contraseña? </a>
							</div>

						</form>

					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>
