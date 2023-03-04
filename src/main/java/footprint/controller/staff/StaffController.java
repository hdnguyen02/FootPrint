package footprint.controller.staff;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StaffController {
	@RequestMapping(value="/staff") 
	public String index(ModelMap model) { 
		
		
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/index.jsp");
		return "layout/main-dashboard"; 
	}
}
