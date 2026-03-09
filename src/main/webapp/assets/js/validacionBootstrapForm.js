


	
	(() => {
	  'use strict'
	  const forms = document.querySelectorAll('#formRegistro')

	  Array.from(forms).forEach(form => {
	    form.addEventListener('submit', event => {

	      const password = document.getElementById("password")
	      const confirmPassword = document.getElementById("confirmPassword")

	      if(password.value !== confirmPassword.value){
	        confirmPassword.classList.add("is-invalid")
	        event.preventDefault()
	        event.stopPropagation()
	      }

	      if (!form.checkValidity()) {
	        event.preventDefault()
	        event.stopPropagation()
	      }

	      form.classList.add('was-validated')

	    }, false)
	  })
	})()
