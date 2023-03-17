<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<form>
	<h3 class="fw-bolder">Register</h3>
	<div class="mt-5"> 
		<div class="position-relative">
			<input class="ct-input w-100" type="email" placeholder="email">
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-envelope"></i>
			</span>
		</div>
		
		<div class="position-relative" style="margin-top: 36px">
			<input class="ct-input w-100" type="text" placeholder="username">
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-user"></i>
			</span>
		</div>
		
		<div class="position-relative" style="margin-top: 36px">
			<input class="ct-input w-100" type="password" placeholder="password">
			<span class="position-absolute start-0" style="top: 1px">
				<i class="fa-solid fa-lock"></i>
			</span>
		</div>
		<div class="form-check mt-4">
			  <input class="form-check-input rounded rounded-0" type="checkbox" value="" id="flexCheckDefault">
			  <label class="form-check-label" for="flexCheckDefault">
			    Remember me
	  		</label>
		</div>
		<div class="d-flex justify-content-between align-items-center mt-5">
			<button type="button" class="btn btn-primary border-0 round-0 rounded rounded-0" style="padding: 14px 34px !important;background-color: #87b106 !important">Register</button>
			<a class="underline" style="cursor: pointer">Đăng nhập</a>
		</div>
		
		
	</div>
</form>

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



