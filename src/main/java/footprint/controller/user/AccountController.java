package footprint.controller.user;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Account;
import footprint.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService userService; 
	
	
	@RequestMapping("account") 
	public String dashboard(ModelMap model,HttpSession session) {
		
	
		Long idAccount = (Long)session.getAttribute("idAccount");
		Account user = userService.getAccountWithId(idAccount);
		
		model.addAttribute("username", user.getUsername());
		model.addAttribute("content", "layout/main-account.jsp");
		model.addAttribute("bodyAccount", "user/dashboard.jsp"); 
		return "layout/main-user"; 
	}
	

	@RequestMapping("account/detail") 
	public String getDetailAccount(ModelMap model,HttpSession session) {
		Long idAccount = (Long)session.getAttribute("idAccount");
		Account user = userService.getAccountWithId(idAccount); 
		model.addAttribute("user", user);
		
		model.addAttribute("content", "layout/main-account.jsp"); 
		model.addAttribute("bodyAccount", "user/account-detail.jsp"); 
		return "layout/main-user"; 
	}
	
	@RequestMapping(value="account/detail",method=RequestMethod.POST) 
	public String postDetailAccount(ModelMap model,@ModelAttribute("user") Account user,HttpSession session) {
		
		userService.update(user); 
	
		model.addAttribute("content", "layout/main-account.jsp"); 
		model.addAttribute("bodyAccount", "user/account-detail.jsp"); 
		return "layout/main-user"; 
	}

	@RequestMapping("account/change-password") 
	public String getChangePassword(ModelMap model) { 
		
		model.addAttribute("content", "layout/main-account.jsp"); 
		model.addAttribute("bodyAccount", "user/change-password.jsp"); 
		return "layout/main-user"; 
	}
	
	@RequestMapping(value="account/change-password",method=RequestMethod.POST) 
	public String postChangePassword(ModelMap model, HttpSession session,
			@RequestParam("new-password") String newPassword
			) { 
	
		Long idAccount = (Long)session.getAttribute("idAccount");
		Account user = userService.getAccountWithId(idAccount);
		
		userService.changePassword(user, newPassword);
		
		model.addAttribute("content", "layout/main-account.jsp"); 
		model.addAttribute("bodyAccount", "user/change-password.jsp"); 
		return "layout/main-user"; 
	}
}
