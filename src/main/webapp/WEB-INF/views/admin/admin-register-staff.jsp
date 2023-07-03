<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form method="POST" modelAttribute="userbean" id="form-register" action="staff-register.htm" enctype="multipart/form-data">
	<h3 class="fw-bolder">SIGN UP</h3>
	<div class="mt-5"> 
		<div class="position-relative">
			<form:input required="required" path="email" id="register-email" class="ct-input w-100 border-bottom border-bottom-1" type="email" placeholder="Email"/>
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-envelope"></i>
			</span>
			<span data-error-email class="error"></span>
		</div>
		<div class="position-relative" style="margin-top: 36px">
			<form:input required="required" path="username" id="register-username" class="ct-input w-100 border-bottom border-bottom-1" type="text" placeholder="Username"/>
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-user"></i>
			</span>
			<span data-error-username class="error"></span>
		</div>
		<div class="position-relative" style="margin-top: 36px">
			<form:input required="required" path="password" id="register-password" class="ct-input w-100 border-bottom border-bottom-1" type="password" placeholder="Password"/>
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-lock"></i>
			</span>
			<span data-error-password class="error"></span>
		</div>
		<div class="position-relative" style="margin-top: 36px">
			<form:input required="required" path="lastName" id="register-lastname" class="ct-input w-100 border-bottom border-bottom-1" type="text" placeholder="Lastname"/>
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-user"></i>
			</span>
			<span data-error-lastname class="error"></span>
		</div>
		<div class="position-relative" style="margin-top: 36px">
			<form:input required="required" path="firstName" id="register-firstname" class="ct-input w-100 border-bottom border-bottom-1" type="text" placeholder="Firstname"/>
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-user"></i>
			</span>
			<span data-error-firstname class="error"></span>
		</div>
		<div class="position-relative" style="margin-top: 36px">
			<form:input required="required" path="phoneNumber" id="register-phone" class="ct-input w-100 border-bottom border-bottom-1" type="text" placeholder="Phone"/>
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-user"></i>
			</span>
			<span data-error-phone class="error"></span>
		</div>
		<div class="position-relative" style="margin-top: 36px">
			<form:input required="required" path="avatar" id="register-avatar" class="ct-input w-100 border-bottom border-bottom-1" type="file" placeholder="avatar" accept="resources/image/avatar/*"/>
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-user"></i>
			</span>
			<span data-error-username class="error"></span>
		</div>
		<div class="d-flex justify-content-between align-items-center mt-5">
			<button type="submit" class="btn btn-primary border-0 round-0 rounded rounded-0" style="padding: 14px 34px !important;background-color: #87b106 !important">Submit</button>
		</div>
	</div>
</form:form>