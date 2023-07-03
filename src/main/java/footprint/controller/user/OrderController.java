package footprint.controller.user;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Account;
import footprint.entity.OrderCT;
import footprint.service.AccountService;
import footprint.service.OrderService;

@Controller
@Transactional
public class OrderController {
	
	@Autowired
	private AccountService accountSerive; 
	@Autowired
	private OrderService orderService; 
	
	@RequestMapping("order")
	public String getOrder(HttpSession session,ModelMap model) {
		
		Long idAccount = (Long)session.getAttribute("idAccount"); 
		
		Account account = accountSerive.getAccountWithId(idAccount); 
		
		Hibernate.initialize(account.getOrders()); 
		model.addAttribute("orders", account.getOrders());

		model.addAttribute("content", "layout/main-account.jsp"); 
		model.addAttribute("bodyAccount", "user/order.jsp"); 
		return "layout/main-user"; 
	}
	
	
	
	@RequestMapping(value="order",method = RequestMethod.POST)
	public String postOrder(HttpSession session,ModelMap model,
			@RequestParam(value="items-checkout",required = true) Long [] idCartsCheckout, 
			@RequestParam(value="first-name",required = true) String firstName,
			@RequestParam(value="last-name",required = true) String lastName,
			@RequestParam(value="email",required = true) String email, 
			@RequestParam(value="phone",required = true) String phone,
			@RequestParam(value="address",required = true) String address,
			@RequestParam(value="message",required = true) String message, 
			@RequestParam(value="total-monney",required = true) Float totalMoney
			) { 
			
		Account account = accountSerive.getAccountWithId((Long)session.getAttribute("idAccount")); 
		
		boolean resultCreateOrder = orderService.createOrderAndOrderDetail(firstName, lastName, email, phone, address, message, totalMoney,account, idCartsCheckout);
		
		if (resultCreateOrder == false) {
			System.out.println("Sảy ra lỗi khi thêm đặt hàng");
		}
		
		return "redirect:/order.htm"; 

		
	}
	
	
	@RequestMapping("order/detail")
	public String detailOrder(HttpSession session,ModelMap model,@RequestParam(value="id",required = true) Long idOrder)  {
		

		OrderCT order = orderService.getOrderWidhId(idOrder);  
		Long idAccount = (Long) session.getAttribute("idAccount"); 

		if (order == null || !order.getAccount().getIdAccount().equals(idAccount)) {
			model.addAttribute("content", "user/detail-order.jsp");
			return "layout/main-user";
		}
		
		Hibernate.initialize(order.getOrderDetails()); 
		model.addAttribute("order", order);
	

		String idOrderStatus = order.getOrderStatus().getIdOrderStatus(); 		
		
		
		if (idOrderStatus.equals("PENDING") ) { 
			model.addAttribute("action", "cancel.htm");  
			model.addAttribute("cancel", true); 
		}
		else if(idOrderStatus.equals("DELIVER") ) { 
			model.addAttribute("action", "review.htm");  
			model.addAttribute("success", true); 
		}
	
		model.addAttribute("content", "user/detail-order.jsp");
		return "layout/main-user";
	}
	
	@RequestMapping(value="/order/cancel",method=RequestMethod.POST)
	public String postDetailOrder(HttpSession session,ModelMap model,@RequestParam("id-order") Long idOrder)  {
		OrderCT order = orderService.getOrderWithIdOpenSS(idOrder); 
		boolean resultOrderCancel = orderService.orderCancel(order); 
		
		if (resultOrderCancel == false) { 
			System.out.println("đã xảy ra lỗi");
		} 
		
		return "redirect:/order.htm"; 
	}
}
