package footprint.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
	@RequestMapping("register")
	public String register(ModelMap model) { 
		
		
		
		model.addAttribute("content", "general/register.jsp"); 
		return "layout/main-login-register";
	}
}
