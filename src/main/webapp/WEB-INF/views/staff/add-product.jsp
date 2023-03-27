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
				<div class="alert alert-danger alert-dismissible shadow mt-4" role="alert">
					 <div>Thêm thất bại</div>
					 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:otherwise>
			
		</c:choose>
	
	</c:if>
	<form:form class="mt-4 row gy-4" style="margin-top:0 !important" method="POST" modelAttribute="product" enctype="multipart/form-data">
	
<!-- 		<div class="col-12 mt-2">  -->
	
			<div class="col-12 col-md-6 container-input">
			   <label for="name-product" class="form-label">tên</label>
			  <form:input path="name" required="required" class="ct-input" id="name-product"/> 
			</div>
			
			<div class="mt-4 col-12 col-md-6 container-input">
					<label for="exampleFormControlTextarea1" class="form-label">loại</label>
					<form:select path="category.idCategory" items="${categories}" itemLabel="name" itemValue="idCategory" class="ct-input"></form:select>
			</div>
			
			<div class="mt-4 col-12 col-md-6 container-input">
					<label for="exampleFormControlTextarea1" class="form-label">màu</label>
					<input class="ct-input"/>
			</div>
				
			<div class="mt-4 col-12 col-md-6 container-input"> 
				<label for="cost-product" class="form-label">giá tiền</label>
			 	<form:input path="cost" min="1" required="required" type="number" class="ct-input" id="cost-product"/>	
			</div>
		
		<!-- 	<div class="col-12 col-md-6">
				<div class="row"> -->
				<div class="col-6 container-input">
					<label for="image-product" class="form-label">image</label>
					<input required type="file" style="border-radius: 0px !important" class="form-control" accept="image/*" name="imageProduct" id="image-product">
				</div>
				<div class="col-6 container-input">
					<label for="exampleFormControlInput1" class="form-label">thumbnail images</label>
					<input required type="file" style="border-radius: 0px !important" class="form-control" accept="image/*" name="imageThumbnails" multiple id="exampleFormControlInput1">
				</div> 
		<!-- 		</div>
			</div> -->
			
			<div class="col-12">
				<label class="form-label">status</label>
					<input class="ct-input"/>
			</div>
			
	
			
		
			<div class="col-12 mt-4 container-input">
				<label for="description-product" class="form-label">Mô tả</label>
	  			<form:textarea path="description" required="required" class="ct-input" id="description-product" rows="3"/>
			</div>
		 
<!-- 		</div> -->
		
		<%-- <div class="col-12 mt-2 col-md-6">
			
			<div class="row gx-3 gy-4">
			
			 <span style="font-size: 14px" class="form-label">Số lượng</span>
			 

			 	
			 	<c:forEach items="${sizes}" var="size">
	         		<div class="col-3 col-md-4 col-xl-3">
				 		<div class="">
				 			<label style="font-size: 14px;margin-bottom:19px">
				 				${ size.getNameSize() }
				 			</label>
						  	<input type="number" class="ct-input" min="0">
						</div>
				 	</div>
      			</c:forEach>
			 </div>
		
		</div> --%>
		
	
		<div class="d-flex justify-content-end mt-4">
			<button type="submit"
				class="btn btn-primary rounded-0 border-0 px-4 py-2"
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