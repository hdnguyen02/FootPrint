package footprint.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotFoundController {
	@RequestMapping("/not-found")
	public String notFound() {
		return "general/not-found";
	}
}
