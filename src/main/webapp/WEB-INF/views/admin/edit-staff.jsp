<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script defer="defer"
	src='<c:url value="/resources/javascript/edit-product.js"/>'></script>

<div class="container-fluid p-5 bg-white shadow-lg"
	style="min-height: 100vh">
	<h3 class="fs-5 pb-3">Hiệu chỉnh nhân viên</h3>

	<form:form method="POST" modelAttribute="staff">
		<form:input hidden="true" path="idEmployee" />
		<form:input hidden="true" path="role" />
		<div class="d-flex flex-column gap-2 justify-content-center h-100">
			<div class="row mt-2">
				<div class="col-6">
					<label class="mt-2" style="font-size: 14px">Firtname</label>
					<form:input path="firstName" class="ct-input" />
				</div>
				<div class="col-6">
					<label class="mt-2" style="font-size: 14px">Lastname</label>
					<form:input path="LastName" class="ct-input" />
				</div>
			</div>
			<div class="row mt-2">
				<div class="col-6">
					<label class="mt-2" style="font-size: 14px">CCCD</label>
					<form:input path="cccd" class="ct-input" />
				</div>
				<div class="col-6">
					<label class="mt-2" style="font-size: 14px">Email</label>
					<form:input path="email" class="ct-input" />
				</div>
			</div>
			<div class="row mt-2">
				<div class="col-6">
					<label class="mt-2" style="font-size: 14px">Password</label>
					<form:input type="password" path="password" class="ct-input" />
				</div>
				<div class="col-6">
					<label class="mt-2" style="font-size: 14px">phone</label>
					<form:input path="phone" class="ct-input" />
				</div>
			</div>

			<div class="row mt-2">
				<div class="col-6">
					<label class="mt-2" style="font-size: 14px">Trạng thái</label>		

					<form:select path="disable" class="ct-input">
					<option value="true" <c:if test="${product.disable.equal(false)}">selected</c:if>>
							Active</option>
						<option value="true"
							<c:if test="${product.disable.equal(true)}">selected</c:if>>
							Disable</option>
					</form:select>

				</div>
				<div class="col-6">
					<label class="mt-2" style="font-size: 14px">Trạng thái</label>		
					<form:input path="address" class="ct-input" />
				</div>
			</div>
		</div>
		<button type="submit"
			class="mt-5 btn btn-primary rounded-0 border-0 w-100"
			style="background-color: #87b106 !important">Lưu thông tin</button>
	</form:form>

</div>
