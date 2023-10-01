/*

const btnsSelectOrder = document.querySelectorAll("[data-btn-select-order]")

const containerOrderEl = document.querySelector("[data-container-order]")

btnsSelectOrder.forEach(btnSelectOrder => { 
	btnSelectOrder.addEventListener("click",event => { 
		let idOrder = event.currentTarget.dataset.idOrder
		let selectOrder = document.querySelector(`[data-select-order='${idOrder}']`).cloneNode(true)
		selectOrder.style.display = "block"
		containerOrderEl.innerHTML = ""
		containerOrderEl.append = selectOrder
	})
})*/

function handleSubmit(event){
	document.querySelector("[name='id-order']").value =  event.currentTarget.dataset.idOrder

}