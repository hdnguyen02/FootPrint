

const containerDetailImport = document.querySelector("[data-detail-import]")  
// tạo ra 1 cái mảng lưu trữ những id đã có sẵn 
let existProduct = new Set()

// Lấy ngày hiện tại
var currentDate = new Date();

// Lấy giá trị của ngày, tháng, năm
var day = currentDate.getDate();
var month = currentDate.getMonth() + 1; // Tháng bắt đầu từ 0 (0 - 11)
var year = currentDate.getFullYear();

// Định dạng lại chuỗi ngày tháng năm
var formattedDate = year + '-' + month.toString().padStart(2, '0') + '-' + day.toString().padStart(2, '0');

// Gán giá trị cho trường ngày
document.getElementById('date').value = formattedDate;


document.querySelector("[data-submit]").addEventListener("click",event => { 

	let productsImport = document.querySelectorAll("input[name='products-import']:checked"); 
	console.log(productsImport.length); 
	 
	 productsImport.forEach(productImport => { 
		 	if (existProduct.has(productImport.value)) return  
		 	existProduct.add(productImport.value)
		 	let nodeProduct = document.querySelector(`[data-product='${productImport.value}']`).cloneNode(true); 
			nodeProduct.removeAttribute("data-product"); 
			let inputNode = `<div class="col-1">
						<input name="products-import-checked" checked value="${productImport.value}" type="checkbox" class="d-none">
	        			<input name="quantity-${productImport.value}" min="1" required type="number" class="ct-input" style="height: 32px">
	        		</div>
	        		<div class="col-2">
						<input name="cost-${productImport.value}" min="0" required type="number" class="ct-input" style="height: 32px">
	        		</div>
	        		`
	     
			nodeProduct.removeChild(nodeProduct.lastElementChild)
			nodeProduct.innerHTML += inputNode
			containerDetailImport.append(nodeProduct)
			
			
	 })
	
	
	
	
})