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
import footprint.entity.Thumbnail;
import footprint.service.CategoryService;
import footprint.service.ProductService;

@Controller
public class DashboardController {

	@Autowired
	private CategoryService categorySv;
	@Autowired
	private ProductService productSv;

	@RequestMapping("/staff")
	public String dashboard(ModelMap model) {

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/index.jsp");
		return "layout/main-dashboard";
	}

	@RequestMapping(value = "/staff/add-product", method = RequestMethod.GET)
	public String addProduct(ModelMap model) {
		List<Category> categories = categorySv.getAllCategories();
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categories);

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/add-product.jsp");

		return "layout/main-dashboard";
	}

	@RequestMapping(value = "/staff/add-product", method = RequestMethod.POST)
	public String addProductPost(ModelMap model, @ModelAttribute("product") Product product,
			@RequestParam("imageProduct") MultipartFile imageProduct,
			@RequestParam("imageThumbnails") MultipartFile[] imageThumbnails) {

		product.setQuantity(0);
		List<Category> categories = categorySv.getAllCategories();
		Thumbnail[] thumbnails = new Thumbnail[imageThumbnails.length];
		boolean result = productSv.addProductAndThumbnail(product, imageProduct, thumbnails, imageThumbnails);
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categories);
		model.addAttribute("result", result);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/add-product.jsp");
		return "layout/main-dashboard";
	}
	
	// nhập hàng.  
	

}
