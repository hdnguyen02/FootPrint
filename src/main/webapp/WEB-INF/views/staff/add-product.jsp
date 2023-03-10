<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<div class="container-fluid p-5 bg-white shadow-lg">

		<div class="d-flex">
			<span class="me-2"><i class="bi bi-bookmarks-fill fs-3"></i></span>
			<h2 class="mb-0">Add product</h2>
		</div>
	
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
	
		<div class="col-12 col-md-6 mt-2">
			<div>
			   <label for="name-product" class="form-label">Tên giày</label>
			  <form:input path="name" class="form-control" id="name-product"/> 
			</div>
		
			<div class="mt-4">
				<label for="description-product" class="form-label">Mô tả</label>
	  			<form:textarea path="description" class="form-control" id="description-product" rows="3"/>
			</div>
			
			<div class="row"> 
				<div class="mt-4 col-12 col-md-6">
					<label for="exampleFormControlTextarea1" class="form-label">Loại giày</label>
					<form:select path="category.idCategory" items="${categories}" itemLabel="name" itemValue="idCategory" class="form-select"></form:select>
				</div>
				
				<div class="mt-4 col-12 col-md-6">
					<label for="exampleFormControlTextarea1" class="form-label">Màu</label>
					<select class="form-select" aria-label="Default select example">
					  <option selected>Open this select menu</option>
					  <option value="1">Xanh</option>
					  <option value="2">Đỏ</option>
					  <option value="3">Vàng</option>
					</select>
				</div>
			
			</div>
			
			<div class="mt-4"> 
				<label for="cost-product" class="form-label">Giá tiền</label>
			   <form:input path="cost" type="number" class="form-control" id="cost-product"/>
			</div>
		
			<div class="row mt-4">
				<div class="col-6">
					<label for="image-product" class="form-label">image</label>
					<input type="file" name="imageProduct" id="image-product">
				</div>
				<!-- <div class="col-6">
					<label for="exampleFormControlInput1" class="form-label">thumbnail images</label>
					<input type="file" multiple id="exampleFormControlInput1">
				</div> -->
			</div>
		 
		</div>
		
		<div class="col-12 col-md-6 mt-2">
			
			<div class="row gx-3 gy-5">
			
			 <label for="exampleFormControlInput1" class="form-label">Số lượng</label>
			 

			 	
			 	<c:forEach var = "i" begin = "35" end = "46">
         			
         			
	         		<div class="col-3 col-md-4 col-xl-3">
				 		<div class="form-floating">
						  <input type="number" class="form-control" min="0" id="floatingInput" placeholder="size-${i}">
						  <label for="floatingInput"><c:out value = "size ${i}"/></label>
						</div>
				 	</div>
      			</c:forEach>
			 </div>
		</div>
		
	
		<div class="col-12">
			<button style="background-color:#4e73df !important" type="submit" class="btn btn-success btn-block w-100 fw-bolder">Thêm</button>
		</div>
	

	</form:form>
	


	
	
	
</div>