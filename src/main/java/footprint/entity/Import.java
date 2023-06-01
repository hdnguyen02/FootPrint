package footprint.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Import {
	@Id
	private String idImport;

	private Date date;
	
	private String supplier;  

	

	// tiếp theo khai báo khóa ngoại ở đây.

	@ManyToOne
	@JoinColumn(name = "idEmployee")
	private Employee employee;
	
	@OneToMany(mappedBy = "importEntity", fetch = FetchType.LAZY)
	private Collection<ImportDetail> importDetails;

	public String getIdImport() {
		return idImport;
	}

	public void setIdImport(String idImport) {
		this.idImport = idImport;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Collection<ImportDetail> getImportDetails() {
		return importDetails;
	}


	public void setImportDetails(Collection<ImportDetail> importDetails) {
		this.importDetails = importDetails;
	}
	
	
	
	public Import(String idImport, Date date, String supplier, Employee employee,
			Collection<ImportDetail> importDetails) {
		this.idImport = idImport;
		this.date = date;
		this.supplier = supplier;
		this.employee = employee;
		this.importDetails = importDetails;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Import() { 
		
	}
	


}
