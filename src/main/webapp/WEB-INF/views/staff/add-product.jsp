<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<div class="container-fluid p-5 bg-white shadow-lg">
	<h3 class="border-bottom fs-5 pb-3">Add product</h3>
	
	<c:if test="${ not empty result }">
			<c:choose>
			<c:when test="${result == true }">
				<div class="alert alert-success alert-dismissible shadow mt-4" role="alert">
					 <div>Thêm thành công</div>
					 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-danger alert-dismissible shadow mt-4" style="border-radius: none" role="alert">
					 <div>Thêm thất bại</div>
					 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:otherwise>
		</c:choose>
	
	</c:if>
	<form:form class="row mt-4 gy-4" style="margin-top:0 !important" method="POST" modelAttribute="product" enctype="multipart/form-data">
	
		<div class="col-12 col-md-6 container-input"> 
				<label for="id-product" class="form-label">mã sản phẩm</label>
				<form:input path="idProduct" required="required" class="ct-input" id="id-product"/> 
		</div>	
	
		<div class="col-12 col-md-6 container-input"> 
			<label for="name-product" class="form-label">tên</label>
			<form:input path="name" required="required" class="ct-input" id="name-product"/> 
		</div>	
			
	
		<div class="col-12 col-md-6 container-input">
			<label for="exampleFormControlTextarea1" class="form-label">loại</label>
			<form:select path="category.idCategory" items="${categories}" itemLabel="name" itemValue="idCategory" class="ct-input"></form:select>
		</div>
	
		
		
		<div class="col-12 col-md-6 container-input">
			<label class="form-label">màu</label>
			<form:select path="color" class= "ct-input">
				<option value="GREEN">Green</option>
				<option value="RED">Red</option>
				<option value="ORANGE">Orange</option>
				<option value="PINK">Pink</option>
				<option value="WHITE">White</option>
				<option value="Black">Black</option>
				
			</form:select>
		</div>
			
		<div class="mt-4 col-12 col-md-6 container-input"> 
				<label for="cost-product" class="form-label">giá tiền</label>
			 	<form:input path="cost" min="1" required="required" type="number" class="ct-input" id="cost-product"/>	
		</div>
			
			
		<div class="col-12 col-md-6">
			<div class="row">
				<div class="col-6 container-input">
					<label for="image-product" class="form-label">image</label>
					<input required type="file" class="" accept="image/*" name="imageProduct" id="image-product">
				</div>
				<div class="col-6 container-input">
					<label for="exampleFormControlInput1" class="form-label">thumbnail</label>
					<input required type="file" class="" accept="image/*" name="imageThumbnails" multiple id="exampleFormControlInput1">
				</div> 
			</div>
		</div>
		
		<div class="col-12 col-md-6 container-input">
			<label class="form-label">status</label>
			<form:select path="disable" class= "ct-input">
				<option value="false">Active</option>
				<option value="true">Disable</option>
				
			</form:select>
		</div>
		
		<div class="col-12 col-md-6 container-input">
			<label class="form-label">Size</label>
			<form:select path="size" class= "ct-input">
				<option value="size37">Size 37</option>
				<option value="size38">Size 38</option>
				<option value="size39">Size 39</option>
				<option value="size40">Size 40</option>
			</form:select>
		</div>
 	
		<div class="col-12 mt-4 container-input">
			<label for="description-product" class="form-label">Mô tả</label>
	  		<form:textarea path="description" required="required" class="ct-input" id="description-product" rows="3"/>
		</div>
		
	
		<div class="w-100 mt-4">
			<button type="submit"
				class="btn btn-primary rounded-0 border-0 w-100"
				style="background-color: #87b106 !important">Save product
			</button>
		</div>
	
	</form:form>
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