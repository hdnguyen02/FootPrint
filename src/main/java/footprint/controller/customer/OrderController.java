package footprint.controller.customer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Customer;
import footprint.entity.OrderCT;
import footprint.service.CustomerService;
import footprint.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;

	@RequestMapping("order")
	@Transactional
	public String getOrder(HttpSession session, ModelMap model) {

		if (session.getAttribute("resultCreateOrder") != null) {
			model.addAttribute("result", (Boolean) session.getAttribute("resultCreateOrder"));
			model.addAttribute("success", "Đặt hàng thành công!");
			model.addAttribute("failure", "Xảy ra lỗi !!!");
			session.removeAttribute("resultCreateOrder");
		}
		if (session.getAttribute("resultCancelOrder") != null) {
			model.addAttribute("result", (Boolean) session.getAttribute("resultCancelOrder"));
			model.addAttribute("success", "Hủy đơn hàng thành công");
			model.addAttribute("failure", "Hủy đơn hàng thất bại");
			session.removeAttribute("resultCancelOrder");
		}

		Integer idCustomer = (Integer) session.getAttribute("idCustomer");
		Customer customer = customerService.getAccountWithId(idCustomer);
		Hibernate.initialize(customer.getOrders());

		List<OrderCT> orders = new ArrayList<>();
		for (OrderCT order : customer.getOrders()) {
			Hibernate.initialize(order.getExport());
			if (order.getIsCancelled() == false && order.getExport() == null) {
				orders.add(order);
			}
		}

		model.addAttribute("orders", orders);
		model.addAttribute("content", "layout/main-account.jsp");
		model.addAttribute("bodyAccount", "user/order.jsp");
		return "layout/main-user";
	}

	// khi người dùng đặt hàng.
	@RequestMapping(value = "order", method = RequestMethod.POST)
	public String postOrder(HttpSession session, ModelMap model,
			@RequestParam(value = "items-checkout", required = true) Integer[] idCartsCheckout,
			@RequestParam(value = "first-name", required = true) String firstName,
			@RequestParam(value = "last-name", required = true) String lastName,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "phone", required = true) String phone,
			@RequestParam(value = "address", required = true) String address,
			@RequestParam(value = "message", required = true) String message,
			@RequestParam(value = "total-monney", required = true) Float totalMoney) {
		Integer idCustomer = (Integer) session.getAttribute("idCustomer");
		boolean result = orderService.createOrderAndOrderDetail(firstName, lastName, email, phone, address, message,
				totalMoney, idCustomer, idCartsCheckout);
		session.setAttribute("resultCreateOrder", result);
		return "redirect:/order.htm";

	}

	@RequestMapping("/order/detail")
	public String detailOrder(HttpSession session, ModelMap model,
			@RequestParam(value = "id", required = true) Integer idOrder) {
		OrderCT order = orderService.getOrderWidhId(idOrder);
		if (order == null) {
			return "general/not-found";
		}
		Integer idCustomer = (Integer) session.getAttribute("idCustomer");
		Customer customer = order.getCustomer();
		if (!idCustomer.equals(customer.getIdCustomer())) {
			return "general/not-found";
		}
		model.addAttribute("order", order);
		model.addAttribute("content", "user/detail-order.jsp");
		return "layout/main-user";
	}

	@RequestMapping(value = "/order/cancel", method = RequestMethod.POST)
	@Transactional
	public String cancelledOrder(HttpSession session, ModelMap model,
			@RequestParam(value = "id-order", required = true) Integer idOrder) {
		OrderCT order = orderService.getOrderWidhId(idOrder);
		if (order == null) {
			return "general/not-found";
		}
		Integer idCustomer = (Integer) session.getAttribute("idCustomer");
		Customer customer = order.getCustomer();
		if (!idCustomer.equals(customer.getIdCustomer())) {
			return "general/not-found";
		}
		Hibernate.initialize(order.getExport());
		if (order.getExport() != null) {
			return "general/not-found";
		}
		order.setIsCancelled(true);
		orderService.update(order);
		session.setAttribute("resultCancelOrder", true);
		return "redirect:/order.htm";
	}
}