package footprint.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	@RequestMapping(value = "product")
	public String index(ModelMap model) {
		/* model.addAttribute("content","general/product/index.jsp"); */
		return "general/product/index"; 
	}
}
