function cargarContenido(url) {
    fetch(url)
        .then(response => response.text())
        .then(html => {
            document.getElementById('contenido-principal').innerHTML = html;
        })
        .catch(err => {
            console.error(err);
        });
}


/*
Separar JS del HTML
✔ Usar contextPath en JSP
✔ Usar fetch para simular SPA
✔ Mantener layout fijo
function cargarContenido(ruta, elemento) {
    fetch(ruta)
        .then(response => {
            if (!response.ok) throw new Error("No se pudo cargar la página");
            return response.text();
        })
        .then(html => {
            document.getElementById('contenido-principal').innerHTML = html;

            // Actualizar menú activo
            document.querySelectorAll('.nav-link')
                .forEach(link => link.classList.remove('active'));

            if (elemento) {
                elemento.classList.add('active');
            }
        })
        .catch(error => {
            document.getElementById('contenido-principal')
                .innerHTML = `<p class="text-danger">${error}</p>`;
        });
}

Si quieres, puedo enseñarte ahora cómo hacerlo aún más limpio usando addEventListener en vez de onclick inline, que es la forma más profesional.
*/


/**
 * 
<!-- 🟢 MENU LATERAL -->
<nav class="col-md-3 col-lg-2 d-md-block bg-light vh-100 p-3">
    <ul class="nav nav-pills flex-column">

        <li class="nav-item">
            <a class="nav-link active" href="#" data-ruta="inicio.jsp">
                🏠 Inicio
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="#" data-ruta="usuarios">
                👤 Usuarios
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="#" data-ruta="reportes.jsp">
                📊 Reportes
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="#" data-ruta="configuracion.jsp">
                ⚙️ Configuración
            </a>
        </li>

    </ul>
</nav> 
 


js

document.addEventListener("DOMContentLoaded", function () {

    const links = document.querySelectorAll(".nav-link");
    const contenedor = document.getElementById("contenido-principal");

    links.forEach(link => {
        link.addEventListener("click", function (e) {
            e.preventDefault();

            const ruta = this.dataset.ruta;
            if (!ruta) return;

            cargarContenido(ruta, this);
        });
    });

    function cargarContenido(ruta, elementoActivo) {

        fetch(ruta)
            .then(response => {
                if (!response.ok) throw new Error("Error al cargar contenido");
                return response.text();
            })
            .then(html => {
                contenedor.innerHTML = html;

                // actualizar menú activo
                links.forEach(l => l.classList.remove("active"));
                elementoActivo.classList.add("active");

                // actualizar URL sin recargar
                history.pushState({ ruta: ruta }, "", ruta);
            })
            .catch(error => {
                contenedor.innerHTML =
                    `<div class="alert alert-danger">${error.message}</div>`;
            });
    }

    // Soporte botón atrás del navegador
    window.addEventListener("popstate", function (event) {
        if (event.state && event.state.ruta) {
            cargarContenido(event.state.ruta);
        }
    });

});


Estás aprendiendo:

Manipulación del DOM

Eventos con addEventListener

fetch() API

History API

Arquitectura SPA sin frameworks

Separación de responsabilidades (HTML vs JS)


https://chatgpt.com/s/t_6997f0a7582c8191a47964baaf63cdc5

Si quieres, el siguiente nivel sería:

🔹 Cargar automáticamente la primera vista al entrar

🔹 Mostrar un spinner mientras carga

🔹 Manejar sesión expirada automáticamente

🔹 Convertir esto en un mini router propio
 * 
 */