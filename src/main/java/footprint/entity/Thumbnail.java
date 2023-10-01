package footprint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Thumbnail {
	@Id
	@GeneratedValue
	private Integer idThumbnail; 
	
	private String name; 
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;	

	public Integer getIdThumbnail() {
		return idThumbnail;
	}

	public void setIdThumbnail(Integer id) {
		this.idThumbnail = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Thumbnail(Integer id, String name, Product product) {
		this.idThumbnail = id;
		this.name = name;
		this.product = product;
	}

	public Thumbnail() {}
	
	
}
