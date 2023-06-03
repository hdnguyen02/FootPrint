<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script defer="defer"
	src='<c:url value="/resources/javascript/export-product.js"/>'></script>

<div class="container-fluid p-5 bg-white shadow-lg">
	<h3 class="border-bottom fs-5 pb-3">Chi tiết phiếu xuất</h3>
	<div class="row gx-4 gy-4 mt-4">
		<div class="col-12 col-md-3 container-input">
			<label for="id-import" class="fw-bold">Mã phiếu xuất</label> <span
				class="fs-5">${export.getIdExport()}</span>
		</div>

		<div class="col-12 col-md-3 container-input">
			<label for="id-import" class="fw-bold">Mã đơn đặt hàng</label> <span
				class="fs-5">${export.getOrder().getIdOrder()}</span>
		</div>




		<div class="col-12 col-md-3 container-input">

			<c:set var="myDate" value="${export.getDate()}" />
			<p>
				<fmt:formatDate value="${myDate}" pattern="dd-MM-yyyy"
					var="formattedDate" />

			</p>
			<label for="date" class="fw-bold">Ngày xuất hàng</label> <span
				class="fs-5">${formattedDate}</span>
		</div>
		<div class="col-12 col-md-3 container-input">
			<label class="fw-bold">Đơn vị vận chuyển</label> <span class="fs-5">${export.getInfoShipment()}</span>
		</div>
		<div class="col-12 col-md-3 container-input">
			<label class="fw-bold">Mã vận chuyển</label> <span class="fs-5">${export.getZipCode()}</span>
		</div>
		<div class="col-12 col-md-3 container-input">
			<label class="fw-bold">Nhân viên tạo phiếu</label> <span class="fs-5">${export.getEmployee().getFirstName()}
				${export.getEmployee().getLastName()}</span>
		</div>


		<!-- <div>Chi tiết phiếu nhập</div> -->
		<div class="container-product row gx-3 mt-5">
			<div class="col-1" style="">
				<p class="ms-1" style="line-height: 32px">Mã SP</p>
			</div>
			<div class="col-4">
				<p class="fw-bold" style="line-height: 32px">Tên sản phẩm</p>
			</div>
			<div class="col-1">
				<p class="fw-bold" class="ms-1" style="line-height: 32px">Size</p>
			</div>
			<div class="col-1">
				<p class="fw-bold" class="ms-1" style="line-height: 32px">Tồn
					kho</p>
			</div>
			<div class="col-1">
				<p class="fw-bold" class="ms-1" style="line-height: 32px">Màu</p>
			</div>
			<div class="col-1">
				<p class="fw-bold" class="ms-1" style="line-height: 32px">Disable</p>
			</div>
			<div class="col-1">
				<p class="fw-bold" class="ms-2" style="line-height: 32px">SL
					xuất</p>
			</div>
			<div class="col-2">
				<p class="fw-bold" class="ms-2" style="line-height: 32px">Giá
					xuất</p>
			</div>
		</div>
		<hr>

		<div data-detail-import class="col-12 container-input">

			<c:forEach var="export" items="${export.getExportDetails()}">
				<div class="container-product row gx-3 mt-3">
					<div class="col-1">
						<p style="line-height: 32px">${export.getProduct().getIdProduct()}</p>
					</div>
					<div class="col-4">
						<p style="line-height: 32px">${export.getProduct().getName()}</p>
					</div>


					<div class="col-1">
						<p style="line-height: 32px">${export.getProduct().getSize()}</p>
					</div>
					<div class="col-1">
						<p style="line-height: 32px">${export.getProduct().getQuantity()}</p>
					</div>

					<div class="col-1">
						<p style="line-height: 32px">${export.getProduct().getColor()}</p>
					</div>
					<div class="col-1">
						<p style="line-height: 32px">${export.getProduct().getDisable()}</p>
					</div>
					<div class="col-1">
						<p class="ms-2" style="line-height: 32px">${export.getQuantity()}</p>
					</div>
					<div class="col-2">
						<p class="ms-2" style="line-height: 32px">${export.getCost()}</p>
					</div>
				</div>
				<hr>
			</c:forEach>

		</div>





	</div>









</div>

<style>
p {
	margin-bottom: 0px;
}
</style>








