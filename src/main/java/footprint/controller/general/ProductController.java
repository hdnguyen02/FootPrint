package footprint.controller.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Product;
import footprint.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService; 
	
	@RequestMapping(value = "product")
	public String index(ModelMap model,
		   @RequestParam(value="page", required = false, defaultValue = "1") int page
			) {
		
		int productPerPage = 12; 
		List<Product> products = productService.getProductsActive();
		model.addAttribute("totalPage", productService.computedTotalPage(products, productPerPage));
		model.addAttribute("productsActive", productService.getProductPerPage(products, productPerPage, page));
	
	
		return "general/product/index"; 
	}
}
