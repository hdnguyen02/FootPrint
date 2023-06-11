<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<form method="POST" onSubmit="handleSubmit(event)" class="container-fluid p-5 bg-white shadow-lg" style="min-height: 100vh">
	<div class="row align-items-center mb-5">
		<h3 class="fs-5 col-5 mb-0">Danh sác phiếu nhập hàng</h3> 
		<div class="row col-5">
			<div class="col-6"> 
				<span>Từ :</span> 
				<input name="from" value="${from}" type="date" class=""/>
			</div>
			<div class="col-6"> 
				<span>Đến :</span> 
				<input name="to" value="${to}" type="date" class=""/>
			</div>
		</div>

		<div class="col-2">
			<button class="btn btn-primary w-100">Lọc</button>
		</div>
	</div>
	

	<div class="mt-4">
		
		
		<c:if test="${imports.size()==0}">
	<div class="container py-5" style="min-height: 80vh">
			<div class="col-sm-12 empty-cart-cls text-center">
				<img src="https://i.imgur.com/dCdflKN.png" width="130" height="130"
					class="img-fluid mb-4 mr-3">
				<h3>
					<strong>Không tồn tại phiếu nhập</strong>
				</h3>
			</div>
		</div>
	</c:if>
	<c:if test="${imports.size()!=0}">
	<div class="row text-uppercase text-center mb-3" style="font-size: 13px">
			<div class="col-1">
				<p class="fw-bolder" style="color: #999999">Mã</p>
			</div>
			<div class="col-2">
				<p class="fw-bolder" style="color: #999999">Date</p>
			</div>
			<div class="col-4">
				<p class="fw-bolder" style="color: #999999">Nhà Cung cấp</p>
			</div>

		<!-- 	<div class="col-2">
				<p class="fw-bolder" style="color: #999999">Mã phiếu xuất</p>
			</div> -->
			<div class="col-4">
				<p class="fw-bolder" style="color: #999999">Nhân viên tạo thanh toán</p>
			</div>
	

		</div>
		<c:forEach items="${imports}" var="importEntity">
			<div class="row mt-3 align-items-center text-center">
				<div class="col-1">
					<p>${importEntity.getIdImport()}</p>
				</div>
				<div class="col-2">
					<c:set var="myDate" value="${importEntity.getDate()}" />
					<p>
						<fmt:formatDate value="${myDate}" pattern="dd-MM-yyyy"
							var="formattedDate" />
						${formattedDate}
					</p>

				</div>
		

				<div class="col-4">
					<p>${importEntity.getSupplier()}</p>
				</div>


				<div class="col-4">
					<p>${importEntity.getEmployee().getFirstName()} ${importEntity.getEmployee().getLastName()}</p>
				</div>

				<div class="col-1">
					<a
						style="text-decoration: underline !important; color: blue !important"
						href='<c:url value='/staff/import/detail.htm?id=${importEntity.getIdImport()}'/>'>
						Detail </a>
				</div>

			</div>
			<hr>
		</c:forEach>
		</c:if>
	</div>
</form>


<style>

p { 
 margin-bottom: 0px;
}

input { 
	outline: none;
	border: 1px solid #ccc;
	border-radius: 6px;
	height: 42px; 
	padding: 6px; 
}


</style>
