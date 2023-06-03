package footprint.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.dao.EmployeeDao;
import footprint.entity.Employee;

@Controller
public class ManageStaff {

	/*
	 * @Autowired private EmployeeDao employeeDao;
	 * 
	 * @RequestMapping("/admin/list-staff") public String getStaffs(HttpSession
	 * session,ModelMap model) {
	 * 
	 * if (session.getAttribute("resultEditStaff") != null) {
	 * model.addAttribute("result",(Boolean)session.getAttribute("resultEditStaff")
	 * ); model.addAttribute("success", "Tạo phiếu nhập hàng thành công");
	 * model.addAttribute("failure", "Đã xảy ra lỗi!!!");
	 * session.removeAttribute("resultEditStaff"); } List<Employee> staffs =
	 * employeeDao.getEmployeeWithRole("STAFF");
	 * model.addAttribute("staffs",staffs);
	 * 
	 * model.addAttribute("sidebarDashboard", "admin/sidebar.jsp");
	 * model.addAttribute("bodyDashboard", "admin/list-staff.jsp"); return
	 * "layout/main-dashboard";
	 * 
	 * }
	 * 
	 * @RequestMapping("/admin/edit-staff") public String getEditStaff(ModelMap
	 * model,@RequestParam("id") String idEmployee) { Employee staff =
	 * employeeDao.getEmployeeWithId(idEmployee);
	 * 
	 * if (staff == null) return "general/not-found";
	 * 
	 * model.addAttribute("staff",staff); model.addAttribute("sidebarDashboard",
	 * "admin/sidebar.jsp"); model.addAttribute("bodyDashboard",
	 * "admin/edit-staff.jsp"); return "layout/main-dashboard";
	 * 
	 * }
	 * 
	 * @RequestMapping(value="/admin/edit-staff",method=RequestMethod.POST) public
	 * String postEditStaff(HttpSession session,ModelMap
	 * model,@ModelAttribute("staff") Employee staff) {
	 * 
	 * 
	 * boolean result = employeeDao.update(staff);
	 * 
	 * 
	 * session.setAttribute("resultEditStaff", result); return
	 * "redirect:/admin/list-staff.htm";
	 * 
	 * }
	 */

}
