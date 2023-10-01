package footprint.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Integer idCustomer;

	private String email;
	private String password;
	private Boolean disable;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<Cart> carts;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<OrderCT> orders;

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

	public Collection<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Collection<Cart> carts) {
		this.carts = carts;
	}
	
	

	public Collection<OrderCT> getOrders() {
		return orders;
	}

	public void setOrders(Collection<OrderCT> orders) {
		this.orders = orders;
	}

	
	
	public Customer(Integer idCustomer, String email, String password, Boolean disable, Collection<Cart> carts,
			Collection<OrderCT> orders) {
		this.idCustomer = idCustomer;
		this.email = email;
		this.password = password;
		this.disable = disable;
		this.carts = carts;
		this.orders = orders;
	}

	public Customer() {
		
	}
	
	
	
	

}
