package footprint.controller.staff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.dao.PaymentDao;
import footprint.entity.Employee;
import footprint.entity.Export;
import footprint.entity.Payment;
import footprint.service.ExportService;

@Controller
public class PaymentController {
	
	@Autowired private PaymentDao paymentDao; 

	@Autowired
	private ExportService exportService;

	@RequestMapping("/staff/payment")
	@Transactional
	public String createPayment(ModelMap model) {

		List<Export> exports = exportService.getExportsNotPayment();
		for(Export export : exports) { 
			Hibernate.initialize(export.getOrder());
		}

		model.addAttribute("exports", exports);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/payment.jsp");
		return "layout/main-dashboard";

	}
	
	@RequestMapping(value="/staff/payment",method=RequestMethod.POST)
	@Transactional
	public String createPaymentPost(ModelMap model,@RequestParam("id-payment") String idPayment, 
			@RequestParam("amount") Float amount, 
			@RequestParam("date") String date,@RequestParam("method") String method,@RequestParam("id-export")
	String idExport
			) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date datePayment = null;

		try {
			datePayment = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Employee employee = new Employee(); 
		employee.setIdEmployee("1"); 
		Export exportPayment = new Export(); 
		exportPayment.setIdExport(idExport); 
		
		Payment payment = new Payment();  
		payment.setIdPayment(idPayment); 
		payment.setDate(datePayment); 
		payment.setAmount(amount); 
		payment.setMethod(method); 
		payment.setEmployee(employee); 
		payment.setExport(exportPayment); 
		
		boolean result = paymentDao.addPayment(payment); 
		model.addAttribute("result", result);
		model.addAttribute("success", "Tạo thanh toán thành công");
		model.addAttribute("failure", "Đã xảy ra lỗi!!!");
	

		List<Export> exports = exportService.getExportsNotPayment();
		for(Export export : exports) { 
			Hibernate.initialize(export.getOrder());
		}

		model.addAttribute("exports", exports);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/payment.jsp");
		return "layout/main-dashboard";

	}
	
	@RequestMapping("/staff/list-payment")
	@Transactional
	public String createPaymentPost(ModelMap model){ 
		
		List<Payment> payments = paymentDao.getAllPayment(); 
		
		for(Payment payment : payments) { 
			Hibernate.initialize(payment.getExport());
		}
		model.addAttribute("payments", payments); 
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/list-payment.jsp");
		return "layout/main-dashboard";
	}
	
	

}
