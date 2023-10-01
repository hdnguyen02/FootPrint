package footprint.controller.staff;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Category;
import footprint.entity.Product;
import footprint.service.CategoryService;
import footprint.service.ProductService;

@Controller
public class ProductStaffController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("staff/list-product")
	public String index(HttpSession session,ModelMap model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {	
		if (session.getAttribute("resultEditProduct") != null) {
			model.addAttribute("result",(Boolean)session.getAttribute("resultEditProduct") );
			model.addAttribute("success", "Hiệu chỉnh sản phẩm thành công");
			model.addAttribute("failure", "Đã xảy ra lỗi!!!");
			session.removeAttribute("resultEditProduct"); 
		}
		List<Product> products = productService.getAllProducts();							
		int productPerPage = 5;
		int totalPage = productService.computedTotalPage(products, productPerPage);

		List<Product> productsWithPage = productService.getProductPerPage(products, productPerPage, page);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("productsWithPage", productsWithPage);

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/manage-product.jsp");
		return "layout/main-dashboard";
	}

	@RequestMapping("staff/edit-product")
	public String index(ModelMap model, @RequestParam(value = "id", required = true) String idProduct) {
		Product product = productService.getProductCurentSS(idProduct);
		if (product == null)
			return "general/not-found";
		model.addAttribute("product", product);
		List<Category> categorys = categoryService.getAllCategories();
		model.addAttribute("categorys", categorys);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/edit-product.jsp");
		return "layout/main-dashboard";
	}

	// lúc postl lên tại đây.

	@RequestMapping(value = "staff/edit-product", method = RequestMethod.POST)
	public String postIndex(HttpSession session,ModelMap model, @ModelAttribute("product") Product product) {
		boolean result = productService.update(product);
		session.setAttribute("resultEditProduct", result);  
		return "redirect:/staff/list-product.htm";
	}
}
