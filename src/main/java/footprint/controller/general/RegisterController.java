package footprint.controller.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import footprint.entity.User;
import footprint.service.MailService;

@Controller
public class RegisterController {
	
	
	@Autowired
	private MailService mailService; 
	
	@RequestMapping("register")
	public String getRegister(ModelMap model,@ModelAttribute("user") User user) { 
			
		model.addAttribute("content", "general/register.jsp"); 
		return "layout/main-login-register";
	}
	
	@RequestMapping(value="confirm",method=RequestMethod.POST)
	public String postRegister(ModelMap model,@ModelAttribute("user") User user) { 
		
	
		
		String otp = mailService.createOTP(); 
		
		System.out.println(otp);
		
		// gửi otp đến dịa chỉ 
		
		boolean resultSendMail = mailService.sendOTP(user.getEmail(),otp); 
		
		if (resultSendMail) {
			System.out.println("gửi mail thành công");
		}
		else {
			System.out.println("gửi mail thất bại");
		}
	
		 
		model.addAttribute("content", "user/confirm.jsp");
		return "layout/main-login-register";
	}

}
