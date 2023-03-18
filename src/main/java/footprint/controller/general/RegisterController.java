package footprint.controller.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import footprint.entity.Account;
import footprint.service.UserService;

@Controller
public class RegisterController {
	
	
	/*
	 * @Autowired private MailService mailService;
	 */
	
	@Autowired 
	private UserService userService;
	
	
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String getRegister(ModelMap model,@ModelAttribute("account") Account account) { 
		
		model.addAttribute("nameBreadcrumb", "register");
		model.addAttribute("content", "general/register.jsp"); 
		return "layout/main-login-register";
	}
	
	@RequestMapping(value="confirm",method=RequestMethod.POST)
	public String postRegister(ModelMap model,@ModelAttribute("account") Account account) { 
		System.out.println(userService.insert(account));

		
		
	
		/*
		 * String otp = mailService.createOTP();
		 * 
		 * System.out.println(otp);
		 * 
		 * // gửi otp đến dịa chỉ
		 * 
		 * boolean resultSendMail = mailService.sendOTP(user.getEmail(),otp);
		 * 
		 * if (resultSendMail) { System.out.println("gửi mail thành công"); } else {
		 * System.out.println("gửi mail thất bại"); }
		 */
	
		model.addAttribute("nameBreadcrumb", "register");
		model.addAttribute("content", "user/confirm.jsp");
		return "layout/main-login-register";
	}

}
