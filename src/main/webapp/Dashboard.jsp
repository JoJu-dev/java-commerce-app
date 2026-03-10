<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%
  Integer userConnected = (Integer) request.getAttribute("nUsuarios");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Dashboard Simple</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/layout/navbar.jsp"%>
<div class="container mt-5">

    <!-- Card: Fecha y hora -->
    <div class="card mb-4">
        <div class="card-body">
            <h5 class="card-title">Fecha y Hora Actual</h5>
            <p class="card-text" id="fechaHora"></p>
        </div>
    </div>

    <!-- Card: Usuarios conectados -->
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Usuarios Conectados <%=userConnected%></h5>
            <table class="table table-hover">
                <thead>
                    <tr thead class="table-dark">
                        <th>Nickname</th>
                        <th>Correo Electrónico</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Juan123</td>
                        <td>juan@example.com</td>
                    </tr>
                    <tr>
                        <td>Ana456</td>
                        <td>ana@example.com</td>
                    </tr>
                    <tr>
                        <td>Carlos789</td>
                        <td>carlos@example.com</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- Script para actualizar fecha y hora -->
<script>
function actualizarFechaHora() {
    const ahora = new Date();
    const opciones = { 
        weekday: 'long', year: 'numeric', month: 'long', day: 'numeric',
        hour: '2-digit', minute: '2-digit', second: '2-digit'
    };
    document.getElementById('fechaHora').innerText = ahora.toLocaleDateString('es-ES', opciones);
}
setInterval(actualizarFechaHora, 1000);
actualizarFechaHora();
</script>

</body>
</html>