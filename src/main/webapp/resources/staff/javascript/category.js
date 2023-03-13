

const editsButton = document.querySelectorAll("[data-edit-category]")
const deletesButton = document.querySelectorAll("[data-delete-category]")

editsButton.forEach(editButton => {
	editButton.addEventListener("click",event => {
		const idCategory = event.currentTarget.dataset.idCategory 
		// edit-name-category
		
		
		const nameCategory = document.querySelector(`[data-name-category="${idCategory}"]`).innerText
		const statusCategory = document.querySelector(`[data-disable-category="${idCategory}"`).innerText; 
	
		
		// gán giá trị vào thẻ form input
		const inputName = document.querySelector("#edit-name-category")
		inputName.value = nameCategory
		
		// gán giá trị vào select
		
		const selectDisable = document.querySelector("#edit-disable-category")
		if (statusCategory == "active") {
			selectDisable.value = "0" 
		}
		else {
			selectDisable.value = "1"
		}
	
		
		const tagInfo = document.querySelector(`[data-id-category="${idCategory}"]`)
		
		const idCategoryInputShow = document.querySelector('#edit-id-category-show')
		const idCategoryInputHidden = document.querySelector('#edit-id-category-hidden')
		idCategoryInputShow.value = idCategory 
		idCategoryInputHidden.value = idCategory
	})
})


