<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h3 class="border-bottom fs-5 pb-3">Account Details</h3>



<form:form method="POST" class="mt-4" modelAttribute="user">
	<div class="row">
		<form:input path="idAccount" readonly="true" type="hidden" />
		<form:input path="password" readonly="true" type="hidden" />
		<form:input path="role.idRole" readonly="true" type="hidden" />
		<div class="col-6 container-input">
			<label for="firstname">First Name</label> 
			<form:input path="FirstName" id="firstname" class="ct-input"/>
		</div>
		<div class="col-6 container-input">
			<label for="lastname">Last Name</label> 
			<form:input  id="lastname" path="lastName" class="ct-input"/>
		</div>

		<div class="col-12 container-input">
			<label  for="username">Username</label> 
		<form:input path="username" readonly="true" id="username"  class="ct-input"/>
		</div>

		<div class="col-12 container-input">
			<label for="email-address">Email Address</label> 
			<form:input path="email" readonly="true" id="username"  class="ct-input"/>
		</div> 
		<div class="col-12 container-input">
			<label for="phone">Phone</label> 
			<form:input path="phone"  id="phone" class="ct-input"/>
		</div>
		
		<div class="col-12 container-input">
			<label for="adress">Adress</label> 
			<form:input path="address" id="phone" class="ct-input"/>
		</div>
		
		
	
		</div>
		
		
	<div class="d-flex justify-content-end mt-4">
		<button type="submit"
			class="btn btn-primary rounded-0 border-0 px-4 py-2"
			style="background-color: #87b106 !important">Save changes
		</button>
	</div>
</form:form>