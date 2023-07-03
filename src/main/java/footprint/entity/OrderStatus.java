package footprint.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrderStatus {
	@Id
	private String idOrderStatus; 
	
	private String name;
	 
	@OneToMany(mappedBy = "orderStatus", fetch = FetchType.EAGER)
	private Collection<OrderCT> orders;

	public String getIdOrderStatus() {
		return idOrderStatus;
	}

	public void setIdOrderStatus(String idOrderStatus) {
		this.idOrderStatus = idOrderStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<OrderCT> getOrders() {
		return orders;
	}

	public void setOrders(Collection<OrderCT> orders) {
		this.orders = orders;
	}

	public OrderStatus(String idOrderStatus, String name, Collection<OrderCT> orders) {
		this.idOrderStatus = idOrderStatus;
		this.name = name;
		this.orders = orders;
	}
	
	public OrderStatus() {}
	
}
