package footprint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import footprint.service.UserService;

@Controller
public class hiberController {
	
	@Autowired
	UserService userService;
	
	
	
	
	
	@RequestMapping(value="/hiber")
	public String index(ModelMap model) {
		
		model.addAttribute("users", userService.getUsers()); 
		
		
		
		return "hiber";
	}
	
	
}
