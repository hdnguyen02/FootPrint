<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script defer="defer"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script defer="defer"
	src='<c:url value="/resources/javascript/cart.js"/>'></script>
<c:if test="${carts.size()==0}">
	<div class="container py-5" style="min-height: 80vh">
		<div class="col-sm-12 empty-cart-cls text-center">
			<img src="https://i.imgur.com/dCdflKN.png" width="130" height="130"
				class="img-fluid mb-4 mr-3">
			<h3>
				<strong>Your Cart is Empty</strong>
			</h3>
			<h4>Add something to make me happy :)</h4>
			<a href="#" class="btn btn-primary m-3 text-white">continue shopping</a>
		</div>
	</div>
</c:if>

<c:if test="${carts.size() != 0 }">
	<div class="container py-5" style="min-height: 80vh">
		<h3 class="text-center fs-1" style="font-weight: 400">Your Cart</h3>
		<form onsubmit="checkSubmit(event)" method="POST"
			action="checkout.htm" class="row mt-5 gx-4">

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
				<hr class="mb-0 mt-4" style="color: rgba(138, 135, 123, 0.6)">
			</div>


			<div class="col-9">


				<c:forEach items="${carts}" var="cart">
					<div data-cart-wrapper='${cart.getIdCart()}'
						class="row mt-4 align-items-center">
						<div class="col-6 d-flex align-items-center gap-3">
							<div>
								<img
									src="<c:url value="/resources/image/product/${cart.getProduct().getImage()}"/>"
									style="height: 80px; object-fit: cover">
							</div>
							<div>
								<p class="text-lowercase" style="font-weight: 500">${cart.getProduct().getName()}</p>
								<p class="text-lowercase" style="color: rgb(138, 135, 123)">

									<span>${cart.getProduct().getColor()}</span> <span>,
										${cart.getProduct().getSize()}</span>
								</p>
							</div>

						</div>
						<div class="col-1">
							<div class='d-flex'>
								<span>$</span> <span data-cart-cost='${cart.getIdCart()}'
									class="text-lowercase d-inline" style="font-weight: 500">${cart.getProduct().getCost()}</span>
							</div>

						</div>
						<div class="col-2">
							<div
								class="rounded-5 d-flex align-items-center justify-content-center py-1 gap-1 mx-3"
								style="background-color: #efefef">
								<button type="button" style="font-weight: 500"
									data-subtraction='${cart.getIdCart()}' class="border-0 px-0">
									<i class="fa-solid fa-minus"></i>
								</button>
								<input value="${cart.getQuantity()}"
									data-cart-quantity='${cart.getIdCart()}' class="border-0"
									style="width: 36px; text-align: center; background-color: #efefef; font-weight: 500"
									type="text">

								<button type="button" style="font-weight: 500"
									data-plus='${cart.getIdCart()}' class="border-0 px-0">
									<i class="fa-solid fa-plus"></i>
								</button>
							</div>
						</div>
						<div class="col-2">
							<div class='d-flex'>
								<span>$</span> <span data-cart-total='${cart.getIdCart()}'
									class='d-inline' style="font-weight: 500"></span>
							</div>
						</div>

						<div class="col-1 p-0">
							<div class="d-flex justify-content-between align-items-center">
								<input onchange="computedTotalMonney()" name="items-checkout"
									value="${cart.getIdCart()}" type="checkbox"
									class="form-check-input mt-0 rounded-0"
									style="border: 1px solid rgba(0, 0, 0, 0.2) !important; width: 22px !important; height: 22px !important">
								<button data-cart-delete='${cart.getIdCart()}'
									class="border-0 bg-white">
									<i class="fa-sharp fa-solid fa-trash-can fs-5"
										style="color: rgba(0, 0, 0, 0.6)"></i>
								</button>
							</div>

						</div>

					</div>
					<hr data-cart-hr='${cart.getIdCart()}' class="mt-4"
						style="color: rgba(138, 135, 123, 0.6)">

				</c:forEach>


			</div>
			<div class="col-3">

				<div style="background-color: #efefef">
					<p class="px-4 py-3 border-bottom border-bottom-1"
						style="font-weight: 500">Order Summary</p>
					<div class="px-4 py-4 d-flex flex-column gap-2"
						style="font-size: 14px">
						<div class="d-flex justify-content-between">
							<span>Subtotal</span>
							<div>
								<span style="font-weight: 500">$</span> <span data-subtotal
									style="font-weight: 500">0</span>
							</div>
						</div>
						<div class="d-flex justify-content-between">
							<span>Shipping</span> <span style="font-weight: 500">Free</span>
						</div>
						<div>
							<p class="d-flex align-items-center gap-2" style="color: #87b106">
								<Span>Add coupon code</Span> <span><i
									class="fa-solid fa-arrow-right"></i></span>
							</p>
						</div>
					</div>
					<div class="px-4 py-3 border-top border-top-1"
						style="font-weight: 500">
						<p></p>
					</div>
				</div>

				<div class="mt-2">
					<button type="submit" data-cart-checkout
						class="btn btn-primary w-100 rounded-0 border-0 py-2"
						style="background-color: #87b106">Order</button>
				</div>
			</div>

		</form>
	</div>
</c:if>

<style>
p {
	margin-bottom: 0px;
}
</style>