package footprint.controller.customer;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Cart;
import footprint.service.CartService;

@Controller
public class CheckoutController {
	
	@Autowired
	private CartService cartService; 
	
	@RequestMapping(value="checkout",method = RequestMethod.POST)
	public String index(HttpSession session,ModelMap model,
			@RequestParam(value="items-checkout",required = true) Integer [] idCartsCheckout) { 
		
		List<Cart> carts = cartService.getCartsWithIds(idCartsCheckout); 
		float totalMonney = cartService.computedTotalMonney(carts); 
		model.addAttribute("totalMonney", totalMonney);
		model.addAttribute("carts", carts);
		model.addAttribute("content", "user/checkout.jsp");
		return "layout/main-user";
	} 
}
