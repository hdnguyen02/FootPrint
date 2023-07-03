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
import org.springframework.web.multipart.MultipartFile;

import footprint.entity.Category;
import footprint.entity.Color;
import footprint.entity.Product;
import footprint.entity.Size;
import footprint.entity.Thumbnail;
import footprint.service.CategoryService;
import footprint.service.ColorService;
import footprint.service.ProductService;
import footprint.service.SizeService;


@Controller
@RequestMapping("staff/product")
public class AddProductController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;
	
	@Autowired 
	private SizeService sizeService;
	
	@Autowired 
	private ColorService colorService;
	

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addProductGet(ModelMap model) {
		
		// cần phải đẩy số lượng size qua 
		List<Size> sizes = sizeService.getAllSizes(); 
		model.addAttribute("sizes", sizes);
		
		model.addAttribute("product", new Product());
		return ControllerToView(model);
		
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addProductPost(HttpServletRequest request, ModelMap model, @ModelAttribute("product") Product product,
			@RequestParam("imageProduct") MultipartFile imageProduct,
			@RequestParam("imageThumbnails") MultipartFile[] imageThumbnails ) {
		
		
	
		List<Size> sizes = sizeService.getAllSizes(); 
		model.addAttribute("sizes", sizes); 
	
		int [] sizesQuantity = new int[sizes.size()]; 
		
		int index = 0; 
		for (Size size : sizes) {
			try {
				sizesQuantity[index] = Integer.parseInt(request.getParameter(size.getIdSize()));   
			}
			catch (Exception e) {
				sizesQuantity[index] = 0;
			}
			index++;
	
		}

		
		Thumbnail [] thumbnails = new Thumbnail[imageThumbnails.length];
		boolean result = productService.addProductThumbnailsProductSize(product,imageProduct, thumbnails, imageThumbnails, sizes,sizesQuantity);
		model.addAttribute("result", result);
		
		
		product.setName(null);
		product.setDescription(null);
		product.setCost(null);	
		product.setColor(null);
		product.setCategory(null);
		
	
		return ControllerToView(model);
	}
	
	// trả ra giống nhau trong AddProduct 
	private String ControllerToView(ModelMap model) {
		List<Category> categories = categoryService.getAllCategories();
		
		List<Color> colors = colorService.getAllColors(); 
		
		model.addAttribute("categories", categories);
		model.addAttribute("colors",colors); 
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/add-product.jsp");
		return "layout/main-dashboard";
	}
}
