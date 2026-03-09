<%@page contentType="text/html"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Registro</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/login.css">
</head>

<body>

<!-- Navbar -->
<%@ include file="../../layout/navbar.jsp"%>

<!-- Contenedor principal -->
<div class="container py-5">

  <div class="row justify-content-center">

    <div class="col-12 col-sm-10 col-md-8 col-lg-6 col-xl-5">

      <div class="card shadow">

        <div class="card-header text-center fw-bold">
          Registro de Usuario
        </div>

        <div class="card-body p-4">

          <form method="POST" id="formRegistro" name="accion" action="Registro" novalidate>

            <!-- Nombre -->
            <div class="mb-3">
              <label for="name" class="form-label">Nombre</label>
              <input type="text" class="form-control" id="name" name="name" required>
              <div class="invalid-feedback">Ingresa tu nombre.</div>
            </div>

            <!-- Apellido -->
            <div class="mb-3">
              <label for="lastName" class="form-label">Apellido</label>
              <input type="text" class="form-control" id="lastName" name="lastName" required>
              <div class="invalid-feedback">Ingresa tu apellido.</div>
            </div>

            <!-- Fecha -->
            <div class="mb-3">
              <label for="dateOfBirth" class="form-label">Fecha de Nacimiento</label>
              <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" required>
              <div class="invalid-feedback">Selecciona tu fecha de nacimiento.</div>
            </div>

            <!-- Nick -->
            <div class="mb-3">
              <label for="nickName" class="form-label">Nickname</label>
              <input type="text" class="form-control" id="nickName" name="nickName" required>
              <div class="invalid-feedback">Ingresa un nickname.</div>
            </div>

            <!-- Email -->
            <div class="mb-3">
              <label for="email" class="form-label">Correo Electrónico</label>
              <input type="email" class="form-control" id="email" name="email" required>
              <div class="invalid-feedback">Ingresa un correo válido.</div>
            </div>

            <!-- Password -->
            <div class="mb-3">
              <label for="password" class="form-label">Contraseña</label>
              <input type="password" class="form-control" id="password" name="password" minlength="6" required>
              <div class="invalid-feedback">
                La contraseña debe tener al menos 6 caracteres.
              </div>
            </div>

            <!-- Confirm Password -->
            <div class="mb-3">
              <label for="confirmPassword" class="form-label">Confirmar Contraseña</label>
              <input type="password" class="form-control" id="confirmPassword" required>
              <div class="invalid-feedback" id="confirmPasswordFeedback">
                Las contraseñas no coinciden.
              </div>
            </div>

            <!-- Rol -->
            <div class="mb-3">
              <label for="rol" class="form-label">Rol</label>
              <select name="rol" class="form-select" id="rol" required>
                <option value="">Selecciona un rol</option>
                <option value="1">Administrador</option>
                <option value="2">Cliente</option>
                <option value="3">Usuario</option>
              </select>
              <div class="invalid-feedback">Selecciona un rol.</div>
            </div>

            <!-- Botón -->
            <div class="d-grid">
              <button type="submit" class="btn btn-primary">
                Registrarse
              </button>
            </div>

          </form>

        </div>

        <div class="card-footer text-center">
          ¿Ya tienes cuenta? <a href="login.jsp">Iniciar sesión</a>
        </div>

      </div>

    </div>

  </div>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<script src="assets/js/validacionBootstrapForm.js">

/* Validación Bootstrap */

</script>

</body>
</html>