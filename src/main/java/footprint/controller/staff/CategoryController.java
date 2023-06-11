package footprint.controller.staff;

import java.util.List;


import javax.servlet.http.HttpSession;

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
	private CategoryService categoryService;

	@RequestMapping("staff/list-category")
	public String index(HttpSession session, ModelMap model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		if (session.getAttribute("resultEditCategory") != null) {
			model.addAttribute("result", (Boolean) session.getAttribute("resultEditCategory"));
			model.addAttribute("success", "Cập nhập danh mục thành công");
			model.addAttribute("failure", "Đã xảy ra lỗi!!!");
			session.removeAttribute("resultEditCategory");
		}
		if (session.getAttribute("addCategory") != null) {
			model.addAttribute("result", (Boolean) session.getAttribute("addCategory"));
			model.addAttribute("success", "thêm danh mục thành công");
			model.addAttribute("failure", "Đã xảy ra lỗi!!!");
			session.removeAttribute("resultEditCategory");
		}
		List<Category> categoriesPerPage = categoryService.getCategoriesPerPage(page);
		model.addAttribute("totalPage", categoryService.totalPage());
		model.addAttribute("categoriesPerPage", categoriesPerPage);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/category.jsp");
		return "layout/main-dashboard";
	}

	@RequestMapping("staff/edit-category")
	public String index(ModelMap model, @RequestParam(value = "id", required = true) String idCategory) {
		Category category = categoryService.getCategoryWithId(idCategory);
		if (category == null)
			return "general/not-found";
		model.addAttribute("category", category);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/edit-category.jsp");
		return "layout/main-dashboard";

	}

	// lúc postl lên tại đây.

	@RequestMapping(value = "staff/edit-category", method = RequestMethod.POST)
	public String postIndex(HttpSession session, ModelMap model, @ModelAttribute("category") Category category) {
		boolean result = categoryService.update(category);
		session.setAttribute("resultEditCategory", result);
		return "redirect:/staff/list-category.htm";
	}

	@RequestMapping("staff/add-category")
	public String addCategory(ModelMap model) {
		Category category = new Category();
		model.addAttribute("category", category);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/add-category.jsp");
		return "layout/main-dashboard";

	}

	@RequestMapping(value = "staff/add-category", method = RequestMethod.POST)
	public String postAddCategory(HttpSession sesson,ModelMap model,@ModelAttribute("category") Category category) {
		boolean result =  categoryService.insert(category); 
		sesson.setAttribute("addCategory", result);
		return "redirect:/staff/list-category.htm";
	}

}
