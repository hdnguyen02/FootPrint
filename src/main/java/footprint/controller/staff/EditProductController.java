package footprint.controller.staff;

import java.util.Date;
import java.util.Enumeration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Category;
import footprint.entity.Color;
import footprint.entity.Product;
import footprint.entity.ProductSize;

import footprint.service.CategoryService;
import footprint.service.ColorService;
import footprint.service.ProductService;
import footprint.service.ProductSizeService;

@Controller
@Transactional
public class EditProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductSizeService productSizeService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ColorService colorService;

	@RequestMapping(value = "staff/product/edit", method = RequestMethod.GET)
	public String index(ModelMap model, @RequestParam(value = "id", required = true) Long idProduct) {

		Product product = productService.getProductWithOpenSS(idProduct);
		if (product == null)
			return "general/not-exist";
		model.addAttribute("product", product);
		List<ProductSize> productSizes = productSizeService.getProductSizeWithIdProduct(idProduct);
		model.addAttribute("productSizes", productSizes);
		List<Category> categorys = categoryService.getAllCategories();
		model.addAttribute("categorys", categorys);
		List<Color> colors = colorService.getAllColors();
		model.addAttribute("colors", colors);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/edit-product.jsp");
		return "layout/main-dashboard";

	}

	// lúc postl lên tại đây.
	@RequestMapping(value = "staff/product/edit", method = RequestMethod.POST)
	public String postIndex(ModelMap model,@ModelAttribute("product") Product product, HttpServletRequest request,
			@RequestParam("id") Long idProduct) {
		Product productOld = productService.getProductWithId(idProduct); 
		product.setIdProduct(productOld.getIdProduct()); 
		product.setCreateAt(productOld.getCreateAt()); 
		product.setImageName(productOld.getImageName()); 
		product.setUpdateAt(new Date()); 
		
		Map<Long, Integer> psMap = new LinkedHashMap<>();
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			if (paramName.startsWith("id-ps-")) {
				Long idProductSize = Long.valueOf(paramName.substring(6)); 
				Integer quantityUpdate = Integer.valueOf(request.getParameter(paramName)); 
				psMap.put(idProductSize, quantityUpdate); 
			}
		}
		
		boolean result = productService.updateQuantityProducts(product, psMap);
		model.addAttribute("result", result); 
		List<ProductSize> productSizes = productSizeService.getProductSizeWithIdProduct(idProduct);
		model.addAttribute("productSizes", productSizes);
		List<Category> categorys = categoryService.getAllCategories();
		model.addAttribute("categorys", categorys);
		List<Color> colors = colorService.getAllColors();
		model.addAttribute("colors", colors);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/edit-product.jsp");
		return "layout/main-dashboard";

	}
	


}
