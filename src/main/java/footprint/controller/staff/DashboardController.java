package footprint.controller.staff;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import footprint.dao.EmployeeDao;
import footprint.entity.Category;
import footprint.entity.Employee;
import footprint.entity.Product;
import footprint.entity.Thumbnail;
import footprint.service.CategoryService;
import footprint.service.ExportService;
import footprint.service.OrderService;
import footprint.service.ProductService;

@Controller
public class DashboardController {

	@Autowired
	private CategoryService categorySv;
	@Autowired
	private ProductService productSv;
	@Autowired
	private ExportService exportSv;
	
	@Autowired
	private OrderService orderSv; 
	
	@Autowired
	private EmployeeDao employeeDao; 

	@RequestMapping("/staff")
	@Transactional
	public String dashboard(ModelMap model) {
		
		model.addAttribute("sizeProducts", productSv.getAllProducts().size());   
		model.addAttribute("sizeCategorys",categorySv.getAllCategories().size()); 
		model.addAttribute("sizeOrderDate", orderSv.filterOrders(new Date(), new Date(), false).size()); 
		model.addAttribute("sizeExportDate", exportSv.filterExport(new Date(), new Date()).size()); 
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp"	);
		model.addAttribute("bodyDashboard", "staff/index.jsp");


		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/index.jsp");
		return "layout/main-dashboard";
	}

	@RequestMapping(value = "/staff/add-product", method = RequestMethod.GET)
	public String addProduct(ModelMap model) {
		List<Category> categories = categorySv.getAllCategories();
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categories);

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/add-product.jsp");

		return "layout/main-dashboard";
	}

	@RequestMapping(value = "/staff/add-product", method = RequestMethod.POST)
	public String addProductPost(ModelMap model, @ModelAttribute("product") Product product,
			@RequestParam("imageProduct") MultipartFile imageProduct,
			@RequestParam("imageThumbnails") MultipartFile[] imageThumbnails) {
		product.setQuantity(0);
		List<Category> categories = categorySv.getAllCategories();
		Thumbnail[] thumbnails = new Thumbnail[imageThumbnails.length];
		boolean result = productSv.addProductAndThumbnail(product, imageProduct, thumbnails, imageThumbnails);
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categories);
		model.addAttribute("result", result);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/add-product.jsp");
		return "layout/main-dashboard";
	}
	
	@RequestMapping(value="/sign-in-employee")
	public String signInEmployee(ModelMap model) { 
		return "general/sign-in-employee";
	}
	
	@RequestMapping(value="/sign-in-employee", method = RequestMethod.POST)
	public String postSignEmployee(HttpSession session,ModelMap model,@RequestParam("email") String email,@RequestParam("password") String password) { 
		Employee employee = employeeDao.getEmployeeByEmail(email); 
		if (employee == null || !BCrypt.checkpw(password,employee.getPassword())) { 
			return "general/sign-in-employee";
		}
		// thành công nè. 
		session.setAttribute("idEmployee", employee.getIdEmployee());
		String role = employee.getRole();
		session.setAttribute("role", role);	
		if (role.equals("STAFF")) return "redirect:/staff.htm";
		else return "redirect:/admin.htm";
		
		
	}	
	

}
