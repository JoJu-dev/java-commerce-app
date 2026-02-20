<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Panel Principal</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- 🔵 NAVBAR SUPERIOR -->
<nav class="navbar navbar-dark bg-primary">
    <div class="container-fluid">
        <span class="navbar-brand">
            Bienvenido, <strong>Juan Pérez</strong>
        </span>
        <button class="btn btn-light">Logout</button>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">

        <!-- 🟢 MENU LATERAL 100% ALTURA -->
        <nav class="col-md-3 col-lg-2 d-md-block bg-light vh-100 p-3">
            <ul class="nav nav-pills flex-column">

                <li class="nav-item">
                    <a class="nav-link active" href="#">🏠 Inicio</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">👤 Usuarios</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">📊 Reportes</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">⚙️ Configuración</a>
                </li>

            </ul>
        </nav>

        <!-- 🟡 CONTENIDO -->
        <main class="col-md-9 col-lg-10 p-4">
            <h2>Panel de Control</h2>
            <p>Contenido principal aquí...</p>
        </main>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
