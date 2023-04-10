/**
 * 
 */



 let curentLiActive = document.querySelector(`[data-order-type="pending"]`).parentNode

 
 let ordersType = document.querySelectorAll("[data-order-type]")
 
 let allOrderList = document.querySelectorAll("[data-order]")
		 allOrderList.forEach(orderList => {
			 orderList.style.display = 'none'
		 })
		 
		document.querySelectorAll(`[data-order-pending]`).forEach(elm => {
			elm.style.display = 'table-row'
		})
 
 ordersType.forEach(orderType  => { 
	 orderType.addEventListener("click",event => { 
		 const target = event.target  
		 let typeOrder = target.dataset.orderType
		 
		 
		 
		 curentLiActive.classList.remove("tag-active")
		 target.parentNode.classList.add("tag-active")
		 curentLiActive = target.parentNode
		 
		 
		 let onShow = document.querySelectorAll(`[data-order-${typeOrder}]`)
		 
		 if (onShow.length != 0) {
			 allOrderList.forEach(orderList => {
			 orderList.style.display = 'none'
		 	 })
			 onShow.forEach(elm => {
				 elm.style.display = 'table-row'
			 })
		 }
		 
		 
		 
		 
		 
		 
	 })
 })