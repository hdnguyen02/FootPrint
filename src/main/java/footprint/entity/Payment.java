package footprint.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Payment {

	@Id
	private String idPayment;
	
	private Date date; 
	
	private String method; 
	private Float amount;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idExport")
	private Export export;

	@ManyToOne
	@JoinColumn(name = "idEmployee")
	private Employee employee;

	public String getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(String idPayment) {
		this.idPayment = idPayment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Export getExport() {
		return export;
	}

	public void setExport(Export export) {
		this.export = export;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Payment(String idPayment, Date date, String method, Float amount, Export export, Employee employee) {

		this.idPayment = idPayment;
		this.date = date;
		this.method = method;
		this.amount = amount;
		this.export = export;
		this.employee = employee;
	}
	
	public Payment() { 
	
	}
	
	
	
	

}
