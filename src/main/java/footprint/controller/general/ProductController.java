package footprint.controller.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Category;
import footprint.entity.Product;
import footprint.service.CategoryService;
import footprint.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

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

	@RequestMapping(value = "product", method = RequestMethod.POST)
	public String searchProduct(@ModelAttribute("product") Product product, ModelMap model, @RequestParam("searchProductName") String searchProductName) {
		model.addAttribute("product", new Product());
		List<Product> lstSearch = productService.searchProducts(searchProductName);
		model.addAttribute("productsActive", lstSearch);

		List<Category> lstCategory = categoryService.getAllCategories();
		model.addAttribute("cate", lstCategory);

		return "general/product/index";
	}

	@RequestMapping("product/list-by-category/{cid}")
	public String filterByCategory(ModelMap model, @PathVariable("cid") long idCategory) {		
		List<Product> list = productService.filterByCategory(idCategory);
		model.addAttribute("productsActive", list);
		 
		List<Category> lstCategory = categoryService.getAllCategories();
		model.addAttribute("cate", lstCategory);		 

		return "general/product/index";
	}

}
