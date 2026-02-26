const form = document.getElementById('formLogin');



//Limpiar el formulario Cuando Carga
window.addEventListener("load", function() {
	const form = document.getElementById('formLogin');
	form.classList.remove("was-validated");
});

form.addEventListener('submit', function(event) {


	if (!form.checkValidity()) {
		event.preventDefault();
		event.stopPropagation();

	}

	form.classList.add('was-validated');
}, false);


//Limpiar la alerta de error proporcionada por el Servlet al validar campos

document.addEventListener("DOMContentLoaded", function() {

	const email = document.getElementById("email");
	const password = document.getElementById("password");

	function ocultarError() {
		const errorDiv = document.getElementById("alertError");
		if (errorDiv) {
			errorDiv.remove();
		}
	}

	if (email) {

		email.addEventListener("input", ocultarError);

	}
	if (password) {

		password.addEventListener("input", ocultarError);
	}
});