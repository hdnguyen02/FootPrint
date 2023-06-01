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

import footprint.entity.Employee;
import footprint.entity.OrderCT;
import footprint.service.ExportService;
import footprint.service.OrderService;

@Controller
public class ExportController {
	
	@Autowired
	private OrderService orderService; 
	
	@Autowired
	private ExportService exportService; 
	
	@RequestMapping("/staff/export-product")  
	public String addExport(ModelMap model) { 
		
		// lấy ra các đơn hàng chưa có phiếu xuất 
		// lấy ra tất cả luôn. không phân biệt ngày. 
		
		List<OrderCT> orders = orderService.filterOrders(null, null, false); // chỉ lấy ra các đơn hàng chưa có phiếu xuất 
		model.addAttribute("orders", orders);		
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/export-product.jsp");
		return "layout/main-dashboard";
	}
	
	@RequestMapping(value="/staff/export-product",method = RequestMethod.POST) 
	@Transactional
	public String postAddExport(ModelMap model,@RequestParam("id-export") String idExport, 
			@RequestParam("date") String date,@RequestParam("info-shipment") String infoShipment,
			@RequestParam("zip-code") String zipCode,@RequestParam("id-employee") String idEmployee, 
			@RequestParam("id-order") Integer idOrder
			) { 
	
		OrderCT order = orderService.getOrderWidhId(idOrder); 
		Hibernate.initialize(order.getOrderDetails()); 
		model.addAttribute("order", order);		
		model.addAttribute("idExport", idExport);	
		model.addAttribute("date", date);
		model.addAttribute("infoShipment", infoShipment);
		model.addAttribute("zipCode", zipCode);
		model.addAttribute("idEmployee", idEmployee);
		model.addAttribute("idOrder", idOrder);
		
	
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/detail-export.jsp");
		return "layout/main-dashboard";
	}
	
	@RequestMapping(value="/staff/create-import",method = RequestMethod.POST) 
	public String postCreateExport(ModelMap model,
			@RequestParam("id-export") String idExport, 
			@RequestParam("date") String date,@RequestParam("info-shipment") String infoShipment,
			@RequestParam("zip-code") String zipCode,@RequestParam("id-employee") String idEmployee, 
			@RequestParam("id-order") Integer idOrder
			) { 
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateExport = null;

		try {
			dateExport = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		boolean result = exportService.addExportAndDetail(idExport,dateExport , infoShipment, zipCode, idOrder, "1"); 
		if (result == false) {
			System.out.println("Sảy ra lỗi khi tạo");
		}
		
		
		
				/*
				 * model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
				 * model.addAttribute("bodyDashboard", "staff/detail-export.jsp");
				 */
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/export-product.jsp");
		return "layout/main-dashboard";
	}
}
