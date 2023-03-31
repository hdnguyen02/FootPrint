package footprint.entity;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProductSize {
	@Id
	@GeneratedValue
	private Long idProductSize;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
	
	
	@ManyToOne
	@JoinColumn(name="idSize")
	private Size size;
	
	@OneToMany(mappedBy = "productSize", fetch = FetchType.LAZY)
	private Collection<Cart> carts;
	
	private int quantity;

	public Long getIdProductSize() {
		return idProductSize;
	}

	public void setIdProductSize(Long idProductSize) {
		this.idProductSize = idProductSize;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductSize(Long idProductSize, Product product, Size size, int quantity) {
		this.idProductSize = idProductSize;
		this.product = product;
		this.size = size;
		this.quantity = quantity;
	}

	public ProductSize() {
	
	}
	
	
	
	
	
	
	
}
