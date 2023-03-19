package footprint.controller.general;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Account;
import footprint.service.MailService;

import footprint.service.UserService;

@Controller
public class RegisterController {

	
	
	@Autowired 
	private MailService mailService;
	 
	
	
	@Autowired 
	private UserService userService;
	
	// lúc submit lên vẫn submit lên trên đó. 
	
	
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String getRegister(ModelMap model,@ModelAttribute("account") Account account) { 

		model.addAttribute("nameBreadcrumb", "register");
		model.addAttribute("content", "general/register.jsp"); 
		return "layout/main-login-register";
	}
	
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String postRegister(ModelMap model,@ModelAttribute("account") Account account,HttpSession session) { 
		
		 Account userByUsername = userService.getUserByUsername(account.getUsername()); 
		 Account userByEmail = userService.getUserByEmail(account.getEmail()); 
		 System.out.println(account.getUsername());
		 System.out.println(account.getEmail());
		 
		 boolean successRegister = true; 
		 
		 if (userByUsername != null) { // có tồn tại
			 model.addAttribute("resultUsername", "Username đã được sử dụng");
			 successRegister = false; 
		 }
		 
		 if (userByEmail != null) {
			 model.addAttribute("resultEmail", "Email đã được sử dụng");
			 successRegister = false; 
		 }
		 
		 if (successRegister) { 
			 String otp = mailService.createOTP();
			 mailService.sendOTP(account.getEmail(), otp);
			 
			 
			 session.setAttribute("email", account.getEmail());
			 session.setAttribute("username", account.getUsername());
			 session.setAttribute("password", account.getPassword());
			 
			 
			 
			 session.setAttribute("otp",otp);
			 model.addAttribute("content", "user/confirm.jsp"); 
		 }
		 else { 
			 account.setPassword(""); 
			 model.addAttribute("content", "general/register.jsp");
		 }

		 model.addAttribute("nameBreadcrumb", "register");
		 return "layout/main-login-register";
	}
	
	@RequestMapping(value="auth", method=RequestMethod.POST) 
	public String authOtp (@ModelAttribute("account") Account account,HttpSession session,ModelMap model,
			@RequestParam("otp-1") String otp1,@RequestParam("otp-2") String otp2, 
			@RequestParam("otp-3") String otp3,@RequestParam("otp-4") String otp4, 
			@RequestParam("otp-5") String otp5,@RequestParam("otp-6") String otp6
	) { 
		
		String otpConfirm = otp1 + otp2 + otp3 + otp4 + otp5 + otp6; 
		String otpSend = (String)session.getAttribute("otp");
		
		// so sanh 
		if (otpConfirm.equals(otpSend)) {
			Account user = new Account(); 
			user.setEmail((String)session.getAttribute("email"));
			user.setUsername((String)session.getAttribute("username"));
			user.setPassword((String)session.getAttribute("password"));
			
		    boolean resultRegister = userService.insert(user); 
		    if (resultRegister == true) {
		    	return "redirect:/"; 
		    }
		}
		return "user/register-fail";
	}
	

}
