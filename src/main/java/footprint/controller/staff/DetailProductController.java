package footprint.controller.staff;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.bean.UploadFile;
import footprint.entity.Product;
import footprint.entity.ProductSize;
import footprint.service.ProductService;
import footprint.service.ProductSizeService;

@Controller
@Transactional
public class DetailProductController {

	/*
	 * @Autowired
	 * 
	 * @Qualifier("imageProduct") private UploadFile uploadFile;
	 */

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductSizeService productSizeService; 
	

	@RequestMapping("staff/product/detail")
	public String index(ModelMap model, @RequestParam(value = "id", required = true) Long idProduct) {
		
		

		Product product = productService.getProductWithId(idProduct);
		

		if (product == null) return "general/not-exist"; 

		
		Hibernate.initialize(product.getThumbnails());
		Hibernate.initialize(product.getProductSizes());
		model.addAttribute("product", product);
		// try vấn ra sản phẩm. 
		List<ProductSize> productSizes = productSizeService.getProductSizeWithIdProduct(idProduct);  
		model.addAttribute("productSizes", productSizes);

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/detail-product.jsp");
		return "layout/main-dashboard";
	}
}
