package footprint.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Account;
import footprint.entity.Cart;
import footprint.entity.ProductSize;
import footprint.service.AccountService;
import footprint.service.CartService;
import footprint.service.OrderService;
import footprint.service.ProductSizeService;

@Controller
public class CheckoutController {
	
	@Autowired
	private AccountService accountSerive; 
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductSizeService productSizeService; 
		
	@Autowired
	private OrderService orderService; 
	
	@RequestMapping(value="checkout",method = RequestMethod.POST)
	public String index(HttpSession session,ModelMap model,
			@RequestParam(value="items-checkout",required = true) Long [] idCartsCheckout) { 
		
		Long idAccount = (Long) session.getAttribute("idAccount"); 
		Account account = accountSerive.getAccountWithId(idAccount);
		List<Cart> carts = cartService.getCartsWithIds(idCartsCheckout); 
		float totalMonney = cartService.computedTotalMonney(carts); 
		
		model.addAttribute("account", account);
		model.addAttribute("carts", carts);
		model.addAttribute("totalMonney", totalMonney);
		
		model.addAttribute("content", "user/checkout.jsp");
		return "layout/main-user";
	} 
	

	@RequestMapping(value="checkout/not-account",method = RequestMethod.POST)  
	public String checkoutNotAccount(ModelMap model,HttpServletRequest request,
			@RequestParam(value="items-checkout",required = true) Long [] idProductSizes) { 
		
		
		List<Cart> carts = new ArrayList<>(); 
		Cookie[] cookies = request.getCookies();
		// lấy ra các Prosize trong này
		if (cookies != null) { 
			
			for (Long idProductSize : idProductSizes) {
				
				// lấy ra số lượng tương với prductSize 
				
				
				for (Cookie cookie : cookies) { 
					String cookieName = cookie.getName(); 
					
					if (cookieName.equals("cart" + String.valueOf(idProductSize))) { 
						// tìm productSize đó 
						ProductSize productSize = productSizeService.getProductSizeWithId(idProductSize); 
						Cart cart = new Cart(); 
						cart.setProductSize(productSize); 
						cart.setQuantity(Integer.valueOf(cookie.getValue())); 
						carts.add(cart); 
					}
				}
			}
		
			
		}
		
		model.addAttribute("totalMonney", cartService.computedTotalMonney(carts)); 
		model.addAttribute("carts", carts); 
		model.addAttribute("content", "general/checkout.jsp");
		return "layout/main-user";
	}
	
	
	
	@RequestMapping(value="handle-order/not-account",method = RequestMethod.POST)
	public String postOrder(ModelMap model,
			@RequestParam(value="items-checkout",required = true) String [] idPSAndQuantitys, 
			@RequestParam(value="first-name",required = true) String firstName,
			@RequestParam(value="last-name",required = true) String lastName,
			@RequestParam(value="email",required = true) String email, 
			@RequestParam(value="phone",required = true) String phone,
			@RequestParam(value="address",required = true) String address,
			@RequestParam(value="message",required = true) String message, 
			@RequestParam(value="total-monney",required = true) Float totalMoney
			) { 
	
		
		
		
		boolean resultCreateOrder = orderService.createOrderAndOrderDetailNotAccount(firstName, lastName, email, phone, address, message, totalMoney,idPSAndQuantitys);
		
		if (resultCreateOrder == false) {
			System.out.println("Sảy ra lỗi khi thêm đặt hàng");
		}
		model.addAttribute("content", "general/handle-order.jsp");
		return "layout/main-user";
	}


}
