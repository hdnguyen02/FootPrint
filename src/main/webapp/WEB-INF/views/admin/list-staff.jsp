<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>



<div class="table-responsive container-fluid p-5 bg-white shadow-lg">
			<div class="row">
				<div class="col-6 content-user-filter d-flex justify-content-end align-items-center">
					<script>
						var currentUrl = window.location.pathname;
						var buttonE = document.getElementById('staff-btn');
						if (currentUrl.includes('staff')) {
							buttonE.classList.add('action');
						} else {
							buttonE.classList.remove('action');
						}
					</script>
				</div>
			</div>
	<table class="table table-hover table-striped shadow mt-4">
		<thead>
			<tr>
				<th class="col">#</th>
				<th class="col">LastName</th>
				<th class="col">FirstName</th>
				<th class="col">CCCD</th>
				<th class="col">Email</th>
				<th class="col">Phone</th>
				<th class="col">Address</th>
				<th class="col">Status</th>
			</tr>
		</thead>
		<tbody id="body-table">
			<c:forEach items="${staffs}" var="staff" varStatus="status">
				<tr>
					<td class="col py-y">${staff.idEmployee}</td>
					<td class="col py-2">${staff.lastName}</td>
					<td class="col py-2">${staff.firstName}</td>
					<td class="col py-2">${staff.cccd}</td>
					<td class="col py-2">${staff.email}</td>
					<td class="col py-2">${staff.phone}</td>
					<td class="col py-2">${staff.address}</td>
						
					<td>
						<div class="h-100 d-flex align-items-center justify-content-start">
							<c:choose>
								<c:when test="${staff.disable eq '0'}">
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
							<a href="enable${staff.idEmployee}.htm?source=${source}">
								<button class="btn btn-primary" type="button" id="edit_button${status.index}">
								<c:choose>
									<c:when test="${staff.disable eq '0'}">
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







