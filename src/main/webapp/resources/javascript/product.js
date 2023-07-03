

// gan so luong con lai len cho nguoi dung. 

 
const subtraction = document.querySelector("[data-subtraction]")

const plus = document.querySelector("[data-plus]")


const quantity = document.querySelector('input[name="quantity"]')

const formElement = document.querySelector("[data-form]")



subtraction.addEventListener("click",() => {
	if (quantity.value != 0) { 
		quantity.value--
	}
})

plus.addEventListener("click",() => {
	quantity.value++
})

formElement.addEventListener("submit",event => { 
	const formData = new FormData(event.target);
	let radioSizeValue = formData.get("radio-size") 
	if (quantity.value == 0 || radioSizeValue == null ) { 
		event.preventDefault() 
	}
})




