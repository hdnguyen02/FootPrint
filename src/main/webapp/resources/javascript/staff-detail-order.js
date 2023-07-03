function callController(pageUrl,data) {
	$.post(pageUrl,data, function() {
		history.pushState(null, '', pageUrl);
	});
}


// kiểm tra nếu như thay đổi -> gọi controller là được 
/*
document.querySelector('[data-select-order-status]').addEventListener('change',event => {
	const target = event.target 
	let idOrder = target.dataset.idOrder
	console.log(idOrder)
	console.log(idOrder)
	
	callController(`/FootPrintstaff/order-detail/edit.htm`,{ idOrder , idOrderStatus: target.value})
})*/