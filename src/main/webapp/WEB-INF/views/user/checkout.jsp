<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="container py-5">
	<form action="order.htm" method="POST" class="row">
		<div class="col-7">
			<p style="font-weight: 500;font-size:18px">Billing Details</p>
			<hr>
			<div class="row" >
				<div class="col-6 container-input">
					<label class="form-label">First Name <span style="color: #ff5a66">*</span></label>
			
			  		<input required="required" name="first-name" class="ct-input" placeholder="First Name" type="text"/>
				</div>
				<div class="col-6 container-input">
					<label class="form-label">Last Name <span style="color: #ff5a66">*</span></label>
			
			  		<input required="required" name="last-name" class="ct-input" placeholder="Last Name" type="text"/>
				</div>
				<div class="col-12 mt-2 container-input">
					<label class="form-label">Email Address  <span style="color: #ff5a66">*</span></label>
				
			  		<input required="required" name="email" class="ct-input" placeholder="Email Address" type="text"/>
				</div>
				<div class="col-12 mt-2 container-input">
					<label class="form-label">Phone  <span style="color: #ff5a66">*</span></label>
			
			  		<input required="required" name="phone" class="ct-input" placeholder="Phone" type="text"/>
				</div>
				
				<div class="col-12 mt-2 container-input">
					<label class="form-label">Address  <span style="color: #ff5a66">*</span></label>
			
			  		<input required="required" name="address" class="ct-input" placeholder="Adress" type="text"/>
			  		
				</div>
				<div class="col-12 mt-2 container-input">
					<label class="form-label">Message</label>
			
			  		<textarea name="message" class="ct-input" placeholder="Adress"></textarea>
			  		
				</div>
			
			<!-- tạo ra các thẻ input truyền dữ liệu tới post  -->
			<c:forEach items="${carts}" var="cart">
				<input type="hidden" name="items-checkout" value="${cart.getIdCart()}" type="checkbox" checked="checked">
			</c:forEach> 
			<input type="hidden" name="total-monney" value="${totalMonney}" type="number">
			
			</div>
		
		</div>
		<div class="col-5 text-lowercase" style="padding-top: 42px">
			
			<div style="background-color: #efefef">
				<p class="px-4 py-3 border-bottom border-bottom-1" style="font-weight: 500">Order Summary</p>
				<div class="px-4 py-4 d-flex flex-column gap-2">
				
					<!-- Danh sách cart -->
					<c:forEach items="${carts}" var="cart">
						<div class="d-flex justify-content-between">
							<div>
								<p><span>${cart.getProduct().getName()} x <span>${cart.getQuantity()}</span></span></p>
								<p style="font-size: 14px;color:#868487"><span>${cart.getProduct().getSize()}</span>, 
									<span>${cart.getProduct().getColor()}</span>
									<span>, $${cart.getProduct().getCost()}</span>
								</p>
								
							</div>
							
						<span style="font-weight: 500;font-size:14px">$${cart.getProduct().getCost() * cart.getQuantity()}</span>
					</div>	
					</c:forEach>
					
					
					
					
					<div class="d-flex justify-content-between">
						<span>Shipping</span>
						<span>Free</span>
					</div>
	
					<div>
						<p class="d-flex align-items-center gap-2" style="color:#87b106">
							<Span>Add coupon code</Span>
							<span><i class="fa-solid fa-arrow-right"></i></span>
						</p>
					
					</div>
			</div>
			<div class="px-4 py-3 border-top border-top-1" style="font-weight: 500">
				<div class="d-flex justify-content-between">
					<p>Total</p><p>$${totalMonney}</p>
				</div>
			</div>
			</div>
			<div class="mt-2">
				<button type="submit" class="btn btn-primary w-100 rounded-0 border-0 py-2" style="background-color: #87b106">
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