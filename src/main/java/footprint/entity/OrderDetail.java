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
	private Long idOrderDetail; 
	
	private Integer quantity;
	
	private Float cost;
	
	private Float totalMonney;
	
	@ManyToOne	
	@JoinColumn(name = "idProductSize")
	private ProductSize productSize;
	
	@ManyToOne	
	@JoinColumn(name = "idOrder")
	private OrderCT order;
	


	public Long getIdOrderDetail() {
		return idOrderDetail;
	}

	public void setIdOrderDetail(Long idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Float getTotalMonney() {
		return totalMonney;
	}

	public void setTotalMonney(Float totalMonney) {
		this.totalMonney = totalMonney;
	}

	public ProductSize getProductSize() {
		return productSize;
	}

	public void setProductSize(ProductSize productSize) {
		this.productSize = productSize;
	}

	public OrderCT getOrder() {
		return order;
	}

	public void setOrder(OrderCT order) {
		this.order = order;
	}

	public OrderDetail(Long idOrderDetail, Integer quantity, Float cost, Float totalMonney, ProductSize productSize,
			OrderCT order) {
		this.idOrderDetail = idOrderDetail;
		this.quantity = quantity;
		this.cost = cost;
		this.totalMonney = totalMonney;
		this.productSize = productSize;
		this.order = order;
	}

	public OrderDetail() {}
	

}
