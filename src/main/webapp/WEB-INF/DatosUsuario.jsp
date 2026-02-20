<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ejemplo Tabla CRUD</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Usuarios</h2>

    <!-- BotÃ³n Crear -->
    <a href="crear" class="btn btn-success mb-3">Crear Nuevo</a>

    <!-- Tabla -->
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <!-- Ejemplo de fila -->
            <tr>
                <td>1</td>
                <td>Juan PÃ©rez</td>
                <td>juan@example.com</td>
                <td>
                    <a href="editar?id=1" class="btn btn-primary btn-sm">Editar</a>
                    <a href="eliminar?id=1" class="btn btn-danger btn-sm">Eliminar</a>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>MarÃ­a GÃ³mez</td>
                <td>maria@example.com</td>
                <td>
                    <a href="editar?id=2" class="btn btn-primary btn-sm">Editar</a>
                    <a href="eliminar?id=2" class="btn btn-danger btn-sm">Eliminar</a>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>Carlos Ruiz</td>
                <td>carlos@example.com</td>
                <td>
                    <a href="editar?id=3" class="btn btn-primary btn-sm">Editar</a>
                    <a href="eliminar?id=3" class="btn btn-danger btn-sm">Eliminar</a>
                </td>
            </tr>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS (opcional para componentes) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>