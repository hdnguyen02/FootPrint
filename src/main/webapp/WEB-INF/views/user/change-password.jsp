<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<h3 class="border-bottom fs-5 pb-3">Change password</h3>

<form method="POST"> 
	<div class="row">
		<div class="col-12 container-input">
			<label>Current Password</label> 
			<input type="password" class="ct-input">
		</div>
		
		<div class="col-6 container-input">
			<label>New Password</label> 
			<input name="new-password" type="password" class="ct-input">
		</div>
		
		<div class="col-6 container-input">
			<label>Confirm Password</label> 
			<input type="password" class="ct-input">
		</div>
	</div>
	<div class="d-flex justify-content-end mt-4">
		<button type="submit"
			class="btn btn-primary rounded-0 border-0 px-4 py-2"
			style="background-color: #87b106 !important">Save changes
		</button>
	</div>
</form>



