<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script defer="defer" src='<c:url value="/resources/javascript/list-order.js"/>'></script>

<c:url var='timeDate' value='/staff/order.htm?time=date' />
<c:url var='timeMonth' value='/staff/order.htm?time=month' />

<div class="container-fluid p-5 bg-white shadow-lg"
	style="min-height: 100vh">
	<h3 class="fs-5 pb-3">Order</h3>

	<nav class="mt-3">
		<ul
			class="d-flex justify-content-between ps-0 border-bottom border-bottom-1">


			<li class="tag-active tag"><a data-order-type='pending'>Chờ
					được duyệt</a></li>


			<li class="tag"><a data-order-type='deliver'>Đang giao hàng</a>
			</li>

			<li class="tag"><a data-order-type='success'>Giao hàng thành
					công</a></li>

			<li class="tag"><a data-order-type='cancel'>Đã hủy</a></li>

			<li>
				<!-- Example single danger button -->
				<div class="btn-group">
				  <p class="dropdown-toggle" style="cursor: pointer"  data-bs-toggle="dropdown" aria-expanded="false">
				   <span class="me-2">Thời gian</span>
				   <span>
				   	 <i class="fas fa-caret-down"></i>
				   </span>
				  </p>
				  <ul class="dropdown-menu dropdown-menu-end">
				    <li><a class="dropdown-item" href="${timeDate}">curent date</a></li>
				    <li><hr class="dropdown-divider"></li>
				    <li><a class="dropdown-item" href="${timeMonth}">curent month</a></li>
				  </ul>
				</div>
			</li>
		</ul>
	</nav>

	<div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Date</th>
					<th scope="col">Cost</th>
					<th scope="col"></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${ordersPending}" var="orderPending"
					varStatus="index">
					<tr data-order data-order-pending>
						<th scope="row">${index.count}</th>
						<td>${orderPending.getDate()}</td>
						<td>$${orderPending.getTotalMonney()}</td>
						<td><a
							href='<c:url value='/staff/order/detail.htm?id=${orderPending.getIdOrder()}'/>'>Detail</a></td>
					</tr>
				</c:forEach>
			
				<c:forEach items="${ordersDeliver}" var="orderDeliver"
					varStatus="index">

					<tr data-order data-order-deliver>
						<th scope="row">${index.count}</th>
						<td>${orderDeliver.getDate()}</td>
						<td>$${orderDeliver.getTotalMonney()}</td>
						<td><a
							href='<c:url value='/staff/order/detail.htm?id=${orderDeliver.getIdOrder()}'/>'>Detail</a></td>
					</tr>
				</c:forEach>

				<c:forEach items="${ordersSuccess}" var="orderSuccess"
					varStatus="index">

					<tr data-order data-order-success>
						<th scope="row">${index.count}</th>
						<td>${orderSuccess.getDate()}</td>
						<td>$${orderSuccess.getTotalMonney()}</td>
						<td><a
							href='<c:url value='/staff/order/detail.htm?id=${orderSuccess.getIdOrder()}'/>'>Detail</a></td>
					</tr>


				</c:forEach>
				
				<!--  -->

				<c:forEach items="${ordersCancel}" var="orderCancel"
					varStatus="index">

					<tr data-order data-order-cancel>
						<th scope="row">${index.count}</th>
						<td>${orderCancel.getDate()}</td>
						<td>$${orderCancel.getTotalMonney()}</td>
						<td><a
							href='<c:url value='/staff/order/detail.htm?id=${orderCancel.getIdOrder()}'/>'>Detail</a></td>
					</tr>


				</c:forEach>
			</tbody>

		</table>
	</div>
</div>


<style>
.tag {
	color: #bcbec1;
	padding-bottom: 16px;
}

.tag-active {
	color: black;
	font-weight: 500;
	border-bottom: 3px solid #4e73df;
}
</style>
