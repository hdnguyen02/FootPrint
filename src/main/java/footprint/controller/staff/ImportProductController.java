package footprint.controller.staff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
			@RequestParam("date") String date, @RequestParam("supplier") String supplier,
			@RequestParam("products-import-checked") String[] productsImport, HttpServletRequest request) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateImport = null;
		Employee employee = new Employee();

		try {
			dateImport = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		employee.setIdEmployee("1");

		Import importEntity = new Import();
		importEntity.setIdImport(idImport);
		importEntity.setDate(dateImport);
		importEntity.setSupplier(supplier);
		importEntity.setEmployee(employee);

		ImportDetail[] importDetails = new ImportDetail[productsImport.length];
		Product[] productsUpdate = new Product[productsImport.length];

		for (int i = 0; i < productsImport.length; i++) {
			importDetails[i] = new ImportDetail();
			String idProduct = productsImport[i];
			Product product = productService.getProductWithId(idProduct);
			Integer quantity = Integer.valueOf(request.getParameter("quantity-" + idProduct));
			Float cost = Float.valueOf(request.getParameter("cost-" + idProduct));
			importDetails[i].setProduct(product);
			importDetails[i].setImportEntity(importEntity);
			importDetails[i].setQuantity(quantity);
			importDetails[i].setCost(cost);
			productsUpdate[i] = product;

		}

		boolean result = importDao.addImportAndDetail(importEntity, importDetails, productsUpdate);
		model.addAttribute("result", result);
		model.addAttribute("success", "Tạo phiếu nhập hàng thành công");
		model.addAttribute("failure", "Đã xảy ra lỗi!!!");

		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/import-product.jsp");
		return "layout/main-dashboard";
	}

	@RequestMapping(value = "/staff/list-import", method = RequestMethod.GET)
	public String listImport(ModelMap model) {

		List<Import> imports = importDao.getAllImports();
		model.addAttribute("imports", imports);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/list-import.jsp");
		return "layout/main-dashboard";
	}

	@RequestMapping(value = "/staff/list-import", method = RequestMethod.POST)
	public String postListImport(ModelMap model, @RequestParam("from") String from, @RequestParam("to") String to) {
		Date fromDate = new Date();
		Date toDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fromDate = dateFormat.parse(from);
			toDate = dateFormat.parse(to);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Import> imports = importDao.filterImport(fromDate, toDate);
		model.addAttribute("from", from);
		model.addAttribute("to", to);
		model.addAttribute("imports", imports);

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/list-import.jsp");
		return "layout/main-dashboard";
	}

	@RequestMapping("/staff/import/detail")
	public String detailImport(ModelMap model, @RequestParam("id") String idImport) {
		Import importEntity = importDao.getImportWithId(idImport);
		if (importEntity == null) {
			return "general/not-found";
		}
		model.addAttribute("importEntity", importEntity);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/detail-import.jsp");
		return "layout/main-dashboard";
	}

}
