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
import org.springframework.web.bind.annotation.ResponseBody;

import footprint.entity.Account;
import footprint.entity.Cart;
import footprint.service.AccountService;
import footprint.service.CartService;

@Controller
@Transactional
public class CartController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private CartService cartService;

	@RequestMapping("cart")
	public String index(ModelMap model, HttpSession session) {

		Long idAccount = (Long) session.getAttribute("idAccount");

		Account account = accountService.getAccountWithId(idAccount);

		Hibernate.initialize(account.getCarts());

		model.addAttribute("carts", account.getCarts());

		model.addAttribute("content", "user/cart.jsp");
		return "layout/main-user";
	}

	
	@RequestMapping(value = "cart", method = RequestMethod.POST)
	@ResponseBody
	public String edit(HttpSession session,
			@RequestParam(value = "idCart", required = false) Long idCart,
			@RequestParam(value = "quantityUpdate", required = false) Integer quantityUpdate,
			@RequestParam(value = "isDelete", required = false) Boolean isDelete
			) {
		
	
		if (quantityUpdate != null) {
			Cart cart = cartService.getCartWithId(idCart);
			cart.setQuantity(quantityUpdate);
			cartService.updateCart(cart);
		}
		else if (isDelete) {
			cartService.deleteCart(idCart);
		}
		
		

		
		return "edit cart";
	}


}
