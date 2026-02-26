const form = document.getElementById('formLogin');

//Limpiar el formulario Cuando Carga
window.addEventListener("load",function(){
	const form = document.gerElgetElementById('formLogin');
	form.classList.remove("was-validated");
});

form.addEventListener('submit', function(event) {
 

  if (!form.checkValidity()) {
      event.preventDefault();
	  event.stopPropagation();
	  
  }

  form.classList.add('was-validated');
}, false);


