<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<div class="modal fade" id="model-edit-category" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content p-3" style="border-radius: 0px !important; width: 600px">
				<div class="modal-header border border-0 pt-2 pb-0">
					<h3 class="modal-title fs-5" id="exampleModalLabel">Edit category</h3>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body" >
					<form:form method="post" modelAttribute="category" action='category/edit'>
					
						<div class="mb-3">
							<label for="name-category" class="col-form-label">id</label> 
							<input id="edit-id-category-show" disabled type="text" class="form-control">
						</div>
						
						<form:input path="idCategory" type="text" class="form-control" id="edit-id-category-hidden"/>
						
						<form:input path="name" type="text" class="form-control" id="edit-name-category"/>
					
						<div class="mb-3">
							<label for="name-category" class="col-form-label">Name</label> 
							<form:input path="name" type="text" class="form-control" id="edit-name-category"/>
						</div>
						<div class="mb-4">
							<label for="message-text" class="col-form-label">Status</label> 
							<form:select path="disable" id="edit-disable-category" class="form-select" aria-label="Default select example">
								<option value="0">active</option>
								<option value="1">disable</option>
								
							</form:select>
						</div>
						<div class="d-flex justify-content-end">
							<button type="button" data-bs-dismiss="modal" class="btn btn-outline-secondary me-3">cancel</button>
							<button type="submit" class="btn btn-outline-success">Submit</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
