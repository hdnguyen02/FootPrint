package footprint.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class OrderCT {
	@Id
	@GeneratedValue 
	private Long idOrder; 
	
	private String firstName; 
	private String lastName; 
	private String email; 
	private String phone; 
	
	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private String address;
	
	private String message; 
	
	// tính tiền trên đơn hàng tại đây. 
	private Float totalMonney; 
	
	// ngoài ra còn có cả idAccount và id Trạng thái đơn hàng. 
	
	@ManyToOne
	@JoinColumn(name = "idAccount")
	private Account account; 
	
	@ManyToOne
	@JoinColumn(name = "idOrderStatus")
	private OrderStatus orderStatus; 
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private Collection<OrderDetail> orderDetails;

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
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

	public void setLasttName(String lasttName) {
		this.lastName = lasttName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Float getTotalMonney() {
		return totalMonney;
	}

	public void setTotalMonney(Float totalMonney) {
		this.totalMonney = totalMonney;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderCT(Long idOrder, String firstName, String lastName, String email, String phone, Date date,
			String address, String message, Float totalMonney, Account account, OrderStatus orderStatus,
			Collection<OrderDetail> orderDetails) {
		this.idOrder = idOrder;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.date = date;
		this.address = address;
		this.message = message;
		this.totalMonney = totalMonney;
		this.account = account;
		this.orderStatus = orderStatus;
		this.orderDetails = orderDetails;
	}

	public OrderCT() {}
}
