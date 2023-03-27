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
@RequestMapping("staff/product")
public class AddProductController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;
	
	/*
	 * @Autowired private ThumbnailService thumbnailService;
	 */
	
	/*
	 * @Autowired private SizeService sizeService;
	 */

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addProductGet(ModelMap model) {

		model.addAttribute("product", new Product());
		return ControllerToView(model);
		
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addProductPost(ModelMap model, @ModelAttribute("product") Product product,
			@RequestParam("imageProduct") MultipartFile imageProduct,
			@RequestParam("imageThumbnails") MultipartFile[] imageThumbnails ) {
		
		
		/*
		 * Product newProduct = productService.insert(product, imageProduct);
		 * 
		 * if (newProduct != null) { // Product đã thêm thành công -> tiếp tục thêm
		 * thumbnail for (MultipartFile file : thumbnailProduct) { Thumbnail thumbnail =
		 * new Thumbnail(); thumbnailService.insert(thumbnail, file, newProduct); }
		 * model.addAttribute("result", true); } else { model.addAttribute("result",
		 * false); }
		 */
		
		
		Thumbnail [] thumbnails = new Thumbnail[imageThumbnails.length];
		
	
		boolean result = productService.addProductAndThumbnails(product, imageProduct, thumbnails, imageThumbnails);
		
		model.addAttribute("result", result);
		
		product.setName(null);
		product.setDescription(null);
		product.setCost(null);
		

		return ControllerToView(model);
	}
	
	// trả ra giống nhau trong AddProduct 
	private String ControllerToView(ModelMap model) {
		List<Category> categories = categoryService.getAllCategories();
		
		model.addAttribute("categories", categories);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/add-product.jsp");
		return "layout/main-dashboard";
		
	}
	
	
	// viết 1 hàm tại đây -> try catch 3 thằng -> nếu lỗi sảy ra không thêm thằng nào cả. 
	/*
	 * private boolean insertProductThumbnailProductSize() { return true; }
	 */
}
