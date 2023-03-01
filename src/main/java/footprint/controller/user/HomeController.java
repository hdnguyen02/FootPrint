package footprint.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	@RequestMapping("/") 
	public String index (ModelMap model) {
		
		model.addAttribute("content", "home/index"); 
		return "layout/main";
	}

}
