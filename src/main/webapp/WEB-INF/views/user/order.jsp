<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h3 class="border-bottom fs-5 pb-3">Order</h3>



<div class="mt-4">

		<div class="row text-uppercase text-center" style="font-size: 13px">
						<div class="col-1">
							<p class="fw-bolder" style="color: #999999">#</p>
						</div>
						<div class="col-4">
							<p class="fw-bolder" style="color: #999999">Date</p>
						</div>
						<div class="col-3">
							<p class="fw-bolder" style="color: #999999">Status</p>
						</div>
						<div class="col-2">
							<p class="fw-bolder" style="color: #999999">Total</p>
						</div>
						<div class="col-2">
							<p class="fw-bolder" style="color: #999999">Action</p>
						</div>
			</div>
	
			<c:forEach items="${orders}" var="order" varStatus="index">
					<div class="row mt-3 align-items-center text-center">
					<div class="col-1">
						<p>${index.count}</p>
						
					</div>
						<div class="col-4">
							<p>${order.getDate()}</p>
						</div>
						<div class="col-3">
							<p>${order.getOrderStatus().getName()}</p>
						</div>
						<div class="col-2">
					
							<p>$${order.getTotalMonney()}</p>

						</div>
					
						<div class="col-2">
							<a href='<c:url value='/order/detail.htm?id=${order.getIdOrder()}'/>' class="btn btn-primary border-0 round-0 rounded rounded-0 text-white" style="padding: 10px 28px !important;background-color: #87b106 !important">Detail</a>
							
						</div>
						
						</div>
						<hr data-cart-hr='${cart.getIdCart()}' class="mt-2" style="color: rgba(138,135,123,0.6)">
						
			</c:forEach>
		</div>

<style>
 p { 
 	margin-bottom: 0px;
 }
 
</style>