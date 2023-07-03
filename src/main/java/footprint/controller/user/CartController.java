package footprint.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
import footprint.entity.ProductSize;
import footprint.service.AccountService;
import footprint.service.CartService;
import footprint.service.ProductSizeService;

@Controller
@Transactional
public class CartController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ProductSizeService productSizeSerice;

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
	public String edit(HttpSession session, @RequestParam(value = "idCart", required = false) Long idCart,
			@RequestParam(value = "quantityUpdate", required = false) Integer quantityUpdate,
			@RequestParam(value = "isDelete", required = false) Boolean isDelete) {

		if (quantityUpdate != null) {
			Cart cart = cartService.getCartWithId(idCart);
			cart.setQuantity(quantityUpdate);
			cartService.updateCart(cart);
		} else if (isDelete) {
			cartService.deleteCart(idCart);
		}
		return "edit cart";
	}

	@RequestMapping(value = "cart/not-account", method = RequestMethod.GET)
	public String cartNotSignIn(ModelMap model, HttpServletRequest request) {

		List<Cart> carts = new ArrayList<>();
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().contains("cart")) {
					String idCartCookie = cookie.getName();
					Cart cart = new Cart();
					Long idProductSize = Long.valueOf(idCartCookie.substring(4));
					ProductSize productSize = productSizeSerice.getProductSizeWithId(idProductSize);
					cart.setProductSize(productSize);
					int quantity = Integer.valueOf(cookie.getValue());
					cart.setQuantity(quantity);
					carts.add(cart);
				}
			}

		}
		model.addAttribute("carts", carts);
		model.addAttribute("content", "general/cart.jsp");
		return "layout/main-user";

	}
}