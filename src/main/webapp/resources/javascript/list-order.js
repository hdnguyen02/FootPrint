/**
 * 
 */



 let curentLiActive = document.querySelector(`[data-order-type="pending"]`).parentNode

 
 let ordersType = document.querySelectorAll("[data-order-type]")
 
 let allOrderList = document.querySelectorAll("[data-order]")
allOrderList.forEach(orderList => { orderList.style.display = 'none' })
		 
document.querySelectorAll(`[data-order-pending]`).forEach(elm => { elm.style.display = 'table-row' })
	

 ordersType.forEach(orderType  => { 
	 orderType.addEventListener("click",event => { 
		 const target = event.target  
		 let typeOrder = target.dataset.orderType
		 
		 let onShows = document.querySelectorAll(`[data-order-${typeOrder}]`)
		 
		 if (onShows.length == 0) return; // không có loại đơn hàng được chọn
		 
		 curentLiActive.classList.remove("tag-active")
		 target.parentNode.classList.add("tag-active")
		 curentLiActive = target.parentNode
		 allOrderList.forEach( orderList => { orderList.style.display = 'none' })
		 onShows.forEach( elm => { elm.style.display = 'table-row' })
		
		  
		 
	 })
 })