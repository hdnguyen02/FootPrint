<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script defer="defer" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script defer="defer" src='<c:url value="/resources/javascript/cart.js"/>'></script>

<div class="container py-5" style="min-height: 80vh"> 
	<h3 class="text-center fs-1" style="font-weight: 400">Your Cart</h3>
	<form class="row mt-5 gx-4">
		
		<div class="col-9">
			<div class="row text-uppercase" style="font-size: 13px">
						<div class="col-6">
						<p class="fw-bolder" style="color: #999999">Product</p>
						</div>
						<div class="col-1">
							<p class="fw-bolder" style="color: #999999">Cost</p>
						</div>
						<div class="col-2">
							<p class="fw-bolder text-center" style="color: #999999">Quantity</p>
						</div>
						<div class="col-2">
							<p class="fw-bolder" style="color: #999999">Total</p>
						</div>
						
			</div>
			<hr class="mb-0 mt-4" style="color: rgba(138,135,123,0.6)">
		</div>

		
		<div class="col-9"> 
			
			
			<c:forEach items="${carts}" var="cart">
					<div data-cart-wrapper='${cart.getIdCart()}' class="row mt-4 align-items-center">
					<div class="col-6 d-flex align-items-center gap-3">
						<div>
							<img src="<c:url value="/resources/image/product/${cart.getProductSize().getProduct().getImageName()}"/>" style="height: 80px; object-fit: cover">
						</div>
						<div>
							<p class="text-lowercase" style="font-weight: 500">${cart.getProductSize().getProduct().getName()}</p>
							<p class="text-lowercase" style="color: rgb(138,135,123)">
							
								<span>${cart.getProductSize().getProduct().getColor().getNameColor()}</span>
								<span>, ${cart.getProductSize().getSize().getNameSize()}</span>
							</p>
						</div>
						
					</div>
						<div class="col-1">
							<div class='d-flex'>
								<span>$</span>
								<span data-cart-cost='${cart.getIdCart()}' class="text-lowercase d-inline" style="font-weight: 500">${cart.getProductSize().getProduct().getCost()}</span>
							</div>
							
						</div>
						<div class="col-2">
							<div class="rounded-5 d-flex align-items-center justify-content-center py-1 gap-1 mx-3" style="background-color: #efefef">
								<button type="button" style="font-weight: 500" data-subtraction='${cart.getIdCart()}' class="border-0 px-0">
									<i class="fa-solid fa-minus"></i>
								</button>
								<input name="quantity" data-cart-quantity='${cart.getIdCart()}' class="border-0" style="width: 36px;text-align: center;background-color: #efefef;font-weight: 500" type="text" value="${cart.getQuantity()}">
								
								<button type="button" style="font-weight: 500" data-plus='${cart.getIdCart()}' class="border-0 px-0">
									<i class="fa-solid fa-plus"></i>
								</button>
							</div>
						</div>
						<div class="col-2">
							<div class='d-flex'>
								<span>$</span>
								<span data-cart-total='${cart.getIdCart()}' class='d-inline' style="font-weight: 500"></span>
							</div>
						</div>
					
						<div class="col-1">
							<div class="d-flex justify-content-between align-items-center">
								<button data-cart-delete='${cart.getIdCart()}' class="border-0 bg-white"><i class="fa-sharp fa-solid fa-trash-can" style="color: rgba(0,0,0,0.6)"></i></button>
								<input class="form-check-input mt-0 rounded-0" type="checkbox" value="">	
							</div>
							
						</div>
						
						</div>
						<hr data-cart-hr='${cart.getIdCart()}' class="mt-4" style="color: rgba(138,135,123,0.6)">
						
			</c:forEach>
		
			
		</div>
		<div class="col-3">
			
			<div style="background-color: #efefef">
				<p class="px-4 py-3 border-bottom border-bottom-1" style="font-weight: 500">Order Summary</p>
				<div class="px-4 py-4 d-flex flex-column gap-2" style="font-size: 14px">
					<div class="d-flex justify-content-between">
						<span>Subtotal</span>
						<span style="font-weight: 500">$418</span>
					</div>
					<div class="d-flex justify-content-between">
						<span>Shipping</span>
						<span style="font-weight: 500">Free</span>
					</div>
					<div>
						<p class="d-flex align-items-center gap-2" style="color:#87b106">
							<Span>Add coupon code</Span>
							<span><i class="fa-solid fa-arrow-right"></i></span>
						</p>
					
					</div>
					
					
			</div>
			<div class="px-4 py-3 border-top border-top-1" style="font-weight: 500">
				<p></p>
			</div>
			</div>
			
			<div class="mt-2">
				<button type="submit" data-cart-checkout class="btn btn-primary w-100 rounded-0 border-0 py-2" style="background-color: #87b106">
				Checkout
			</button>
			</div>
			
			
		</div>
		
	</form>
</div>



<style>
	p {
		margin-bottom: 0px;
	 }
</style>