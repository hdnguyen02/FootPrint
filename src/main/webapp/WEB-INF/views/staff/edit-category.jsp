<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="container-fluid px-5 pt-5 pb-4 bg-white shadow-lg">
	<h3 class="border-bottom fs-5 pb-3">Chỉnh sữa danh mục</h3>
	
	<c:if test="${ not empty result }">
			<c:choose>
			<c:when test="${result == true }">
				<div class="alert alert-success alert-dismissible shadow mt-4" role="alert">
					 <div>Cập nhập thành công</div>
					 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-danger alert-dismissible shadow mt-4" style="border-radius: none" role="alert">
					 <div>Cập nhập thất bại</div>
					 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:otherwise>
		</c:choose>
	
	</c:if>
	<form:form modelAttribute="category" class="shadow mt-4 row">

		<div class="col-12 col-md-6 container-input"> 
			<label for="name-category" class="form-label">mã loại</label>
			<form:input path="idCategory" required="required" readonly="true" class="ct-input" id="name-category"/> 
		</div>	
		
		<div class="col-12 col-md-6 container-input"> 
			<label for="name-category" class="form-label">tên loại</label>
			<form:input path="name" required="required" class="ct-input" id="name-category"/> 
		</div>	
		
		<div class="col-12 mt-3 container-input"> 
			<button type="submit"
				class="btn btn-primary rounded-0 border-0 w-100"
				style="background-color: #87b106 !important">Hiệu chỉnh danh mục
			</button>
		</div>
	</form:form>



</div>

<!-- <script>

document.querySelector("[name='disable']").value = document.querySelector("input[name='status-category']").value
</script> -->





