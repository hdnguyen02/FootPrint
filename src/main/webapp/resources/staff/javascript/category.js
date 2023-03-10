/*function loadPage(pageUrl) {
	$.get(pageUrl, function() {
		history.pushState(null, '', pageUrl);
		location.reload()
	});
}



// lấy ra toàn bộ list item  

const itemsChoosePage = document.querySelectorAll("[data-page]")

itemsChoosePage.forEach(itemChoosePage => { 
	itemChoosePage.addEventListener("click",event => { 
		const targetItem = event.currentTarget 
		const numberPage = +targetItem.dataset.page
		loadPage(`/FootPrint/staff/category?page=${numberPage}`)
	})
})*/