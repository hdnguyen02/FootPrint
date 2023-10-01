<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="container py-5">
	<form method="POST" action="cancel.htm" class="row">
		<div class="col-7">
			<p style="font-weight: 500;font-size:18px">Chi tiết đơn hàng</p>
			<hr>
			<input name="id-order" value="${order.getIdOrder()}" readonly="readonly" hidden="true"  type="text"/>
			<div class="row" >
				<div class="col-6 container-input">
					<label class="form-label">First Name</label>
			
			  		<input name="first-name" readonly="readonly" value="${order.getFirstName()}" class="ct-input" placeholder="First Name" type="text"/>
				</div>
				<div class="col-6 container-input">
					<label class="form-label">Last Name</label>
			
			  		<input name="last-name" readonly="readonly" value="${order.getLastName()}" class="ct-input" placeholder="Last Name" type="text"/>
				</div>
				<div class="col-12 mt-2 container-input">
					<label class="form-label">Email Address</label>
				
			  		<input name="email" readonly="readonly" value="${order.getEmail()}" class="ct-input" placeholder="Email Address" type="text"/>
				</div>
				<div class="col-12 mt-2 container-input">
					<label class="form-label">Phone</label>
			
			  		<input name="phone" readonly="readonly" value="${order.getPhone()}" class="ct-input" placeholder="Phone" type="text"/>
				</div>
				
				<div class="col-12 mt-2 container-input">
					<label class="form-label">Address</label>
			
			  		<input name="address" readonly="readonly" value="${order.getAddress()}" class="ct-input" placeholder="Adress" type="text"/>
			  		
				</div>
				<div class="col-12 mt-2 container-input">
					<label class="form-label">Message</label>
			
			  		<textarea name="message" readonly="readonly" class="ct-input" placeholder="Adress">${order.getMessage()}</textarea>
			  		
				</div>
		
			</div>
		
		</div>
		<div class="col-5 text-lowercase" style="padding-top: 42px">
			
			<div style="background-color: #efefef">
				<p class="px-4 py-3 border-bottom border-bottom-1" style="font-weight: 500">Order Summary</p>
				<div class="px-4 py-4 d-flex flex-column gap-2">
				
					<!-- Danh sách cart -->
					<c:forEach items="${order.getOrderDetails()}" var="orderDetail">
						<div class="d-flex justify-content-between">
							<div>
								<p><span>${orderDetail.getProduct().getName()} x <span>${orderDetail.getQuantity()}</span></span></p>
								<p style="font-size: 14px;color:#868487"><span>${orderDetail.getProduct().getSize()}</span>, 
									<span>${orderDetail.getProduct().getColor()}</span>
								</p>
							</div>
						<span style="font-weight: 500;font-size:14px">$${orderDetail.getQuantity() * orderDetail.getCost()}</span>
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
				<p class="d-flex justify-content-between">
					<Span>Total</Span><span>${order.getTotalMonney()}</span>
				</p>
			</div>
			</div> 
			
			
			<div class="mt-4">
				<button type="submit" class="btn btn-danger w-100 rounded-0 border-0 py-2">
				Hủy đơn hàng
			</button>
			</div>

			
		<%-- 	
			<div class="mt-2">
				<button type="submit" class="btn btn-primary w-100 rounded-0 border-0 py-2" style="background-color: #87b106">
				${handleOrder}
			</button>
			</div> --%>
			
			
		</div>
	</form>
</div>

<style>
	p {
		margin-bottom: 0px;
	}
</style>