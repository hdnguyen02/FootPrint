<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script defer="defer" src='<c:url value="/resources/javascript/export-product.js"/>'></script>

<form method="post" class="container-fluid p-5 bg-white shadow-lg">
	<h3 class="border-bottom fs-5 pb-3">Tạo Phiếu Xuất hàng</h3>

	<div class="row gx-4 gy-4 mt-4">
		<div class="col-12 col-md-6 container-input">
			<label for="id-export" class="form-label">Mã đơn nhập hàng</label> <input
				name="id-export" type="text" required class="ct-input"
				id="id-export" />
		</div>
		<div class="col-12 col-md-6 container-input">
			<label for="date" class="form-label">Ngày xuất hàng</label> <input
				name="date" type="date" required class="ct-input"
				id="date" />
		</div>
		<div class="col-12 col-md-12 container-input">
			<label for="info-shipment" class="form-label">Thông tin đơn
				vị vận chuyển</label>
			<textarea name="info-shipment" required class="ct-input"
				id="info-shipment"></textarea>
		</div>
		<div class="col-12 col-md-6 container-input">
			<label for="zip-code" class="form-label">Mã vận chuyển</label> <input
				name="zip-code" type="text" required class="ct-input"
				id="zip-code" />
		</div>	
		
		<input name="id-order" type="number" class="d-none" />


		<div class="col-12 col-md-6 container-input">
			<label for="id-employee" class="form-label">Nhân viên tạo đơn nhập
				hàng</label> <input name="id-employee" value="1" type="text"
				readonly="readonly" class="ct-input" id="id-employee" />
		</div>
		



		<div class="col-4 col-md-6 container-input">
			<button type="button" class="btn btn-primary" data-bs-toggle="modal"
				data-bs-target="#exampleModal" data-bs-whatever="@mdo">Chọn đơn đơn hàng</button>
		</div>

		<div data-detail-import class="col-12 container-input"></div>



	</div>

	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5">Đơn đặt hàng chưa có phiếu xuất</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="mt-4">
						<div class="row text-uppercase text-center mb-3"
							style="font-size: 13px">
							<div class="col-1">
								<p class="fw-bolder" style="color: #999999">#</p>
							</div>
							<div class="col-2">
								<p class="fw-bolder" style="color: #999999">Date</p>
							</div>
							<div class="col-2">
								<p class="fw-bolder" style="color: #999999">Phone</p>
							</div>

							<div class="col-4">
								<p class="fw-bolder" style="color: #999999">Adress</p>
							</div>


							<div class="col-2">
								<p class="fw-bolder" style="color: #999999">Total</p>
							</div>

						</div>	
						</div>

						<c:forEach items="${orders}" var="order">
							<div class="row mt-3 align-items-center text-center">
								<div class="col-1">
									<a
										style="text-decoration: underline !important; color: blue !important"
										href='<c:url value='/staff/order/detail.htm?id=${order.getIdOrder()}'/>'>
										Detail </a>
								</div>
								<div class="col-2">
									<c:set var="myDate" value="${order.getDate()}" />
									<p>
										<fmt:formatDate value="${myDate}" pattern="dd-MM-yyyy"
											var="formattedDate" />
										${formattedDate}
									</p>
								</div>
								<div class="col-2">
									<p>${order.getPhone()}</p>
								</div>

								<div class="col-4">
									<p>${order.getAddress()}</p>
								</div>

								<div class="col-2">
									<p>$${order.getTotalMonney()}</p>
								</div>

								<div class="col-1">
									<button onclick="handleSubmit(event)" data-id-order="${order.getIdOrder()}" type="submit" class="btn btn-success">Chọn</button>
								</div>
							</div>
							<hr>
							
							
						</c:forEach>
					</div>
				</div>
			</div>

	</div>
</form>

<style>
p {
	margin-bottom: 0px;
}
</style>








