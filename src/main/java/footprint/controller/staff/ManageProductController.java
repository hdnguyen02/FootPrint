package footprint.controller.staff;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Category;
import footprint.entity.Product;
import footprint.service.ProductService;
import footprint.service.SizeService;

@Controller
public class ManageProductController {
	
	@Autowired
	private ProductService productService;

	@Autowired SizeService sizeService;
	
	@RequestMapping("staff/product/manage")
	public String index(ModelMap model,
			@RequestParam(value="page", required = false, defaultValue = "1") int page,
			@ModelAttribute("category") Category category) { 
		
		// lấy toàn bộ danh sách ra
		List<Product> products = productService.getAllProduct(); 
		
		// quy định ra số lượng page 
		int productPerPage = 8;  
		// tính toán số lượng perpage
		int totalPage = productService.computedTotalPage(products, productPerPage);

		List<Product> productsWithPage = productService.getProductPerPage(products, productPerPage, page);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("productsWithPage",productsWithPage);
		
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/manage-product.jsp");
		return "layout/main-dashboard";
	}
}
