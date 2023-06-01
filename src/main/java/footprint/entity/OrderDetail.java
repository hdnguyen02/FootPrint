package footprint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetail {

	@Id
	@GeneratedValue
	private Integer idOrderDetail;

	@ManyToOne
	@JoinColumn(name = "idOrder")
	private OrderCT order;

	@ManyToOne
	@JoinColumn(name = "idProduct")
	private Product product;

	private Float cost;
	private Integer quantity;

	public Integer getIdOrderDetail() {
		return idOrderDetail;
	}

	public void setIdOrderDetail(Integer idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}

	public OrderCT getOrder() {
		return order;
	}

	public void setOrder(OrderCT order) {
		this.order = order;
	}

	

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderDetail(Integer idOrderDetail, OrderCT order, Product product, Float cost, Integer quantity) {
		this.idOrderDetail = idOrderDetail;
		this.order = order;
		this.product = product;
		this.cost = cost;
		this.quantity = quantity;
	}
	
	public OrderDetail() { 
		
	}
	
	

}
