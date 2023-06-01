package footprint.controller.general;

import java.io.Console;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Category;
import footprint.entity.Product;
import footprint.service.CartService;
import footprint.service.CategoryService;
import footprint.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CartService cartService; 

	@RequestMapping("product")
	public String index(ModelMap model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		int productPerPage = 12;
		List<Product> products = productService.getProductsActive(); 
		model.addAttribute("totalPage", productService.computedTotalPage(products, productPerPage));
		model.addAttribute("productsActive", productService.getProductPerPage(products, productPerPage, page));

		List<Category> lstCategory = categoryService.getAllCategories();
		model.addAttribute("cate", lstCategory);

		return "general/product/index";
	}
	
	
	@RequestMapping("product/detail")
	@Transactional
	public String index(@RequestParam(value = "id", required = true) String idProduct, ModelMap model) {

		Product product = productService.getProductCurentSS(idProduct);
		Hibernate.initialize(product.getThumbnails());
		model.addAttribute("product", product);
		model.addAttribute("content", "general/product/detail-product.jsp");
		return "layout/main-user";
	}
	
	
	// Nhấp thêm vào giỏ hàng nè. 
	
	@RequestMapping(value="product/detail",method=RequestMethod.POST)
	public String postIndex(HttpSession session,ModelMap model,HttpServletResponse response,HttpServletRequest request, 
			@RequestParam(value = "id", required = true) String idProduct, 
			@RequestParam(value = "quantity", required = true) Integer quantity
			) {
		 
		
		Integer idCustomer = (Integer)session.getAttribute("idCustomer");   
		
		try { 
			cartService.addCart(idProduct,idCustomer,quantity);  
			model.addAttribute("result", true);
		
		}
		catch (Exception e) {
			model.addAttribute("result", false);
			
		}
		
		Product product = productService.getProductCurentSS(idProduct); 
		Hibernate.initialize(product.getThumbnails());
		model.addAttribute("product", product);
		model.addAttribute("content", "general/product/detail-product.jsp");
		return "layout/main-user";
	}
	
	

	/*
	 * @RequestMapping(value = "product", method = RequestMethod.POST) public String
	 * searchProduct(@ModelAttribute("product") Product product, ModelMap
	 * model, @RequestParam("searchProductName") String searchProductName) {
	 * model.addAttribute("product", new Product()); List<Product> lstSearch =
	 * productService.searchProducts(searchProductName);
	 * model.addAttribute("productsActive", lstSearch);
	 * 
	 * List<Category> lstCategory = categoryService.getAllCategories();
	 * model.addAttribute("cate", lstCategory);
	 * 
	 * return "general/product/index"; }
	 * 
	 * @RequestMapping("product/list-by-category/{cid}") public String
	 * filterByCategory(ModelMap model, @PathVariable("cid") long idCategory) {
	 * List<Product> list = productService.filterByCategory(idCategory);
	 * model.addAttribute("productsActive", list);
	 * 
	 * List<Category> lstCategory = categoryService.getAllCategories();
	 * model.addAttribute("cate", lstCategory);
	 * 
	 * return "general/product/index"; }
	 */

}