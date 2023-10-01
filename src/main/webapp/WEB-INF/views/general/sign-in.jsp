<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<c:url var='register' value='/register.htm' />

<form method="POST" id="form-login" style="padding: 40px 0px">
	<h3 class="fw-bolder"> 
		Đăng nhập
		<%-- <s:message code="login.title"/> --%>
	</h3>
	<div class="mt-5"> 
	
		<div class="position-relative" style="margin-top: 36px">
			<input required="required" name="email" id="register-username" class="ct-input w-100 border-bottom border-bottom-1" type="text" placeholder="email">
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-user"></i>
			</span>
	
			
		</div>
		
		<div class="position-relative" style="margin-top: 36px">
			<input required="required" name="password" id="register-password" class="ct-input w-100 border-bottom border-bottom-1" type="password" placeholder="password">
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-lock"></i>
			</span>
			<c:if test="${not empty resultLogin}">
			  <span class="error">${ resultLogin }</span>
			</c:if>
			
			<c:if test="${not empty successRegister}">
			  <span class="fw-bolder" style="color: #87b106">${ successRegister }</span>
			</c:if>
			
	
		</div>
		
		
		<div class="form-check mt-4">
			  <input class="form-check-input rounded rounded-0" type="checkbox" value="" id="flexCheckDefault">
			  <label class="form-check-label" for="flexCheckDefault">
			    Remember me
	  		</label>
		</div>
		<div class="d-flex justify-content-between align-items-center mt-5">
			<button type="submit" class="btn btn-primary border-0 round-0 rounded rounded-0" style="padding: 14px 34px !important;background-color: #87b106 !important">Submit</button>
			<a href="${register}" style="cursor: pointer;text-decoration:underline !important">Đăng ký</a>
		</div>
		
		
	</div>
</form>

<div class="d-flex gap-3 justify-content-center align-items-center mt-4">
  	<span>or login with</span>
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