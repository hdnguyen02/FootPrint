package footprint.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import footprint.entity.User;

@Controller
public class RegisterController {
	@RequestMapping("register")
	public String getRegister(ModelMap model,@ModelAttribute("user") User user) { 
			
		model.addAttribute("content", "general/register.jsp"); 
		return "layout/main-login-register";
	}
	
	@RequestMapping(value="confirm")
	public String postRegister(ModelMap model,@ModelAttribute("user") User user) { 
		
	
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		model.addAttribute("content", "user/confirm.jsp");
		return "layout/main-login-register";
	}

}
