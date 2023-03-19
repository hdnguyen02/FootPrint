
const formRegister = document.getElementById("form-register")
const email = document.getElementById("register-email")
const username= document.getElementById("register-username")
const password= document.getElementById("register-password")
const passwordConfirm= document.getElementById("register-confirm-password") 


formRegister.addEventListener("submit",event => {
	
	
	email.value = email.value.trim() 
	email.innerText = email.value
	username.value = username.value.trim()
	username.innerText = username.value 
	
	const regex = /^(?=.*[a-zA-Z])(?=.*[0-9])(?!.*[\s]).{8,25}$/
	
	const isValidUsername = regex.test(username.value)
	const isValidPassword = regex.test(password.value)

	
	if (!isValidUsername) {
		document.querySelector("[data-error-username]").innerHTML = "8 đến 25 ký tự, có ít nhất 1 chữ số và 1 chữ cái và không chứa khoản trắng."
		event.preventDefault()
	}
	else {
		document.querySelector("[data-error-username]").innerHTML = ""
	}
	
	
	if (!isValidPassword ) {
		document.querySelector("[data-error-password]").innerHTML = "8 đến 25 ký tự, có ít nhất 1 chữ số và 1 chữ cái và không chứa khoản trắng."
		event.preventDefault()
	}
	else if (password.value != passwordConfirm.value){
		document.querySelector("[data-error-password]").innerHTML = "Password không khớp"
		event.preventDefault()
	}
	else {
		document.querySelector("[data-error-password]").innerHTML = ""
	}
	
})

email.addEventListener("focus",() => {
	if (document.querySelector("[data-result-email]")){
		document.querySelector("[data-result-email]").innerHTML = ""
	}
	
	document.querySelector("[data-error-email]").innerHTML = ""
})

username.addEventListener("focus", () => {
	if (document.querySelector("[data-result-username]")) {
		document.querySelector("[data-result-username]").innerHTML = ""
	}
	
	document.querySelector("[data-error-username]").innerHTML = ""
})

password.addEventListener("focus", () => {
	document.querySelector("[data-error-password]").innerHTML = ""
})


