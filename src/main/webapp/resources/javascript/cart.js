

function callController(pageUrl,data) {
	$.post(pageUrl,data, function() {
		history.pushState(null, '', pageUrl);
	});
}




const btnsSubtract = document.querySelectorAll("[data-subtraction]")
const btnsPlus = document.querySelectorAll("[data-plus]")
const btnsDelete = document.querySelectorAll('[data-cart-delete]')

btnsDelete.forEach(btnDelete => {
	btnDelete.addEventListener("click",event => {
		let curentTarget = event.currentTarget
		let idCart = curentTarget.dataset.cartDelete
		let wraperCart = document.querySelector(`[data-cart-wrapper='${idCart}']`)
		let hrCart = document.querySelector(`[data-cart-hr='${idCart}']`)
		wraperCart.remove()
		hrCart.remove()
		callController(`/FootPrint/cart.htm`,{ idCart , isDelete: true})
		
	})
})


btnsPlus.forEach(btnPlus => {
	btnPlus.addEventListener("click",event => {
		let curentTarget = event.currentTarget
		let idCart = curentTarget.dataset.plus; 
		let quantityUpdate = ++document.querySelector(`[data-cart-quantity='${idCart}']`).value 
		
		computedTotal(idCart)
		
		
		
		callController(`/FootPrint/cart.htm`,{ idCart , quantityUpdate})	
	})
})

btnsSubtract.forEach(btnSubtract => {
	btnSubtract.addEventListener("click",event => {
		let curentTarget = event.currentTarget
		let idCart = curentTarget.dataset.subtraction; 
	
		let quantityUpdate = document.querySelector(`[data-cart-quantity='${idCart}']`).value 
		
		if (quantityUpdate != 0) {
			quantityUpdate = --document.querySelector(`[data-cart-quantity='${idCart}']`).value
			computedTotal(idCart)
			callController(`/FootPrint/cart.htm`,{ idCart , quantityUpdate})
		}
	})
})


const totalCarts = document.querySelectorAll("[data-cart-total]")

totalCarts.forEach(totalCart => {
	let idCart = totalCart.dataset.cartTotal
	let costCart = +document.querySelector(`[data-cart-cost='${idCart}']`).textContent 
	let quantityCart = +document.querySelector(`[data-cart-quantity='${idCart}']`).value
	totalCart.textContent = costCart * quantityCart
})

function computedTotal(idCart){
	let costCart = +document.querySelector(`[data-cart-cost='${idCart}']`).textContent 
	let quantityCart = +document.querySelector(`[data-cart-quantity='${idCart}']`).value
	let totalCart = document.querySelector(`[data-cart-total='${idCart}']`) 
	totalCart.textContent = costCart * quantityCart
}

