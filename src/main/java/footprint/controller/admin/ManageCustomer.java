package footprint.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Customer;
import footprint.service.CustomerService;

@Controller
public class ManageCustomer {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/admin/list-customer")
	public String getCustomer(ModelMap model) {
		List<Customer> customer = customerService.getAllCustomer();
		model.addAttribute("customers", customer);
		model.addAttribute("sidebarDashboard", "admin/sidebar.jsp");
		model.addAttribute("bodyDashboard", "admin/list-customer.jsp");
		return "layout/main-dashboard";
	}
	
	@RequestMapping(value = "/admin/disable{id}")
	public String enableStatusCustomer(@PathVariable("id") Integer id, ModelMap modelMap, @RequestParam("source") String source) {
		Customer customer = customerService.getAccountWithId(id);
		if (customer != null) {
			if (customer.getDisable() == false)
				customer.setDisable(true);
			else if (customer.getDisable() == true)
				customer.setDisable(false);
			customerService.update(customer);
		}
		return "redirect:/admin/list-customer.htm";
	}
	
}
