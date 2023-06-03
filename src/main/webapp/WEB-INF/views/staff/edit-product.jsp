<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script defer="defer" src='<c:url value="/resources/javascript/edit-product.js"/>'></script>

<div class="container-fluid p-5 bg-white shadow-lg"
	style="min-height: 100vh">
	<h3 class="fs-5 pb-3">Hiệu chỉnh sản phẩm</h3>
	<c:if test="${ not empty result }">
			<c:choose>
			<c:when test="${result == true }">
				<div class="alert alert-success alert-dismissible shadow mt-4" role="alert">
					 <div>Cập nhập thành công</div>
					 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-danger alert-dismissible shadow mt-4" style="border-radius: none" role="alert">
					 <div>Cập nhập thất bại</div>
					 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:otherwise>
		</c:choose>
	
	</c:if>
	<form:form method="POST" modelAttribute="product"> 
				<form:input hidden="true" path="idProduct"/> 
				<form:input hidden="true" path="image" />
				<form:input hidden="true" path="quantity" />
				<div class="d-flex flex-column gap-2 justify-content-center h-100">
					<label style="font-size: 14px">Tên sản phẩm</label>
					<form:input path="name" class="ct-input" style="font-size: 18px"/>
					<label style="font-size: 14px">Size</label>
					<form:select path="size" class= "ct-input">
						<option value="size 37">Size 37</option>
						<option value="size 38">Size 38</option>
						<option value="size 39">Size 39</option>
						<option value="size 40">Size 40</option>
					</form:select>
					 <div class="row mt-2"> 
						<div class="col-6"> 
							<label class="mt-2" style="font-size: 14px">Giá bán</label>
							<form:input path="cost" class="ct-input"/>
						</div>
						<div class="col-6">
							<label class="mt-2" style="font-s	ize: 14px">Loại</label>
							<form:select path="category.idCategory" class="ct-input" items="${categorys}" itemLabel="name" itemValue="idCategory"></form:select>
						</div>
					</div> 
					
					
					<div class="row mt-2"> 
						<div class="col-6"> 
							<label class="mt-2" style="font-size: 14px">Trạng thái</label>
							<form:select path="disable" class="ct-input">
								<option value="true">Disable</option>
								<option value="false">Active</option>
							</form:select>
						</div>
						<div class="col-6">
							<label class="mt-2" style="font-size: 14px">Màu</label>
							<form:select path="color" class= "ct-input">
								<option value="Green">Green</option>
								<option value="Red">Red</option>
								<option value="Orange">Orange</option>
								<option value="Pink">Pink</option>
								<option value="White">White</option>
								<option value="Black">Black</option>
				
						</form:select>
						</div>
					</div> 
					<label class="mt-2" style="font-size: 14px">Mô tả</label>
					<form:textarea class="ct-input" path="description"/>
					
				</div>
				<button type="submit"
					class="mt-5 btn btn-primary rounded-0 border-0 w-100"
					style="background-color: #87b106 !important">Lưu sản phẩm
				</button>
		</form:form>
	
</div>
