package footprint.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.ExportDao;
import footprint.entity.Employee;
import footprint.entity.Export;
import footprint.entity.ExportDetail;
import footprint.entity.OrderCT;
import footprint.entity.OrderDetail;


@Service 
public class ExportService {

	@Autowired
	private OrderService orderSerivice;

	@Autowired
	private ExportDao exportDao;

	@Transactional
	public boolean addExportAndDetail
		(String idExport, Date date, String infoShipment, String zipCode, Integer idOrder,String idEmployee) {
		
		
		OrderCT order = orderSerivice.getOrderWithIdOpenSS(idOrder);
		
		
		Employee employee = new Employee();
		employee.setIdEmployee(idEmployee);

		Export export = new Export();
		export.setIdExport(idExport);
		export.setDate(date);
		export.setInfoShipment(infoShipment);
		export.setZipCode(zipCode);
		export.setOrder(order);
		export.setEmployee(employee);

		List<ExportDetail> exportsDetail = new ArrayList<>();
		for (OrderDetail orderDetail : order.getOrderDetails()) {
			ExportDetail exportDetail = new ExportDetail();
			exportDetail.setExport(export);
			exportDetail.setProduct(orderDetail.getProduct());
			exportDetail.setCost(orderDetail.getCost());
			exportDetail.setQuantity(orderDetail.getQuantity());
			exportsDetail.add(exportDetail);
		}

		return exportDao.addExportAndDetail(export, exportsDetail);

	}
	
	public Export getExportWidhId(String id) {
		return exportDao.getExportWidhId(id);
	}
	 
	public List<Export> filterExport(Date fromDate, Date toDate) { 
		return exportDao.filterExport(fromDate, toDate); 
	}
	
	public List<Export> getExportsNotPayment() { 
		return exportDao.getExportsNotPayment(); 
	}
}
