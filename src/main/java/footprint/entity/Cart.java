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
	private Long idCart;  
	
	private int quantity; 
	
	@ManyToOne
	@JoinColumn(name = "idAccount")
	private Account account; 
	
	
	@ManyToOne
	@JoinColumn(name = "idProductSize")
	private ProductSize productSize;


	public Long getIdCart() {
		return idCart;
	}


	public void setIdCart(Long idCart) {
		this.idCart = idCart;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public ProductSize getProductSize() {
		return productSize;
	}


	public void setProductSize(ProductSize productSize) {
		this.productSize = productSize;
	}


	public Cart(Long idCart, int quantity, Account account, ProductSize productSize) {
		this.idCart = idCart;
		this.quantity = quantity;
		this.account = account;
		this.productSize = productSize;
	}


	public Cart() {
		
	} 
	
}
