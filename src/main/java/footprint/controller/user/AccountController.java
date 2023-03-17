package footprint.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
	@RequestMapping("account") 
	public String showAccount(ModelMap model) {
		model.addAttribute("content", "layout/main-account.jsp"); 
		model.addAttribute("bodyAccount", "user/account-detail.jsp"); 
		return "layout/main-user"; 
	}
}
