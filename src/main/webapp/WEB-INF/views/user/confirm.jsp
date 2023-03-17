<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="h-100 d-flex flex-column align-items-center justify-content-center">
	<div class="d-flex justify-content-center">
	 	<img src="resources/image/login/security.png" width="150px">
	</div>
	<div class="text-center">
		<h3>Enter OTP</h3>
		<p>We have send you access code via <span>hdnguyen7702@gmail.com</span></p>
		<form class="d-flex flex-column gap-4">
			<div class="d-flex justify-content-between">
				<input class="otp border rounded"/>
				<input class="otp border rounded"/>
				<input class="otp border rounded"/>
				<input class="otp border rounded"/>
				<input class="otp border rounded"/>
				<input class="otp border rounded"/>
			</div>
			<div>
				<button class="btn btn-primary rounded-0 border-0 py-2 w-100" style="background-color:#87b106 !important">Verify</button>
			</div>
			<div>
				<p class="mb-0">Didn't receive the code</p>
				<a>Resend code</a>
			</div>
			
		</form>
	</div>
</div>

<style>
	.otp {
		width: 40px; 
		height: 40px; 
		font-size: 18px;
		padding-left: 14px;
	}
	.otp:focus {
		outline: 1px solid #87b106;
		
	}
</style>