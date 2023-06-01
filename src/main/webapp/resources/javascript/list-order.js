/*


// trước khi submit kiểm tra trạng thái xem. 
const fromEl = document.querySelector("[data-date-from]") 

/*const toEl = document.querySelector("[data-date-to]") 


const statusEl = document.querySelector("[data-status]")

let currentDate = new Date();
let dateString = currentDate.toISOString().slice(0, 10);
fromEl.value = dateString 
toEl.value = dateString 
statusEl.value = "not-export"*/





function handleSubmit(event) { 
	if (fromEl.value == "" || toEl.value == ""){ 
		event.preventDefault()
		return; 
	}
	

	
}