package footprint.controller.customer;

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

import footprint.entity.Cart;
import footprint.entity.Customer;
import footprint.service.CartService;
import footprint.service.CustomerService;


@Controller
public class CartController {

	@Autowired
	private CustomerService customerService;


	@Autowired
	private CartService cartService;

	@RequestMapping("cart")
	@Transactional
	public String index(ModelMap model, HttpSession session) {

		Integer idCustomer = (Integer) session.getAttribute("idCustomer");
		Customer customer = customerService.getAccountWithId(idCustomer);

		Hibernate.initialize(customer.getCarts());
		model.addAttribute("carts", customer.getCarts());

		model.addAttribute("content", "user/cart.jsp");
		return "layout/main-user";
	}

	@RequestMapping(value = "cart", method = RequestMethod.POST)
	@ResponseBody
	public String edit(HttpSession session, @RequestParam(value = "idCart", required = false) Integer idCart,

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

	/*
	 * @RequestMapping(value = "cart/not-account", method = RequestMethod.GET)
	 * public String cartNotSignIn(ModelMap model, HttpServletRequest request) {
	 * 
	 * List<Cart> carts = new ArrayList<>(); Cookie[] cookies =
	 * request.getCookies();
	 * 
	 * if (cookies != null) { for (Cookie cookie : cookies) { if
	 * (cookie.getName().contains("cart")) { String idCartCookie = cookie.getName();
	 * Cart cart = new Cart(); Long idProductSize =
	 * Long.valueOf(idCartCookie.substring(4)); ProductSize productSize =
	 * productSizeSerice.getProductSizeWithId(idProductSize);
	 * cart.setProductSize(productSize); int quantity =
	 * Integer.valueOf(cookie.getValue()); cart.setQuantity(quantity);
	 * carts.add(cart); } }
	 * 
	 * } model.addAttribute("carts", carts); model.addAttribute("content",
	 * "general/cart.jsp"); return "layout/main-user";
	 * 
	 * }
	 */

}