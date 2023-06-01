package footprint.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Export {
	@Id
	private String idExport;
	private Date date;
	private String infoShipment;
	private String zipCode;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idOrder")
	private OrderCT order;

	@OneToMany(mappedBy = "export", fetch = FetchType.EAGER)
	private Collection<ExportDetail> exportDetails;

	@ManyToOne
	@JoinColumn(name = "idEmployee")
	private Employee employee;

	public String getIdExport() {
		return idExport;
	}

	public void setIdExport(String idExport) {
		this.idExport = idExport;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public String getInfoShipment() {
		return infoShipment;
	}

	public void setInfoShipment(String infoShipment) {
		this.infoShipment = infoShipment;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public OrderCT getOrder() {
		return order;
	}

	public void setOrder(OrderCT order) {
		this.order = order;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Collection<ExportDetail> getExportDetails() {
		return exportDetails;
	}

	public void setExportDetails(Collection<ExportDetail> exportDetails) {
		this.exportDetails = exportDetails;
	}
	
	

	public Export(String idExport, Date date, String infoShipment, String zipCode, OrderCT order,
			Collection<ExportDetail> exportDetails, Employee employee) {
		this.idExport = idExport;
		this.date = date;
		this.infoShipment = infoShipment;
		this.zipCode = zipCode;
		this.order = order;
		this.exportDetails = exportDetails;
		this.employee = employee;
	}

	

	public Export() {

	}

}
