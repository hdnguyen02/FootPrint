<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="d-block w-100" style = "height : 75vh">
		<div class="bg-light h-100">
			<div class="row">
				<div class="col-6 content-user-filter d-flex justify-content-end align-items-center">
					<script>
						var currentUrl = window.location.pathname;
						var buttonEm = document.getElementById('staff-btn');
						//var buttonG = document.getElementById('guest-btn');
						if (currentUrl.includes('staff')) {
							buttonEm.classList.add('active');
							//buttonG.classList.remove('active');
						} else {
							//buttonG.classList.add('active');
							buttonEm.classList.remove('active');
						}
					</script>
				</div>
			</div>
			<div class="row mt-4 h-100">
				<div class="col h-100 overflow-y-scroll position-relative">
					<table class="table table-hover table-striped table-categories">
						<thead  class="position-sticky top-0">
							<tr>
								<th class="p-3">Avatar</th>
								<th class="p-3">Fullname</th>
								<th class="p-3">Status</th>
								<th class="p-3">Email</th>
								<th class="p-3">Enable</th>
								<th class="p-3">Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach varStatus="status" var="account" items="${accounts}">
								<tr>
									<td><img style="height: 50px"
										src="<c:url value = "/resources/image/avatar/${account.imageUrl}"/>">
									</td>
									<td><div
											class="h-100 d-flex align-items-center justify-content-start">
											<c:set var="fullName"
												value="${account.lastName} ${account.firstName} " />
											<p class="m-0">${fullName}</p>
										</div></td>
									<td>
										<div
											class="h-100 d-flex align-items-center justify-content-start">
											<c:choose>
												<c:when test="${account.disable eq '0'}">
													<div
														class="d-flex align-items-center w-75 h-50 badge rounded-pill text-bg-success">
														<p class="m-0 w-100 text-center">Enable</p>
													</div>
												</c:when>
												<c:otherwise>
													<div
														class="d-flex align-items-center w-75 h-50 badge rounded-pill text-bg-danger">
														<p class="m-0 w-100 text-center">Block</p>
													</div>
												</c:otherwise>
											</c:choose>
										</div>
									</td>
									<td><p class="p-3">${account.email }</p></td>
									<td>
										<div
											class="h-100 d-flex align-items-center justify-content-start">
											<a href="enable${account.idAccount}.htm?source=${source}"><button
													class="btn btn-primary" type="button"
													id="edit_button${status.index}">
													<c:choose>
														<c:when test="${account.disable eq '0'}">
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
									<td><div
											class="h-100 d-flex align-items-center justify-content-start">
											<a id="del_button${status.index}"
												href="delete${account.idAccount}.htm?source=${source}"><button
													class="btn btn-danger ms-2">
													<i class="ti-trash"></i>
												</button></a>
										</div></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
</div>
