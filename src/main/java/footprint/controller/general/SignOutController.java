package footprint.controller.general;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignOutController {
	@RequestMapping("sign-out")
	public String signOut(HttpSession session) {
		session.removeAttribute("role"); 
		session.removeAttribute("idAccount"); 

		return "redirect:/";
	}
}
