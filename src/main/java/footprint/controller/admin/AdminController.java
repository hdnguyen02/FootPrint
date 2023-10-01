package footprint.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping(value = "admin")
	public String index(ModelMap model) {

		model.addAttribute("sidebarDashboard", "admin/sidebar.jsp");
		model.addAttribute("bodyDashboard", "admin/index.jsp");
		return "layout/main-dashboard";
	}

}
