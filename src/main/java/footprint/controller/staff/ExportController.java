package footprint.controller.staff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.entity.Export;
import footprint.entity.OrderCT;
import footprint.service.ExportService;
import footprint.service.OrderService;

@Controller
@Transactional
public class ExportController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ExportService exportService;

	@RequestMapping("/staff/export-product")
	public String addExport(ModelMap model) {
		List<OrderCT> orders = orderService.filterOrders(null, null, false); // chỉ lấy ra các đơn hàng chưa có phiếu
																				// xuất
		model.addAttribute("orders", orders);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/export-product.jsp");
		return "layout/main-dashboard";
	}

	@RequestMapping(value = "/staff/export-product", method = RequestMethod.POST)
	public String postAddExport(ModelMap model, @RequestParam("id-export") String idExport,
			@RequestParam("date") String date, @RequestParam("info-shipment") String infoShipment,
			@RequestParam("zip-code") String zipCode, @RequestParam("id-order") Integer idOrder) {

		OrderCT order = orderService.getOrderWidhId(idOrder);
		Hibernate.initialize(order.getOrderDetails());
		model.addAttribute("order", order);
		model.addAttribute("idExport", idExport);
		model.addAttribute("date", date);
		model.addAttribute("infoShipment", infoShipment);
		model.addAttribute("zipCode", zipCode);
		model.addAttribute("idOrder", idOrder);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/detail-export.jsp");
		return "layout/main-dashboard";
	}

	@RequestMapping(value = "/staff/create-export", method = RequestMethod.POST)
	public String postCreateExport(HttpSession session,ModelMap model, @RequestParam("id-export") String idExport,
			@RequestParam("date") String date, @RequestParam("info-shipment") String infoShipment,
			@RequestParam("zip-code") String zipCode, @RequestParam("id-order") Integer idOrder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateExport = null;

		try {
			dateExport = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		boolean result = exportService.addExportAndDetail(idExport, dateExport, infoShipment, zipCode, idOrder, "1");
		if (result == false) {
			System.out.println("Sảy ra lỗi khi tạo");
		}

		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/export-product.jsp");
		return "layout/main-dashboard";
	}

	@RequestMapping("/staff/list-export")
	@Transactional
	public String postCreateExport(ModelMap model) {
		List<Export> exports = exportService.filterExport(null, null);
		for (Export export : exports) {
			Hibernate.initialize(export.getOrder());
		}
		model.addAttribute("exports", exports);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/list-export.jsp");
		return "layout/main-dashboard";
	}

	@RequestMapping(value = "/staff/list-export", method = RequestMethod.POST)
	public String filterCreateExport(ModelMap model, @RequestParam("from") String from, @RequestParam("to") String to) {
		Date fromDate = new Date();
		Date toDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fromDate = dateFormat.parse(from);
			toDate = dateFormat.parse(to);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Export> exports = exportService.filterExport(fromDate, toDate);

		for (Export export : exports) {

			Hibernate.initialize(export.getOrder());
		}
		model.addAttribute("from", from);
		model.addAttribute("to", to);
		model.addAttribute("exports", exports);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/list-export.jsp");
		return "layout/main-dashboard";
	}

	// xem chi tiết phiếu xuất
	@RequestMapping("/staff/export/detail")
	public String getDetailExport(ModelMap model, @RequestParam("id") String idExport) {
		Export export = exportService.getExportWidhId(idExport);
		if (export == null) {
			return "general/not-found";
		}
		Hibernate.initialize(export.getOrder());
		model.addAttribute("export", export);
		model.addAttribute("sidebarDashboard", "staff/sidebar.jsp");
		model.addAttribute("bodyDashboard", "staff/detail-show-export.jsp");
		return "layout/main-dashboard";

	}

}
