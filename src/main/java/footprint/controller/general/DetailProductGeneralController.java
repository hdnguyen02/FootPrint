package footprint.controller.general;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Account;
import footprint.entity.Cart;
import footprint.entity.Product;
import footprint.entity.ProductSize;
import footprint.helper.CookieHelper;
import footprint.service.AccountService;
import footprint.service.CartService;
import footprint.service.ProductService;
import footprint.service.ProductSizeService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Controller
@Transactional
public class DetailProductGeneralController {

	@Autowired
	private ProductService productSerive;
	
	@Autowired
	private ProductSizeService productSizeService; 
	
	@Autowired 
	private CartService cartService; 
	
	@Autowired
	private AccountService accountService; 
	
	@Autowired 
	private CookieHelper cookieHelper; 
	

	@RequestMapping("product/detail")
	public String index(@RequestParam(value = "id", required = true) Long idProduct, ModelMap model) {

		Product product = productSerive.getProductWithId(idProduct);

		Hibernate.initialize(product.getThumbnails());
		Hibernate.initialize(product.getProductSizes());

		model.addAttribute("product", product);
		model.addAttribute("content", "general/product/detail-product.jsp");

		return "layout/main-user";
	}
	
	@RequestMapping(value="product/detail",method=RequestMethod.POST)
	public String postIndex(HttpSession session,ModelMap model,HttpServletResponse response,HttpServletRequest request, 
			@RequestParam(value = "id", required = true) Long idProduct, 
			@RequestParam(value = "quantity", required = true) Integer quantity, 
			@RequestParam(value="radio-size",required = true) String idSize
			) {
		

		Product product = productSerive.getProductWithId(idProduct); 
		ProductSize productSize = productSizeService.getProductSize(idProduct, idSize);
		
		Long idAccount= (Long)session.getAttribute("idAccount");   
		// kiem tra xem no da ton tai chua 
		
		
		if (idAccount == null) { 
			Boolean tonTai = false; 
			
			
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
			    for (Cookie cookie : cookies) {
			    	// 
			    	String idCart = "cart" + productSize.getIdProductSize().toString(); 
			        if (idCart.equals(cookie.getName())) { // Kiểm tra tên cookie
			        	System.out.println(quantity);
			        	int quantityCurent = Integer.valueOf(cookieHelper.getValue(request, cookie.getName())) + quantity; 
			        	cookie.setValue(String.valueOf(quantityCurent)); 
			        	cookie.setMaxAge(365 * 24 * 60 * 60);
					    String contextPath = request.getContextPath(); 
					    cookie.setPath(contextPath); 
						response.addCookie(cookie);
			            tonTai = true; 
			            break;
			        }
			    }
			}
			if (tonTai == false) {  
				Cookie cart = new Cookie("cart" + productSize.getIdProductSize().toString(),quantity.toString()); //bake cookies
				cart.setMaxAge(365 * 24 * 60 * 60);
			    String contextPath = request.getContextPath(); 
			    cart.setPath(contextPath); 
				response.addCookie(cart);
			}
		}
		else { 
			Account account = accountService.getAccountWithId(idAccount); 
			
			
			Cart cartIsExist = accountService.getCart(idAccount, productSize.getIdProductSize()); 
			if (cartIsExist != null) { 
				cartIsExist.setQuantity(cartIsExist.getQuantity() + quantity); 
				cartService.updateCart(cartIsExist);
			}
			else {
				cartService.addCart(quantity, account, productSize); 
			}
		}
		
		

	
		Hibernate.initialize(product.getThumbnails());
		Hibernate.initialize(product.getProductSizes());

		model.addAttribute("product", product);
		model.addAttribute("content", "general/product/detail-product.jsp");

		return "layout/main-user";
	}
}
