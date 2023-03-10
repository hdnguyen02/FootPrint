package footprint.controller.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import footprint.entity.Category;
import footprint.entity.Product;
import footprint.service.CategoryService;
import footprint.service.ProductService;

@Controller
@RequestMapping("staff/product")
public class AddProductController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addProductGet(ModelMap model, @ModelAttribute("product") Product product) {

		// đẩy ra views
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/add-product.jsp");
		return "layout/main-dashboard";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addProductPost(ModelMap model, @ModelAttribute("product") Product product,
			@RequestParam("imageProduct") MultipartFile imageProduct) {

		boolean result = productService.insert(product, imageProduct);
		model.addAttribute("result", result);   

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/add-product.jsp");

		return "layout/main-dashboard";
	}
}
