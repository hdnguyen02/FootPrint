package footprint.controller.staff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import footprint.entity.OrderCT;
import footprint.service.OrderService;

@Controller
public class OrderStaffController {

	@Autowired
	private OrderService orderService;
	
	public static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

	@RequestMapping("/staff/order")
	public String getOrder(ModelMap model) {
		
		List<OrderCT> orders = orderService.filterOrders(new Date(), new Date(),false);// lọc ra bọn chưa có phiếu xuất trong ngày.
		model.addAttribute("orders", orders);
	
		Date today = new Date(); 
		model.addAttribute("from",formatDate(today)); 
		model.addAttribute("to",formatDate(today)); 
		model.addAttribute("status","not-export");
		
		

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/list-order.jsp");
		return "layout/main-dashboard";
	}
	
	@RequestMapping(value="/staff/order",method = RequestMethod.POST)
	public String postOrder(ModelMap model, @RequestParam("status") String status,
			@RequestParam("from") String from,
			@RequestParam("to") String to) { 

		
		Date fromDate = new Date();
		Date toDate = new Date();
		
		Boolean isExistExport = true; 
		if (status.equals("not-export")) {
			isExistExport = false;
		}
		
		if (!from.equals("none") && !to.equals("none")) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				fromDate = dateFormat.parse(from);
				toDate = dateFormat.parse(to); 
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
		List<OrderCT> orders = orderService.filterOrders(fromDate, toDate, isExistExport);
		

		model.addAttribute("from",from); 
		model.addAttribute("to",to); 
		model.addAttribute("status",status);

	
		model.addAttribute("orders", orders);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/list-order.jsp");
		return "layout/main-dashboard";
		
	}
	
	
	@RequestMapping(value="staff/order/detail") 
	public String getDetail(ModelMap model,@RequestParam(value="id",required = true) Integer idOrder) {
		OrderCT order = orderService.getOrderWidhId(idOrder); 
		model.addAttribute("order",order); 
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/detail-order.jsp");
		return "layout/main-dashboard";
	}
	
	// sử lý tạo phiếu xuất nè. 
	

	

}
