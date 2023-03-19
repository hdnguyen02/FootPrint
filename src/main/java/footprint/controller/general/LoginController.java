package footprint.controller.general;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Account;
import footprint.service.UserService;

@Controller
public class LoginController {
	@Autowired 
	UserService userService;
	@RequestMapping(value="login")
	public String Getlogin(ModelMap model) {
		model.addAttribute("content", "general/login.jsp"); 
		model.addAttribute("nameBreadcrumb", "login"); 
		
		return "layout/main-login-register"; 
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String Postlogin(ModelMap model,
			@RequestParam("username") String username,@RequestParam("password") String password) 
	{
		Account account = userService.getUserByUsername(username);
	
		if (account != null && BCrypt.checkpw(password,account.getPassword())) { 
			
			
			
			
			return "redirect:/";
			
		}
		
		
		model.addAttribute("resultLogin", "Tài khoản hoặc mật khẩu không tồn tại"); 
		model.addAttribute("content", "general/login.jsp"); 
		model.addAttribute("nameBreadcrumb", "login"); 
		return "layout/main-login-register"; 
		
		 
		 
		
	}
}
