package footprint.controller.staff;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import footprint.service.CategoryService;
import footprint.service.OrderService;
import footprint.service.ProductService;


@Controller
public class StaffController {
	
	@Autowired 
	private ProductService productService;  
	
	@Autowired
	private OrderService orderService; 
	
	
	
	@Autowired
	private CategoryService categoryService; 
	
	
	@RequestMapping(value="/staff") 
	public String index(ModelMap model) throws ParseException { 
		model.addAttribute("sizeProducts", productService.getAllProduct().size());   
		model.addAttribute("sizeCategorys",categoryService.getAllCategories().size()); 
		model.addAttribute("sizeOrderDate", orderService.getOrderWithCurentDate().size()); 
		model.addAttribute("sizeOrderMonth", orderService.getOrderWithCurentMonth().size()); 
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/index.jsp");
		
		
		
		return "layout/main-dashboard"; 
	}

}
