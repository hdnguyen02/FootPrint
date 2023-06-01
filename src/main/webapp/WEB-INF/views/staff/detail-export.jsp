<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script defer="defer"
	src='<c:url value="/resources/javascript/export-product.js"/>'></script>

<form method="post" action="create-import.htm" class="container-fluid p-5 bg-white shadow-lg">
	<h3 class="border-bottom fs-5 pb-3">Tạo Phiếu Xuất hàng</h3>
	<div class="row gx-4 gy-4 mt-4">
		<div class="col-12 col-md-6 container-input">
			<label for="id-export" class="form-label">Mã đơn nhập hàng</label> <input
				name="id-export" value='${idExport}' type="text" required class="ct-input"
				id="id-export" />
		</div>
		<div class="col-12 col-md-6 container-input">
			<label for="date" class="form-label">Ngày xuất hàng</label> <input
			value='${date}'	name="date" type="date" required class="ct-input" id="date" />
		</div>
		<div class="col-12 col-md-12 container-input">
			<label for="info-shipment" class="form-label">Thông tin đơn
				vị vận chuyển</label>
			<textarea name="info-shipment" required class="ct-input"
				id="info-shipment">${infoShipment}</textarea>
		</div>
		<div class="col-12 col-md-6 container-input">
			<label for="zip-code" class="form-label">Mã vận chuyển</label> <input value='${zipCode}'
				name="zip-code" type="text" required class="ct-input" id="zip-code" />
		</div>

		<input name="id-order" value="${idOrder}" type="number" class="d-none" />


		<div class="col-12 col-md-6 container-input">
			<label for="id-employee" class="form-label">Nhân viên tạo đơn 
				nhập hàng</label> <input value="${idEmployee}" name="id-employee" value="1" type="text"
				readonly="readonly" class="ct-input" id="id-employee" />
		</div>

		<div class="col-12 col-md-6 container-input">
			<div class="px-4" style="background-color: #efefef">
				<p class="py-3 border-bottom border-bottom-1"
				style="font-weight: 500">Thông tin đơn hàng</p>
				<p class="my-2"><span class="fw-bold">Fullname </span>: ${order.getFirstName()}${order.getLastName()}</p>
				<p class="mb-2"><span class="fw-bold">Phone </span>: ${order.getPhone()}</p>
				<p class="mb-2"><span class="fw-bold">Email </span>: ${order.getEmail()}</p>
				<p class="mb-2"><span class="fw-bold">Address </span>: ${order.getAddress()}</p>
				<p class="mb-2"><span class="fw-bold">Message </span>: ${order.getMessage()}</p>
			</div>
		</div>
		
		<div class="col-12 col-md-6 container-input">
			<div style="background-color: #efefef">
			<p class="px-4 py-3 border-bottom border-bottom-1"
				style="font-weight: 500">Chi tiết phiếu xuất hàng</p>



			<div class="px-4 py-4 d-flex flex-column gap-2">


				<c:forEach items="${order.getOrderDetails()}" var="order">
					<div class="d-flex justify-content-between">
						<div>
							<p>
								<span>${order.getProduct().getName()} x <span>${order.getQuantity()}</span></span>
							</p>
							<p style="font-size: 14px; color: #868487">
								<span>${order.getProduct().getSize()}</span>, <span>${order.getProduct().getColor()}</span>
								<span>, $${order.getProduct().getCost()}</span>
							</p>

						</div>

						<span style="font-weight: 500; font-size: 14px">$${order.getProduct().getCost()
							* order.getQuantity()}</span>
					</div>
				</c:forEach>
			</div>

		</div>
		</div>


		
	</div>


	<div class="col-12 mt-4 container-input">
		<button type="submit" class="btn btn-success">Tạo phiếu xuất</button>
	</div>






</form>

<style>
p {
	margin-bottom: 0px;
}
</style>








