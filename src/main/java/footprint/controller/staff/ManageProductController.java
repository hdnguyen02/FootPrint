package footprint.controller.staff;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

		
		List<Product> productsPerPage = productService.getProductsPerPage(page); 
		model.addAttribute("totalPage", productService.totalPage());
		model.addAttribute("productsPerPage",productsPerPage);
		
		
	
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/manage-product.jsp");
		return "layout/main-dashboard";
	}
	
	
	@RequestMapping("staff/product-size")
	public String productSize(ModelMap  model,@RequestParam("id") Long idProduct) {
		
		// tri vấn ra product -> render ra -> đồng thời render cả thằng ấy ra.
		
		// chưa bắc trường hợp có tồn tại product đó không.
		
		Product product = productService.getProductWithId(idProduct);
		model.addAttribute("product", product);
		
		
		
		
		
		// Ngoài ra còn lấy thông tin về số lượng của product
		
		
		model.addAttribute("sizes", sizeService.getAllSizes());
		

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/product-size.jsp");
		return "layout/main-dashboard";
	}
	
	@RequestMapping(value="staff/product-size",method=RequestMethod.POST)
	public String postProductSize(HttpServletRequest request,ModelMap  model,@RequestParam("id") Long idProduct) {
	
	
		System.out.println(request.getParameter("size35"));
		
		
		
		Product product = productService.getProductWithId(idProduct);
		model.addAttribute("product", product);
		

		
		
		model.addAttribute("sizes", sizeService.getAllSizes());
		

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/product-size.jsp");
		return "layout/main-dashboard";
	}
	
	
	
	
}
