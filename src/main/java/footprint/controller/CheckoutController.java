package footprint.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Account;
import footprint.entity.Cart;	
import footprint.service.AccountService;
import footprint.service.CartService;
import footprint.service.OrderService;

@Controller
public class CheckoutController {
	
	@Autowired
	private AccountService accountSerive; 
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService; 
	
	@RequestMapping(value="checkout",method = RequestMethod.POST)
	public String index(HttpSession session,ModelMap model,
			@RequestParam(value="items-order",required = false) Long [] itemsOrder) { 
		
		Long idAccount = (Long) session.getAttribute("idAccount"); 
		
		Account account = accountSerive.getAccountWithId(idAccount);
		
		
		List<Cart> carts = new ArrayList<>();  // danh sách cart người dùng chọn thanh toán./
		// tính toán số tiền đơn hàng tại đây
		
		float totalMonney = 0f; 
	
		for (Long itemOrder:itemsOrder) {
			Cart cart = cartService.getCartWithId(itemOrder); // lấy ra thông tin cart 
			float totalMonneyItem = cart.getQuantity()  * cart.getProductSize().getProduct().getCost(); 
			totalMonney += totalMonneyItem; 
			carts.add(cart); 
		}
		model.addAttribute("account", account);
		model.addAttribute("carts", carts);
		model.addAttribute("totalMonney", totalMonney);
		
		model.addAttribute("content", "user/checkout.jsp");
		return "layout/main-user";
	}
	
	@RequestMapping(value="order/detail",method = RequestMethod.POST)
	public String detail(HttpSession session,ModelMap model,
			@RequestParam(value="items-checkout",required = true) Long [] itemsCheckout, 
			@RequestParam(value="first-name",required = true) String firstName,
			@RequestParam(value="last-name",required = true) String lastName,
			@RequestParam(value="email",required = true) String email, 
			@RequestParam(value="phone",required = true) String phone,
			@RequestParam(value="address",required = true) String address,
			@RequestParam(value="message",required = true) String message, 
			@RequestParam(value="total-monney",required = true) Float totalMoney
			) { 
			
		// đưa account vào. 
		Account account = accountSerive.getAccountWithId((Long)session.getAttribute("idAccount")); 
		
		System.out.println(orderService.createOrderAndOrderDetail(firstName, lastName, email, phone, address, message, totalMoney,account, itemsCheckout));

		
		

		model.addAttribute("content", "user/checkout.jsp");
		return "layout/main-user";
	}
}
