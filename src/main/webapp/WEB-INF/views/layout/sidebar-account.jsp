<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var='accountDetail' value='/account/detail.htm' />
<c:url var='order' value='/order.htm' />
<c:url var='accountDashboard' value='/account.htm' />
<c:url var='changePassword' value='/change-password.htm' />
<c:url var='orderShipped' value='/order-shipped.htm' />
<nav>
	<ul class="ct-ul border border-1">
		<li class="border-bottom border-1"><a href="${accountDashboard}" class="ct-a active"> <span><i
					class="fa-solid fa-gauge"></i></span> <span>Dashboard</span>
		</a></li>
		<li class="border-bottom border-1"><a href="${order}" class="ct-a"> <span
				style="margin-left: -4px"><i
					class="fa-solid fs-5 fa-cart-shopping"></i></span> <span>Đơn hàng chờ duyệt</span>
		</a></li>
		<li class="border-bottom border-1"><a href="${orderShipped}" class="ct-a"> <span
				style="margin-left: -4px"><i
					class="fa-solid fs-5 fa fa-truck"></i></span> <span>Đơn hàng đã vận chuyển</span>
		</a></li>
		<li class="border-bottom border-1"><a href="${changePassword}" class="ct-a"> <span><i
					class="fa-solid fa-lock"></i></span> <span>Thay đổi mật khẩu</span>
		</a></li>

	
	</ul>
</nav>