package footprint.controller.staff;

import java.text.ParseException;
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

import footprint.entity.OrderCT;
import footprint.entity.OrderStatus;
import footprint.service.OrderService;
import footprint.service.OrderStatusService;

@Controller
@Transactional
public class StaffOrderController {
	
	
	@Autowired 
	private OrderService orderService; 
	
	@Autowired OrderStatusService orderStatusService; 
	
	
	@RequestMapping("staff/order")
	public String listOrder(ModelMap model) throws ParseException {
		
		 List<OrderCT> ordersPending = orderService.getOrderWithCurentDateAndStatus("PENDING");
		 List<OrderCT> ordersDeliver = orderService.getOrderWithCurentDateAndStatus("DELIVER");
		 List<OrderCT> ordersSuccess = orderService.getOrderWithCurentDateAndStatus("SUCCESS");
		 List<OrderCT> ordersCancel = orderService.getOrderWithCurentDateAndStatus("CANCEL");
		 model.addAttribute("ordersPending", ordersPending);
		 model.addAttribute("ordersDeliver", ordersDeliver);
		 model.addAttribute("ordersSuccess", ordersSuccess);
		 model.addAttribute("ordersCancel", ordersCancel);
		
		 model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		 model.addAttribute("bodyDashboard", "staff/list-order.jsp");
		 return "layout/main-dashboard";
	}
	
	// tiep theo mo ra chi tiet don hang 
	@RequestMapping(value="staff/order/detail",method = RequestMethod.GET)
	public  String getDetail(ModelMap model,@RequestParam(value="id",required = true) Long idOrder) {
		
		OrderCT order = orderService.getOrderWidhId(idOrder);  
		Hibernate.initialize(order.getOrderDetails()); 
		
		List<OrderStatus> orderStatus = orderStatusService.getAllOrderStatus();
		
		
		
		model.addAttribute("order",order);
		model.addAttribute("orderStatus",orderStatus);
			
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		 
		model.addAttribute("bodyDashboard", "staff/detail-order.jsp");
		return "layout/main-dashboard";
	}
	
	@RequestMapping(value="staff/order/detail", method = RequestMethod.POST)
	public String editStatusOrder(HttpSession session,ModelMap model,
			@RequestParam(value = "id", required = true) Long idOrder, 
			@RequestParam(value = "orderStatus.idOrderStatus", required = true) String idOrderStatus
			) {
	
		OrderCT order = orderService.getOrderWithIdOpenSS(idOrder);   
		OrderStatus orderStatus = new OrderStatus(); 
		orderStatus.setIdOrderStatus(idOrderStatus);
		order.setOrderStatus(orderStatus); 
		System.out.println(orderService.update(order));
		
		return "redirect:/staff/order/detail.htm?id=" + idOrder;
	}
	
}


