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
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Customer;
import footprint.entity.OrderCT;
import footprint.service.CustomerService;
import footprint.service.OrderService;

@Controller
public class OrderShippedController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;

	@RequestMapping("order-shipped")
	@Transactional
	public String getOrder(HttpSession session, ModelMap model) {

		Integer idCustomer = (Integer) session.getAttribute("idCustomer");

		Customer customer = customerService.getAccountWithId(idCustomer);

		Hibernate.initialize(customer.getOrders());

		List<OrderCT> orders = new ArrayList<>();
		for (OrderCT order : customer.getOrders()) {
			Hibernate.initialize(order.getExport());  
			if (order.getExport() != null) orders.add(order);
		}
		


		model.addAttribute("orders", orders);
		model.addAttribute("content", "layout/main-account.jsp");
		model.addAttribute("bodyAccount", "user/order-shipped.jsp");
		return "layout/main-user";

	}
	
	@RequestMapping("/order-shipped/detail")
	@Transactional
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
		
		
		
		if (order.getIdOrder() == null) {
			return "general/not-found";
		}
		
		Hibernate.initialize(order.getExport());  
		
				
		model.addAttribute("order", order);
		model.addAttribute("content", "user/detail-order-shipped.jsp");
		return "layout/main-user";
	}
	
	
	
	
	
}