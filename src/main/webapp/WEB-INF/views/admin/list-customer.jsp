<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="table-responsive container-fluid p-5 bg-white shadow-lg">
			<div class="row">
				<div class="col-6 content-user-filter d-flex justify-content-end align-items-center">
					<script>
						var currentUrl = window.location.pathname;
						var buttonC = document.getElementById('guest-btn');
						if (currentUrl.includes('guest')) {
							buttonC.classList.add('action');
						} else {
							buttonC.classList.remove('action');
						}
					</script>
				</div>
			</div>
	<table class="table table-hover table-striped shadow mt-4">
		<thead>
			<tr>
				<th class="col">#</th>
				<th class="col">Email</th>
				<th class="col">Status</th>
			</tr>
		</thead>
		<tbody id="body-table">
			<c:forEach items="${customers}" var="customer" varStatus="status">
				<tr>
					<td class="col py-y">${customer.idCustomer}</td>
					<td class="col py-2">${customer.email}</td>
						
					<td>
						<div class="h-100 d-flex align-items-center justify-content-start">
							<c:choose>
								<c:when test="${customer.disable eq '0'}">
									<div class="d-flex align-items-center w-80 h-50 badge rounded-pill text-bg-success">
										<p class="m-0 w-100 text-center">Enable</p>
									</div>
								</c:when>
								<c:otherwise>
									<div class="d-flex align-items-center w-80 h-50 badge rounded-pill text-bg-danger">
										<p class="m-0 w-100 text-center">Block</p>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</td>
				
					<td class="col py-2">
						<div>
							<a href="disable${customer.idCustomer}.htm?source=${source}">
								<button class="btn btn-primary" type="button" id="edit_button${status.index}">
								<c:choose>
									<c:when test="${customer.disable eq '0'}">
										<div class="">
											<i class="ti-lock"></i>
										</div>
									</c:when>
									<c:otherwise>
										<div class="">
											<i class="ti-unlock"></i>
										</div>
									</c:otherwise>
								</c:choose>
								</button></a>
								
								<!--  
								<a href='<c:url value='/admin/edit-staff.htm?id=${staff.idEmployee}'/>' class="btn btn-dark btn-sm" style="border-radius: 0 !important;width: 80px !important"> 
								<span class="button breadcrumb-item active px-2">edit</span>
								</a>
								-->
								
						</div>
					</td>	

			</c:forEach>

		</tbody>
	</table>


<%-- 	<!-- Phân trang -->
	<div class="d-flex justify-content-end mb-2">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				 <li class="page-item"><a class="page-link" href="#">Previous</a></li>
				<c:forEach var="page" begin="1" end="${totalPage }">
					<li data-page="${page}" class="page-item"><a
						href='<c:url value='/staff/product/manage.htm?page=${ page }'/>'
						class="page-link">${ page }</a></li>	
				</c:forEach>
				 <li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
	</div> --%>
</div>

<jsp:include page="/WEB-INF/views/general/notification.jsp" />