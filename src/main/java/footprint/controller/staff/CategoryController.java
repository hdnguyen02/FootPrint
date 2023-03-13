package footprint.controller.staff;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Category;
import footprint.service.CategoryService;




@Controller

public class CategoryController {
	
	@Autowired
	CategoryService categoryService; 
	
	
	@RequestMapping("staff/category")
	public String index(@RequestParam(value="page", required = false, defaultValue = "1") int page,ModelMap model,
			@ModelAttribute("category") Category category) { 

		
		List<Category> categoriesPerPage = categoryService.getCategoriesPerPage(page); 
		model.addAttribute("totalPage", categoryService.totalPage());
		model.addAttribute("categoriesPerPage",categoriesPerPage);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/category.jsp");
		return "layout/main-dashboard";
	}
	
	// sử lý hành động thêm category 
	@RequestMapping(value="staff/category/add",method = RequestMethod.POST) 
	public String addCategory(ModelMap model,@ModelAttribute("category") Category category) { 
		boolean resultAddCategory = categoryService.insert(category);
		model.addAttribute("resultAddCategory", resultAddCategory); 	
		return "forward:/staff/category";
		
	}
	
	
	@RequestMapping(value="staff/category/edit",method = RequestMethod.POST) 
	public String editCategory(ModelMap model,@ModelAttribute("category") Category category) {
		
		System.out.println(categoryService.update(category));

		/*
		 * boolean resultEdit = categoryService.update(category);
		 * 
		 * model.addAttribute("resultEdit", resultEdit);
		 */
		
		return "forward:/staff/category";
		
	}
	
	

	
}
