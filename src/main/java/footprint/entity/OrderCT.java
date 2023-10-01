package footprint.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderCT {

	@Id
	@GeneratedValue
	private Integer idOrder;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
	private Date date;
	private String message;
	private Float totalMonney;
	private Boolean isCancelled; 
	

	@ManyToOne
	@JoinColumn(name = "idCustomer")
	private Customer customer;

	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
	private Collection<OrderDetail> orderDetails;

	@OneToOne(mappedBy = "order")
	private Export export;

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Export getExport() {
		return export;
	}

	public void setExport(Export export) {
		this.export = export;
	}
	
	

	public Float getTotalMonney() {
		return totalMonney;
	}

	public void setTotalMonney(Float totalMonney) {
		this.totalMonney = totalMonney;
	}

	public OrderCT(Integer idOrder, String firstName, String lastName, String address, String phone, String email,
			Date date, String message, Float totalMonney, Boolean isCancelled, Customer customer,
			Collection<OrderDetail> orderDetails, Export export) {
		this.idOrder = idOrder;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.date = date;
		this.message = message;
		this.totalMonney = totalMonney;
		this.isCancelled = isCancelled;
		this.customer = customer;
		this.orderDetails = orderDetails;
		this.export = export;
	}


	public Boolean getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	public OrderCT() {

	}

}
