<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<div
	class="table-responsive container-fluid px-5 pt-5 pb-4 bg-white shadow-lg">
	<div class="d-flex justify-content-between mb-4">
		<div class="d-flex">
			<span class="me-2"><i class="bi bi-bookmarks-fill fs-3"></i></span>
			<h2 class="mb-0">Category</h2>
		</div>
		
		<div class="d-flex align-items-center">
			<form class="d-flex me-3">
		            <div class="input-group">
		              <input class="form-control" type="search" placeholder="Search for..." aria-label="Search"/>
		              <button class="btn" style="background-color:#4e73df !important" type="submit">
		                <i class="bi bi-search fw-bolder text-white"></i>
		              </button>
		            </div>
          		</form>
			
			
			<!-- button add category -->
		
			<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#model-add-category" data-bs-whatever="@getbootstrap" style="background-color:#4e73df !important">add category</button>
		
		</div>
		
		
	</div>
	
	<c:if test="${ not empty resultAddCategory }">
			<c:choose>
			<c:when test="${resultAddCategory == true }">
				<div class="alert alert-success alert-dismissible shadow mt-4 mb-4" role="alert">
					 <div>Thêm thành công</div>
					 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-danger alert-dismissible shadow mt-4 mb-4" role="ale	rt">
					 <div>Thêm thất bại</div>
					 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:otherwise>
			
		</c:choose>
	
	</c:if>

	<table class="table table-hover table-striped shadow">
		<thead>
			<tr>
				<th class="col">#</th>
				<th class="col">Name</th>
				<th class="col">Create at</th>
				<th class="col">Update at</th>
				<th class="col">Status</th>
				<th class="col"></th>
				<th class="col"></th>
		
			</tr>
		</thead>
		<tbody id="body-table">
			<c:forEach items="${categoriesPerPage}" var="category">
				<div data-id-category="${ category.idCategory }"
					 data-name-category="${ category.name }"
					 data-diable-category="${ category.disable }"
				 class="d-none"></div>
				<tr>

					<td class="col py-2">${category.idCategory}</td>
					<td data-name-category="${ category.idCategory }" class="col py-2">${category.name}</td>
					<td class="col py-2"> 
					<fmt:formatDate value="${category.createAt}" pattern="dd/MM/yyyy HH:mm:ss" />
					 
					</td>
					<td class="col py-2"><c:choose>
							<c:when test="${category.updateAt}">
								<span><fmt:formatDate value="${category.updateAt}" pattern="dd/MM/yyyy HH:mm:ss" /></span>
							</c:when>
							<c:otherwise>
								<span>not update</span>
							</c:otherwise>
						</c:choose></td>
					<td class="col py-2">
					<c:choose>
							<c:when test="${category.disable == false}">
								<button class="btn btn-success btn-sm" data-disable-category="${category.idCategory}"
									style="border-radius: 0 !important;width: 80px !important">active</button>
							</c:when>
							<c:otherwise>
								<button class="btn btn-danger btn-sm" data-disable-category="${category.idCategory}"
									style="border-radius: 0 !important;width: 80px !important">disable</button>
							</c:otherwise>
						</c:choose></td>
					<td class="col py-2">
						<div>
							<a data-edit-category data-id-category="${ category.idCategory }" data-bs-toggle="modal" data-bs-target="#model-edit-category" data-bs-whatever="@getbootstrap" class="btn btn-secondary btn-sm" 
								style="border-radius: 0 !important;width: 80px !important"> <span
								class="button breadcrumb-item active px-2">edit</span>
							</a>
						</div>

					</td>

					<td class="col py-2">
						<div>
							<a data-delete-category data-id-category="${ category.idCategory }" class="btn btn-dark btn-sm" 
								style="border-radius: 0 !important;width: 80px !important"> <span
								class="button breadcrumb-item active">delete</span>
							</a>
						</div>
					</td>
			</c:forEach>

		</tbody>
	</table>


	<!-- Phân trang -->
	<div class="d-flex justify-content-end mb-2">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				 <li class="page-item"><a class="page-link" href="#">Previous</a></li>
				<c:forEach var="page" begin="1" end="${totalPage }">
					<li data-page="${page}" class="page-item"><a
						href='<c:url value='/staff/category?page=${ page }'/>'
						class="page-link">${ page }</a></li>
				</c:forEach>
				 <li class="page-item"><a class="page-link" href="#">Next</a></li>

			</ul>
		</nav>
	</div>
</div>
	<!-- form add category -->
<jsp:include page="/WEB-INF/views/staff/add-category.jsp" />
<jsp:include page="/WEB-INF/views/staff/edit-category.jsp" />
<script src='<c:url value="/resources/staff/javascript/category.js"/>'></script>





