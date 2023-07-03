<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script defer="defer" src='<c:url value="/resources/javascript/edit-product.js"/>'></script>

<div class="container-fluid p-5 bg-white shadow-lg"
	style="min-height: 100vh">
	<h3 class="fs-5 pb-3">Cập nhập sản phẩm</h3>
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
				<%-- <input name="id-product" hidden="true" value="${product.getIdProduct()}"/> 
				<input name="url-product" hidden="true" value="${product.getImageName()}"/>
				<input name="create-product" hidden="true" value="${product.getCreateAt()}"/>  --%>
				<input hidden="true" name="status-product" value="${product.getDisable()}">
				<div class="d-flex flex-column gap-2 justify-content-center h-100">
					<label style="font-size: 14px">Tên sản phẩm</label>
					<form:input path="name" class="ct-input" style="font-size: 18px"/>
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
							<form:select path="color.idColor" class="ct-input" items="${colors}" itemLabel="nameColor" itemValue="idColor"></form:select>
						</div>
					</div> 
					<label class="mt-2" style="font-size: 14px">Mô tả</label>
					<form:textarea class="ct-input" path="description"/>
					<p class="mt-2" style="font-size: 14px">Số lượng</p>
					<div>
						<div class="row">
							<c:forEach items="${productSizes}" var="productSize">
								<div class="col-3 col-md-2 mt-2">
									<label style="font-size: 14px; margin-bottom: 19px">${productSize.getSize().getNameSize()}</label>
									<input name="id-ps-${productSize.getIdProductSize()}" value="${productSize.getQuantity()}"
										type="number" class="ct-input" min="0">
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<button type="submit"
					class="mt-5 btn btn-primary rounded-0 border-0 w-100"
					style="background-color: #87b106 !important">Save Product
				</button>
		</form:form>
	
</div>
