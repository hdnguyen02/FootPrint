
document.querySelectorAll("[data-cart-total]").forEach(cartTotalMonney => { 
	const idProductSize = cartTotalMonney.dataset.cartTotal
	let quantity = +getCookie(`cart${idProductSize}`)
	let costProduct = +document.querySelector(`[data-cart-cost='${idProductSize}']`).textContent 
	cartTotalMonney.innerHTML = quantity * costProduct
	
})


function getCookie(cookieName) {
  const name = cookieName + "=";
  const decodedCookie = decodeURIComponent(document.cookie);
  const cookieArray = decodedCookie.split(";");

  for (let i = 0; i < cookieArray.length; i++) {
    let cookie = cookieArray[i];
    while (cookie.charAt(0) === " ") {
      cookie = cookie.substring(1);
    }
    if (cookie.indexOf(name) === 0) {
      return cookie.substring(name.length, cookie.length);
    }
  }
  return "";
}

function setCookie(cookieName, cookieValue, expiresInDays) {
  const date = new Date();
  date.setTime(date.getTime() + (expiresInDays * 24 * 60 * 60 * 1000));
  const expires = "expires=" + date.toUTCString();
  document.cookie = cookieName + "=" + cookieValue + "; " + expires + "; path=/FootPrint;";
}

// Hàm xóa cookie
function deleteCookie(cookieName) {
  document.cookie = cookieName + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/FootPrint;";
}


function handleDeleteCart(event) { 
	// lấy ra thằng muốn xóa 
	const target = event.currentTarget
	let idProductSize = target.dataset.idProductSize 
	let wraperCart = document.querySelector(`[data-cart-wrapper='${idProductSize}']`)
	let hrCart = document.querySelector(`[data-cart-hr='${idProductSize}']`)
	wraperCart.remove()
	hrCart.remove()
	deleteCookie(`cart${idProductSize}`)
} 

function handleAddQuantityCart(event) { 
	// lấy ra thằng muốn xóa 
	const target = event.currentTarget
	let idProductSize = target.dataset.idProductSize 
	let quantity = +getCookie(`cart${idProductSize}`)
	++document.querySelector(`[data-cart-quantity='${idProductSize}']`).value 
	computedTotalMonney()
	computedTotal(idProductSize)
	setCookie(`cart${idProductSize}`,++quantity,365) 
} 

function handleSubtractionQuantityCart(event) { 
	const target = event.currentTarget
	let idProductSize = target.dataset.idProductSize 
	
	let quantity = +getCookie(`cart${idProductSize}`)

	console.log(`cart${idProductSize}`)
	if (quantity != 0) {
		--document.querySelector(`[data-cart-quantity='${idProductSize}']`).value
		computedTotal(idProductSize)
		computedTotalMonney()
		setCookie(`cart${idProductSize}`,--quantity,365) 
	}

}

function computedTotal(idProductSize){
	let costCart = +document.querySelector(`[data-cart-cost='${idProductSize}']`).textContent 
	let quantityCart = +document.querySelector(`[data-cart-quantity='${idProductSize}']`).value
	let totalCart = document.querySelector(`[data-cart-total='${idProductSize}']`) 
	totalCart.textContent = costCart * quantityCart
}

// click chọn item mua hàng 

function computedTotalMonney() {  
	let total = 0;
	document.querySelectorAll("input[name='items-checkout']").forEach(
		checkoutCart => { 
		if(checkoutCart.checked) {
			const idProductSize = checkoutCart.value
			let subMonney = +document.querySelector(`[data-cart-total='${idProductSize}']`).textContent
			total += subMonney
		}
	})
	
	
	document.querySelector("[data-subtotal]").textContent = total
	
}

	

			







