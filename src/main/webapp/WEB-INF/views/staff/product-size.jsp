<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<div class="p-5 bg-white">
	<h3 class="border-bottom fs-5 pb-3">Edit product size</h3>
	
	<form class="mt-4 row gy-4" style="margin-top:0 !important">
	

	
			<div class="col-12 col-md-6 container-input">
			   <label for="name-product" class="form-label">tên</label>
			 <input value="${product.getName()}" readonly class="ct-input" id="name-product"> 
			</div>
			
			<div class="mt-4 col-12 col-md-6 container-input">
					<label for="exampleFormControlTextarea1" class="form-label">loại</label>
					<input value="${product.category.name}" readonly class="ct-input">
			</div>
			
			<div class="mt-4 col-12 col-md-6 container-input">
					<label for="exampleFormControlTextarea1" class="form-label">màu</label>
					<input value="red" readonly class="ct-input"/>
			</div>
				
			<div class="mt-4 col-12 col-md-6 container-input"> 
				<label for="cost-product" class="form-label">giá tiền</label>
			 	<input value="${product.cost}" readonly class="ct-input" id="cost-product">	
			</div>


			<div class="col-12">
				<label class="form-label">status</label>
					<input readonly class="ct-input"/>
			</div>
			
	
			
		
			<div class="col-12 mt-4 container-input">
				<label for="description-product" class="form-label">Mô tả</label>
	  			<textarea readonly class="ct-input" id="description-product" rows="3">
	  				${product.description}
				</textarea>
			</div>
			
			<div>
			
			</div>
	</form>
	
	 <form method='POST' class="row">
		 <div class="col-12 mt-2 col-md-6">
				
				<div class="row gx-3 gy-4">
				
				 <span style="font-size: 14px" class="form-label">Số lượng</span>
				 
	
				 	
				 	<c:forEach items="${sizes}" var="size">
		         		<div class="col-3 col-md-4 col-xl-3">
					 		<div class="">
					 			<label style="font-size: 14px;margin-bottom:19px">
					 				${ size.getNameSize() }
					 			</label>
							  	<input name="${size.getIdSize()}" type="number" class="ct-input" min="0">
							</div>
					 	</div>
	      			</c:forEach>
				 </div>
				 </div>
				 
				<button type="submit">
					submit 
				</button>
	 	
	 </form>
	 
	 
	 
	
</div>
<style>
	.ct-input {
		width: 100%;  
		padding: 12px; 
		border: 1px solid #ccc;
		font-size: 14px;
   	    background-color: #f7f7f7;
	}
	.ct-input:focus {
		outline: 1px solid #87b106;
	}
	
	.ct-select { 
		border: 1px solid #ccc;
		font-size: 14px;
		background-color: #f7f7f7;
		padding: 12px;
	}
	
	.container-input {
		display: flex;
		flex-direction: column;
		gap: 12px;
		margin-bottom: 14px;
		
	}
	.container-input > label {
		 font-size: 14px;
	}
</style>