package footprint.controller.customer;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Customer;
import footprint.service.CustomerService;

@Controller
public class ChangePWController {
	
	@Autowired
	private CustomerService customerService; 
	
	@RequestMapping("/change-password") 
	public String getChangePassword(ModelMap model) { 
		
		model.addAttribute("content", "layout/main-account.jsp"); 
		model.addAttribute("bodyAccount", "user/change-password.jsp"); 
		return "layout/main-user"; 
	}
	
	@RequestMapping(value="/change-password",method=RequestMethod.POST) 
	public String postChangePassword(ModelMap model, HttpSession session,
			@RequestParam("new-password") String newPassword
			) { 
	
		Integer idCustomer = (Integer) session.getAttribute("idCustomer");
		Customer customer = customerService.getAccountWithId(idCustomer);
		
		boolean result = customerService.changePassword(customer, newPassword);
		
		model.addAttribute("result", result);
		model.addAttribute("success", "Cập nhập mật khẩu thành công!"); 
		model.addAttribute("failure", "xảy ra lỗi!!!"); 
		
		

		model.addAttribute("content", "layout/main-account.jsp"); 
		model.addAttribute("bodyAccount", "user/change-password.jsp"); 
		return "layout/main-user"; 
	}

}
