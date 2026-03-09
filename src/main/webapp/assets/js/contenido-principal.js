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


