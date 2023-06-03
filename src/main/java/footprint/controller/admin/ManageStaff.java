package footprint.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Employee;
import footprint.service.EmployeeService;

@Controller
public class ManageStaff {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/admin/list-staff")
	public String getStaff(ModelMap model) {
		List<Employee> employee = employeeService.getEmployeeWithRole("STAFF");
		model.addAttribute("staffs", employee);
		
		model.addAttribute("sidebarDashboard", "admin/sidebar.jsp");
		model.addAttribute("bodyDashboard", "admin/list-staff.jsp");
		return "layout/main-dashboard";
	}
	
	@RequestMapping(value = "/admin/enable{id}")
	public String enableStatusEmployee(@PathVariable("id") String id, ModelMap modelMap, @RequestParam("source") String source) {
		Employee employee = employeeService.getEmployeeWithId(id);
		if (employee != null) {
			if (employee.getDisable() == false)
				employee.setDisable(true);
			else if (employee.getDisable() == true)
				employee.setDisable(false);
			employeeService.update(employee);
		}
		return "redirect:/admin/list-staff.htm";
	}
	
	@RequestMapping("admin/add-staff")
	public String registerStaffForm(ModelMap modelMap) {
		Employee accEmploy = new Employee();
		modelMap.addAttribute("userbean", accEmploy);
		return "admin/register-staff";
	}
	
	@RequestMapping(value = "admin/staff-register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userbean") Employee employee, ModelMap modelMap) {		
		employee = new Employee(employee.getIdEmployee(), employee.getFirstName(), employee.getLastName(), employee.getCccd(), employee.getEmail(),
				employee.getPassword(), employee.getPhone(), employee.getAddress(), employee.getRole(), employee.getDisable());

		if (employeeService.addEmployee(employee)) {
			return "redirect:/admin/list-staff.htm";
		}
			
		modelMap.addAttribute("userbean", employee);
		return "admin/register-staff";
	}

}
