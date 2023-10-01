<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<c:url var='signIn' value='/sign-in.htm' />


<form:form method="POST" modelAttribute="customer" id="form-register">
	<h3 class="fw-bolder">Register</h3>
	<div class="mt-5"> 
		<div class="position-relative">
			<form:input required="required" path="email" id="register-email" class="ct-input w-100 border-bottom border-bottom-1" type="email" placeholder="email"/>
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-envelope"></i>
			</span>
			<span data-error-email class="error"></span>
			<c:if test="${not empty resultEmail}">
			  <span data-result-email class="error">${ resultEmail }</span>
			</c:if>
		</div>
	
		
		<div class="position-relative" style="margin-top: 36px">
			<form:input required="required" path="password" id="register-password" class="ct-input w-100 border-bottom border-bottom-1" type="password" placeholder="password"/>
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-lock"></i>
			</span>
			<span data-error-password class="error"></span>
		</div>
		<div class="position-relative" style="margin-top: 36px">
			<input required="required" id="register-confirm-password" class="ct-input w-100 border-bottom border-bottom-1" type="password" placeholder="confirm password">
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-lock"></i>
			</span>
			<c:if test="${not empty errorRegister}">
			  <span data-error-register class="error"> ${errorRegister}</span>
			</c:if>
			<!-- Hiển thị lỗi đăng ký tại đây  -->
		
		</div>
		<div class="form-check mt-4">
			  <input class="form-check-input rounded rounded-0" type="checkbox" value="" id="flexCheckDefault">
			  <label class="form-check-label" for="flexCheckDefault">
			    Remember me
	  		</label>
		</div>
		<div class="d-flex justify-content-between align-items-center mt-5">
			<button type="submit" class="btn btn-primary border-0 round-0 rounded rounded-0" style="padding: 14px 34px !important;background-color: #87b106 !important">Submit</button>
			<a href="${ signIn }" class="underline" style="cursor: pointer;text-decoration:underline !important">Đăng nhập</a>
		</div>
		
		
	</div>
</form:form>

<div class="d-flex gap-3 justify-content-center align-items-center mt-4">
  	<span>or register with</span>
  	<div>
  		<button class="border-0 rounded rounded-0" style="padding-left: 12px;padding-right:12px;padding-top: 5px;padding-bottom:5px;background-color: #334b7f">
  			<i class="fa-brands fa-facebook-f text-white"></i>
  		</button >
  		<button class="border-0 rounded rounded-0" style="padding-left: 9px;padding-right:9px;padding-top: 5px;padding-bottom:5px;background-color: #1c85c9">
  			<i class="fa-brands fa-twitter text-white"></i>
  		</button>
  		<button class="border-0 rounded rounded-0" style="padding-left: 9.5px;padding-right:9.5px;padding-top: 5px;padding-bottom:5px;background-color: #c32128">
  			<i class="fa-brands fa-google text-white"></i>
  		</button>
  	</div>	
</div>

<script src='<c:url value="/resources/javascript/register.js"/>'></script>


