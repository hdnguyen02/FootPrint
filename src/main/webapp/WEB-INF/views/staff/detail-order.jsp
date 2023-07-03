<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script defer="defer" src='<c:url value="/resources/javascript/staff-detail-order.js"/>'></script>
<div class="container-fluid p-5 bg-white shadow-lg">
	
	<form:form class="row" method="POST" modelAttribute="order">
		<div class="col-7">
			<p style="font-weight: 500;font-size:18px">Billing Details</p>
			<hr>
			<div class="row" >
				<div class="col-6 container-input">
			
					<label class="form-label">First Name <span style="color: #ff5a66">*</span></label>
			
			  		<form:input readonly="true" path="firstName" class="ct-input" placeholder="First Name" type="text"/>
				</div>
				<div class="col-6 container-input">
					<label class="form-label">Last Name</label>
					<form:input readonly="true" path="lastName" class="ct-input" type="text"/>	
					
				</div>
				<div class="col-12 mt-2 container-input">
					<label class="form-label">Email Address</label>
				
			  		<form:input path="email"  readonly="true" class="ct-input" placeholder="Email Address" type="text"/>
				</div>
				<div class="col-12 mt-2 container-input">
					<label class="form-label">Phone</label>
			
			  		<form:input path="phone" readonly="true"  class="ct-input" placeholder="Phone" type="text"/>
				</div>
				
				<div class="col-12 mt-2 container-input">
					<label class="form-label">Address</label>
			
			  		<form:input path="address" readonly="true" class="ct-input" placeholder="Adress" type="text"/>
			  		
				</div>
				<div class="col-12 mt-2 container-input">
					<label class="form-label">Message</label>
			  		<form:textarea readonly="true" path="message" class="ct-input"/>
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
								<p><span>${orderDetail.getProductSize().getProduct().getName()} x <span>${orderDetail.getQuantity()}</span></span></p>
								<p style="font-size: 14px;color:#868487"><span>${orderDetail.getProductSize().getSize().getNameSize()}</span>, 
									<span>${orderDetail.getProductSize().getProduct().getColor().getNameColor()}</span>
								</p>
								
							</div>
							
						<span style="font-weight: 500;font-size:14px">$${orderDetail.getTotalMonney()}</span>
					</div>	
					</c:forEach>
			
					<div class="d-flex justify-content-between">
						<span>Shipping</span>
						<span>Free</span>
					</div>
			</div>
			<div class="px-4 py-3 border-top border-top-1" style="font-weight: 500">
				<p class="d-flex justify-content-between">
					<Span>Total</Span><span>${order.getTotalMonney()}</span>
				</p>
			</div>
			</div>
		
			<form:select path="orderStatus.idOrderStatus" items="${orderStatus}" itemLabel="name" itemValue="idOrderStatus" class="ct-input mt-3">
			</form:select>
			<button type="submit"
				class="btn btn-primary rounded-0 border-0 w-100 mt-3"
				style="background-color: #87b106 !important">Cập nhập
			</button>
		</div>
		<!-- curentStatusOrder -->
		<input type="text" hidden="true" readonly name="curentStatusOrder" value="${curentStatusOrder}">
	</form:form>
	
	
	
</div>



