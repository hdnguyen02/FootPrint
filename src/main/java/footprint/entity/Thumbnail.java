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
	private Long idThumbnail; 
	private String name; 
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;

	public Long getIdThumbnail() {
		return idThumbnail;
	}

	public void setIdThumbnail(Long idThumbnail) {
		this.idThumbnail = idThumbnail;
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

	public Thumbnail(Long idThumbnail, String name, Product product) {
		this.idThumbnail = idThumbnail;
		this.name = name;
		this.product = product;
	}

	public Thumbnail() {}
	
	
}
