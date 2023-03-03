package footprint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class ProductEntity {
	@Id
	@Column(name="idProduct")
	private String idProduct; 
	
	@Column(name="name")
	private String name;
	

	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductEntity(String idProduct, String name) {
		this.idProduct = idProduct;
		this.name = name;
	}
	public ProductEntity() {

	} 
	
	
	
	
	
}
