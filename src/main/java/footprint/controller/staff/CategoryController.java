package footprint.controller.staff;

import java.util.Date;
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
	public String index(@RequestParam(value = "page", required = false, defaultValue = "1") int page, ModelMap model,
			@ModelAttribute("category") Category category) {

		List<Category> categoriesPerPage = categoryService.getCategoriesPerPage(page);
		model.addAttribute("totalPage", categoryService.totalPage());
		model.addAttribute("categoriesPerPage", categoriesPerPage);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/category.jsp");
		return "layout/main-dashboard";
	}

	@RequestMapping(value = "staff/category/add", method = RequestMethod.GET)
	public String addCategory(ModelMap model) {

		Category category = new Category();
		model.addAttribute("category", category);

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/add-category.jsp");
		return "layout/main-dashboard";

	}

	@RequestMapping(value = "staff/category/add", method = RequestMethod.POST)

	public String postAddCategory(ModelMap model, @ModelAttribute("category") Category category) {
		boolean result = categoryService.insert(category);
		model.addAttribute("result", result);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/add-category.jsp");
		return "layout/main-dashboard";

	}
	
	@RequestMapping(value = "staff/category/edit", method = RequestMethod.GET)
	public String editCategory(ModelMap model,@RequestParam("id") Long idCategory) {
		Category category = categoryService.getCategoryWithId(idCategory); 
		if (category == null) return "general/not-exist"; 
		model.addAttribute("category", category);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/edit-category.jsp");
		return "layout/main-dashboard";
	}
	
	@RequestMapping(value = "staff/category/edit", method = RequestMethod.POST)
	public String postEditCategory(ModelMap model,@RequestParam("id") Long idCategory, 
			@ModelAttribute("category") Category category) {
		
		Category categoryOld = categoryService.getCategoryWithId(idCategory); 
		category.setIdCategory(categoryOld.getIdCategory()); 
		category.setCreateAt(categoryOld.getCreateAt()); 
		category.setUpdateAt(new Date()); 
		
		boolean result = categoryService.update(category);
		model.addAttribute("result", result);
		

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/edit-category.jsp");
		return "layout/main-dashboard";

	}


}
