package footprint.controller.staff;

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
import footprint.service.ProductService;

@Controller
@Transactional
public class DetailProductController {

	@Autowired
	@Qualifier("imageProduct")
	private UploadFile uploadFile;

	@Autowired
	private ProductService productService;

	@RequestMapping("staff/product/detail")
	public String index(ModelMap model, @RequestParam(value = "id", required = true) Long idProduct) {

		Product product = productService.getProductWithId(idProduct);
		Hibernate.initialize(product.getThumbnails());
		Hibernate.initialize(product.getProductSizes());
		model.addAttribute("product", product);

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/detail-product.jsp");
		return "layout/main-dashboard";
	}
}
