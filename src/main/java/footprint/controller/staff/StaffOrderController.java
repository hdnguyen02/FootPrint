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
import org.springframework.web.servlet.ModelAndView;

import footprint.entity.OrderCT;
import footprint.entity.OrderDetail;
import footprint.entity.OrderStatus;
import footprint.service.OrderService;
import footprint.service.OrderStatusService;
import footprint.service.ProductSizeService;

@Controller
@Transactional 
public class StaffOrderController {
	
	
	@Autowired 
	private OrderService orderService; 
	
	@Autowired 
	private OrderStatusService orderStatusService; 
	
	
	@Autowired 
	private ProductSizeService productSizeService;  // cập nhập đơn hàng. 
	
	
	@RequestMapping("staff/order")
	public String listOrder(ModelMap model,@RequestParam(value="time",required = false,defaultValue = "date") String time) throws ParseException {
		
		 List<OrderCT> ordersPending = null; 
		 List<OrderCT> ordersDeliver = null; 
		 List<OrderCT> ordersSuccess = null; 
		 List<OrderCT> ordersCancel = null;
		 if (time.equals("month")) {
			 ordersPending = orderService.getOrderWithCurentMonthAndStatus("PENDING");
			 ordersDeliver = orderService.getOrderWithCurentMonthAndStatus("DELIVER");
			 ordersSuccess  = orderService.getOrderWithCurentMonthAndStatus("SUCCESS");
			 ordersCancel = orderService.getOrderWithCurentMonthAndStatus("CANCEL");
		 }
		 else {
			 ordersPending = orderService.getOrderWithCurentDateAndStatus("PENDING");
			 ordersDeliver = orderService.getOrderWithCurentDateAndStatus("DELIVER");
			 ordersSuccess  = orderService.getOrderWithCurentDateAndStatus("SUCCESS");
			 ordersCancel = orderService.getOrderWithCurentDateAndStatus("CANCEL");
		 }
		 
		 model.addAttribute("ordersPending", ordersPending);
		 model.addAttribute("ordersDeliver", ordersDeliver);
		 model.addAttribute("ordersSuccess", ordersSuccess);
		 model.addAttribute("ordersCancel", ordersCancel);
		
		 model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		 model.addAttribute("bodyDashboard", "staff/list-order.jsp");
		 return "layout/main-dashboard";
	}
	
	// neu nguoi dung duyet don hang.
	
	
	// tiep theo mo ra chi tiet don hang 
	@RequestMapping(value="staff/order/detail",method = RequestMethod.GET)
	public String getDetail(ModelMap model,@RequestParam(value="id",required = true) Long idOrder) {
		
		List<OrderStatus> orderStatus = orderStatusService.getAllOrderStatus();  // lấy ra toàn bộ dơn hàng. 
		OrderCT order = orderService.getOrderWidhId(idOrder); 
		Hibernate.initialize(order.getOrderDetails());
		String curentStatusOrder = order.getOrderStatus().getIdOrderStatus(); 
		// đẩy qua phía client -> kiểm tra trạng thái trước đó. 
		model.addAttribute("curentStatusOrder", curentStatusOrder); 
		model.addAttribute("order",order); 
		model.addAttribute("orderStatus",orderStatus);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		 
		model.addAttribute("bodyDashboard", "staff/detail-order.jsp");
		return "layout/main-dashboard";
	}
	
	@RequestMapping(value="staff/order/detail", method = RequestMethod.POST)
	public ModelAndView editStatusOrder(HttpSession session,
			@RequestParam(value = "id", required = true) Long idOrder, 
			@RequestParam(value="curentStatusOrder",required=true) String idOSPrevious,
			@RequestParam(value = "orderStatus.idOrderStatus", required = true) String idOSUpdate) {
		

		ModelAndView modelAndView = new ModelAndView("redirect:/staff/order.htm"); 
		OrderCT order = orderService.getOrderWidhId(idOrder); 
		Hibernate.initialize(order.getOrderDetails());
		boolean isValid = false;
		if (idOSPrevious.equals("PENDING")  && idOSUpdate.equals("DELIVER")) { 
		
				int sizeOrderDetail = order.getOrderDetails().size(); 
				Long [] idProductSizes = new Long[sizeOrderDetail];
				Integer [] quantityBuys = new Integer[sizeOrderDetail]; 
				int index = 0; 
				for (OrderDetail orderDetail : order.getOrderDetails()) { 
					idProductSizes[index] = orderDetail.getProductSize().getIdProductSize(); 
					quantityBuys[index] = orderDetail.getQuantity(); // lấy ra số lượng mua.. 
					index++; 
				}
				
				isValid = productSizeService.updatesQuantity(idProductSizes, quantityBuys);  
				if (!isValid) { 
					System.out.println("số lượng hàng mua không đủ");
				}
			
			
			
			
		}
		else if (idOSPrevious.equals("DELIVER")  && idOSUpdate.equals("SUCCESS") ) { 
			isValid = true;
		} 
		else if (idOSPrevious.equals("PENDING")  && idOSUpdate.equals("CANCEL") ) { 
			isValid = true; 
		}
		if (isValid) {
			OrderStatus orderStatus = new OrderStatus(); 
			orderStatus.setIdOrderStatus(idOSUpdate);
			order.setOrderStatus(orderStatus); 
			orderService.update(order); 
			modelAndView.addObject("order-status", orderStatus.getIdOrderStatus());
			modelAndView.addObject("mail-user",order.getEmail());
			
		} else {  
			System.out.println("sai quy trình"); 
		}
	
		
		return modelAndView; 
	}
	
}


