package footprint.controller.staff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.dao.ImportDao;
import footprint.dao.ProductDao;
import footprint.entity.Employee;
import footprint.entity.Import;
import footprint.entity.ImportDetail;
import footprint.entity.Product;
import footprint.service.ProductService;

@Controller
public class ImportProductController {

	@Autowired
	private ProductService productService; 
	
	@Autowired
	private ImportDao importDao; 
	


	@RequestMapping(value = "/staff/import-product", method = RequestMethod.GET)
	public String importGet(ModelMap model) {

		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/import-product.jsp");
		return "layout/main-dashboard";

	}

	@RequestMapping(value = "/staff/import-product", method = RequestMethod.POST)
	public String importPost(ModelMap model, @RequestParam("id-import") String idImport,
			@RequestParam("date") String date, @RequestParam("id-employee") String idEmployee,
			@RequestParam("products-import-checked") String[] productsImport, HttpServletRequest request) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateImport = null;
		Employee employee = new Employee();

		try {
			dateImport = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		employee.setIdEmployee(idEmployee);
		Import importEntity = new Import(); 
		importEntity.setIdImport(idImport);
		importEntity.setDate(dateImport);
		importEntity.setEmployee(employee);
		

		ImportDetail[] importDetails = new ImportDetail[productsImport.length]; 
		Product [] productsUpdate = new Product[productsImport.length]; 
		

		for (int i = 0; i < productsImport.length; i++) {
			importDetails[i] = new ImportDetail();
			String idProduct = productsImport[i]; 

			Product product = productService.getProductWithId(idProduct); 
			Integer quantity = Integer.valueOf(request.getParameter("quantity-" + idProduct));
		
			importDetails[i].setProduct(product);
			importDetails[i].setImportEntity(importEntity);
			importDetails[i].setQuantity(quantity);
			
			productsUpdate[i] = product; 

		}
		
		importDao.addImportAndDetail(importEntity, importDetails,productsUpdate); 

		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/import-product.jsp");
		return "layout/main-dashboard";

	}

}
