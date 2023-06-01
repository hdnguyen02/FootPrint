<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script defer="defer" src='<c:url value="/resources/javascript/list-order.js"/>'></script> 

<%-- <c:url var='timeDate' value='/staff/order.htm?time=date' />
<c:url var='timeMonth' value='/staff/order.htm?time=month' /> --%>

<form method="POST" onSubmit="handleSubmit(event)" class="container-fluid p-5 bg-white shadow-lg" style="min-height: 100vh">
	<div class="row align-items-center mb-5">
		<h3 class="fs-5 col-2 mb-0">Đơn đặt hàng</h3> 
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
		<div class="col-3">
			<select name="status" class="ct-input">
			    <option value="not-export" ${status.equals('not-export') ? 'selected' : ''}>Đơn hàng chưa xuất</option>
			    <option value="exist-export" ${status.equals('exist-export') ? 'selected' : ''}>Đơn hàng đã xuất</option>
			</select>
		</div>
		<div class="col-2">
			<button class="btn btn-primary w-100">Lọc</button>
		</div>
		
		
	</div>
	

	<div class="mt-4">
		<div class="row text-uppercase text-center mb-3" style="font-size: 13px">
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

		<c:forEach items="${orders}" var="order" varStatus="index">
			<div class="row mt-3 align-items-center text-center">
				<div class="col-1">
					<p>${index.count}</p>
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
					<a
						style="text-decoration: underline !important; color: blue !important"
						href='<c:url value='/staff/order/detail.htm?id=${order.getIdOrder()}'/>'>
						Detail </a>
				</div>

			</div>
			<hr>
		</c:forEach>
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
