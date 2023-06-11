package footprint.controller.general;


import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Customer;
import footprint.service.CustomerService;

@Controller
public class SignInCustomer{
	@Autowired private CustomerService customerService;
	@RequestMapping("/sign-in")
	public String Getlogin(ModelMap model, HttpSession session) {
		if (session.getAttribute("successRegister") != null) {
			model.addAttribute("successRegister", session.getAttribute("successRegister"));
			session.removeAttribute("successRegister");
		}
		model.addAttribute("content", "general/sign-in.jsp"); 
		model.addAttribute("nameBreadcrumb", "login"); 
		
		return "layout/main-login-register"; 
	}
	
	@RequestMapping(value="sign-in",method = RequestMethod.POST)
	public String Postlogin(ModelMap model,HttpSession session,
			@RequestParam("email") String email,@RequestParam("password") String password) 
	{
		Customer customer = customerService.getCustomerByEmail(email); 
		if (customer == null || !BCrypt.checkpw(password,customer.getPassword())) { 
			model.addAttribute("resultLogin", "Tài khoản hoặc mật khẩu không tồn tại"); 
			model.addAttribute("content", "general/sign-in.jsp"); 
			model.addAttribute("nameBreadcrumb", "login"); 
			return "layout/main-login-register";  
		}
		else { 
			if (customer.getDisable() == true) { 
				model.addAttribute("resultLogin", "Tài khoản hoặc mật khẩu không tồn tại"); 
				model.addAttribute("content", "general/sign-in.jsp"); 
				model.addAttribute("nameBreadcrumb", "login"); 
				return "layout/main-login-register"; 
			}
		}
		
		session.setAttribute("idCustomer", customer.getIdCustomer());
		return "redirect:/";
	}
	
	
	@RequestMapping("/sign-out")
	public String signOut(HttpSession session) {
		if (session.getAttribute("idCustomer") != null) {
			session.removeAttribute("idCustomer"); 
		}
		else if(session.getAttribute("idEmployee") != null) {
			session.removeAttribute("idEmployee"); 
		}
		return "redirect:/";
	}
	
	@RequestMapping("/dont-permission")
	public String dontPermission() {
		return "/general/dont-permission";
	}
}