

// bắc sự kiện submit 


const formRegister = document.getElementById("form-register")
const email = document.getElementById("register-email")
const username= document.getElementById("register-username")
const password= document.getElementById("register-password")
const passwordConfirm= document.getElementById("register-confirm-password") 




formRegister.addEventListener("submit",event => {
	
	
	if (email.value.trim() == "") {
		document.querySelector("[data-error-email]").innerHTML = "Không để trống email"
		event.preventDefault()
	}
	
	if (email.value.trim() == "") {
		document.querySelector("[data-error-username]").innerHTML = "Không để trống email"
		event.preventDefault()
	}
	
	
	
	if (password.value != passwordConfirm.value){
		document.querySelector("[data-error-password]").innerHTML = "Password không khớp"
		event.preventDefault()
	}
	
})