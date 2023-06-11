package footprint.controller.general;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Customer;
import footprint.service.CustomerService;
import footprint.service.MailService;

@Controller
public class RegisterController {

	@Autowired
	private MailService mailService;

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister(ModelMap model, @ModelAttribute("customer") Customer customer, HttpSession session) {
		if (session.getAttribute("errorRegister") != null) {
			model.addAttribute("errorRegister", session.getAttribute("errorRegister"));
			session.removeAttribute("errorRegister");
		}
		model.addAttribute("nameBreadcrumb", "register");
		model.addAttribute("content", "general/register.jsp");
		return "layout/main-login-register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String postRegister(ModelMap model, @ModelAttribute("customer") Customer customer, HttpSession session) {
		Customer userByEmail = customerService.getCustomerByEmail(customer.getEmail());
		boolean successRegister = true;
		if (userByEmail != null) {
			model.addAttribute("resultEmail", "Email đã được sử dụng");
			successRegister = false;
		}
		if (successRegister) {
			String otp = mailService.createOTP();
			mailService.sendOTP(customer.getEmail(), otp);
			session.setAttribute("email", customer.getEmail());
			session.setAttribute("password", customer.getPassword());
			session.setAttribute("otp", otp);
			model.addAttribute("content", "user/confirm.jsp");
		} else {
			customer.setPassword("");
			model.addAttribute("content", "general/register.jsp");
		}

		model.addAttribute("nameBreadcrumb", "register");
		return "layout/main-login-register";
	}

	@RequestMapping(value = "confirm", method = RequestMethod.POST)
	public String authOtp(@ModelAttribute("customer") Customer customer, HttpSession session, ModelMap model,@RequestParam("otp-1") String otp1, @RequestParam("otp-2") String otp2, @RequestParam("otp-3") String otp3,@RequestParam("otp-4") String otp4, @RequestParam("otp-5") String otp5,@RequestParam("otp-6") String otp6) {
		String otpConfirm = otp1 + otp2 + otp3 + otp4 + otp5 + otp6;
		String otpSend = (String) session.getAttribute("otp");
		if (otpConfirm.equals(otpSend)) {
			Customer tkdk = new Customer();
			tkdk.setEmail((String) session.getAttribute("email"));
			tkdk.setPassword((String) session.getAttribute("password"));
			boolean resultRegister = customerService.insertCustomer(tkdk);
			if (resultRegister == true) {
				session.removeAttribute("otp");
				session.removeAttribute("email");
				session.removeAttribute("password");
				session.setAttribute("successRegister", "Đăng ký tài khoản thành công!");
				return "redirect:/sign-in.htm";
			}
			session.setAttribute("errorRegister", "Đăng ký tài khoản thất bại!");
			return "redirect:/register.htm";
		}
		session.setAttribute("errorRegister", "Đăng ký tài khoản không thành công, mã otp không chính xác!");

		return "redirect:/register.htm";
	}

}