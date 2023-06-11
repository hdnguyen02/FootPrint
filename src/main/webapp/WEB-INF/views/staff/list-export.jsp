<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<form method="POST" onSubmit="handleSubmit(event)"
	class="container-fluid p-5 bg-white shadow-lg"
	style="min-height: 100vh">
	<div class="row align-items-center mb-5">
		<h3 class="fs-5 col-5 mb-0">Danh sác phiếu xuất hàng</h3>
		<div class="row col-5">
			<div class="col-6">
				<span>Từ :</span> <input name="from" value="${from}" type="date"
					class="" />
			</div>
			<div class="col-6">
				<span>Đến :</span> <input name="to" value="${to}" type="date"
					class="" />
			</div>
		</div>

		<div class="col-2">
			<button class="btn btn-primary w-100">Lọc</button>
		</div>
	</div>
	
	<c:if test="${exports.size()==0}">
	<div class="container py-5" style="min-height: 80vh">
			<div class="col-sm-12 empty-cart-cls text-center">
				<img src="https://i.imgur.com/dCdflKN.png" width="130" height="130"
					class="img-fluid mb-4 mr-3">
				<h3>
					<strong>Không tồn tại phiếu xuất</strong>
				</h3>
			</div>
		</div>
	</c:if>
	
	<c:if test="${exports.size()!=0}">
	<div class="mt-4">
		<div class="row text-uppercase text-center mb-3"
			style="font-size: 13px">
			<div class="col-1">
				<p class="fw-bolder" style="color: #999999">Mã PX</p>
			</div>
			<div class="col-1">
				<p class="fw-bolder" style="color: #999999">Mã Order</p>
			</div>
			<div class="col-2">
				<p class="fw-bolder" style="color: #999999">Date</p>
			</div>
			<div class="col-2">
				<p class="fw-bolder" style="color: #999999">Thông tin vận chuyển</p>
			</div>

			<div class="col-2">
				<p class="fw-bolder" style="color: #999999">Zip code</p>
			</div>
			<div class="col-3">
				<p class="fw-bolder" style="color: #999999">Nhân viên tạo phiếu</p>
			</div>

		</div>

		<c:forEach items="${exports}" var="export">
			<div class="row mt-3 align-items-center text-center">
				<div class="col-1">
					<p>${export.getIdExport()}</p>
				</div>
				<div class="col-1">
					<p>${export.getOrder().getIdOrder()}</p>
				</div>
				<div class="col-2">
					<c:set var="myDate" value="${export.getDate()}" />
					<p>
						<fmt:formatDate value="${myDate}" pattern="dd-MM-yyyy"
							var="formattedDate" />
						${formattedDate}
					</p>

				</div>


				<div class="col-2">
					<p>${export.getInfoShipment()}</p>
				</div>


				<div class="col-2">
					<p>${export.getZipCode()}</p>
				</div>
				<div class="col-3">
					<p>${export.getEmployee().getFirstName()}
						${export.getEmployee().getLastName()}</p>
				</div>

				<div class="col-1">
					<a
						style="text-decoration: underline !important; color: blue !important"
						href='<c:url value='/staff/export/detail.htm?id=${export.getIdExport()}'/>'>
						Detail </a>
				</div>

			</div>
			<hr>
		</c:forEach>
		
	
	</div>
		</c:if>
</form>


<script>
	function handleSubmit(event) {
		if (fromEl.value == "" || toEl.value == "") {
			event.preventDefault()
			return;
		}
	}
</script>


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
