package footprint.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	@RequestMapping("/cart") 
	public String index(ModelMap model) { 
		
		
		model.addAttribute("content","user/cart.jsp");
		return "layout/main-user";
	}
}
