package footprint.controller.general;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Account;
import footprint.entity.Product;
import footprint.entity.ProductSize;
import footprint.service.CartService;
import footprint.service.ProductService;
import footprint.service.ProductSizeService;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Controller
@Transactional
public class DetailProductxxxController {

	@Autowired
	private ProductService productSerive;
	
	@Autowired
	private ProductSizeService productSizeService; 
	
	@Autowired 
	private CartService cartService; 

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
	public String postIndex(HttpSession session,ModelMap model,
			@RequestParam(value = "id", required = true) Long idProduct, 
			@RequestParam(value = "quantity", required = true) int quantity, 
			@RequestParam(value="radio-size",required = true) String idSize
			) {
		
		
		Product product = productSerive.getProductWithId(idProduct); 
		ProductSize productSize = productSizeService.getProductSize(idProduct, idSize);
		Account account = (Account) session.getAttribute("ACCOUNT"); 
	
		boolean resultAddCart = cartService.addCart(quantity, account, productSize); 
		
		System.out.println(resultAddCart);

		Hibernate.initialize(product.getThumbnails());
		Hibernate.initialize(product.getProductSizes());

		model.addAttribute("product", product);
		model.addAttribute("content", "general/product/detail-product.jsp");

		return "layout/main-user";
	}
}
