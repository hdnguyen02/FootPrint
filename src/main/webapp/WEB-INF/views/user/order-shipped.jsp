<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3 class="border-bottom fs-5 pb-3">Đơn hàng đã vận chuyển</h3>

<c:if test="${orders.size()==0}">
	<div class="container py-5" style="min-height: 80vh">
		<div class="col-sm-12 empty-cart-cls text-center">
			<img src="https://i.imgur.com/dCdflKN.png" width="130" height="130"
				class="img-fluid mb-4 	mr-3">
			<h3>
				<strong>Your Order shipped is Empty</strong>
			</h3>
			<h4>Add something to make me happy :)</h4>
			<a href="#" class="btn btn-primary m-3 text-white"
				>continue shopping</a>
		</div>
	</div>
</c:if>

<c:if test="${orders.size()!=0}">
	<div class="mt-4">
		<div class="row text-uppercase text-center" style="font-size: 13px">
			<div class="col-1">
				<p class="fw-bolder" style="color: #999999">#</p>
			</div>
			<div class="col-2">
				<p class="fw-bolder" style="color: #999999">Ngày vận chuyển</p>
			</div>
			<div class="col-2">
				<p class="fw-bolder" style="color: #999999">Phone</p>
			</div>

			<div class="col-4">
				<p class="fw-bolder" style="color: #999999">Địa chỉ</p>
			</div>


			<div class="col-2">
				<p class="fw-bolder" style="color: #999999">Total</p>
			</div>

		</div>

		<c:forEach items="${orders}" var="order" varStatus="index">
			<div class="row mt-3 align-items-center text-center">
				<div class="col-1">
					<p>${index.count}</p>
				</div>
				<div class="col-2">
					<c:set var="myDate" value="${order.getExport().getDate()}" />
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
					<a
						style="text-decoration: underline !important; color: blue !important"
						href='<c:url value='/order-shipped/detail.htm?id=${order.getIdOrder()}'/>'>
						Detail </a>
				</div>

			</div>
			<hr>
		</c:forEach>
	</div>
</c:if>


	
<jsp:include page="/WEB-INF/views/general/notification.jsp" />


<style>
p {
	margin-bottom: 0px;
}
</style>