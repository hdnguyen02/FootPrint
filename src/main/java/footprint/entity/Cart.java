package footprint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private Integer idCart;

	@ManyToOne
	@JoinColumn(name = "idProduct")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "idCustomer")
	private Customer customer;

	private Integer quantity;

	public Integer getIdCart() {
		return idCart;
	}

	public void setIdCart(Integer idCart) {
		this.idCart = idCart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cart(Integer idCart, Product product, Customer customer, Integer quantity) {
		this.idCart = idCart;
		this.product = product;
		this.customer = customer;
		this.quantity = quantity;
	}

	public Cart() {

	}

}
