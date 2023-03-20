package footprint.controller.general;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Account;
import footprint.service.AccountService;

@Controller
public class SignInController {
	@Autowired 
	AccountService userService;
	@RequestMapping(value="sign-in")
	public String Getlogin(ModelMap model) {
		model.addAttribute("content", "general/sign-in.jsp"); 
		model.addAttribute("nameBreadcrumb", "login"); 
		
		return "layout/main-login-register"; 
	}
	
	@RequestMapping(value="sign-in",method = RequestMethod.POST)
	public String Postlogin(ModelMap model,HttpSession session,
			@RequestParam("username") String username,@RequestParam("password") String password) 
	{
		Account account = userService.getAccountByUsername(username);
	
		if (account == null || !BCrypt.checkpw(password,account.getPassword())) { 
			
			
			model.addAttribute("resultLogin", "Tài khoản hoặc mật khẩu không tồn tại"); 
			model.addAttribute("content", "general/sign-in.jsp"); 
			model.addAttribute("nameBreadcrumb", "login"); 
			return "layout/main-login-register"; 
		}
		
		// kiểm tra role
		session.setAttribute("ACCOUNT", account);
		if (account.getRole().getIdRole().equals("USER")  ) { 
			session.setAttribute("ROLE", "USER");
		}
		else if (account.getRole().getIdRole().equals("STAFF") ) {
			session.setAttribute("ROLE", "STAFF");
		}
		else if (account.getRole().getIdRole().equals("ADMIN") ) {
			session.setAttribute("ROLE", "ADMIN");
		}
	
		
		return "redirect:/";
		
		
		
		 
		 
		
	}
}
