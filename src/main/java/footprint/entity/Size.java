package footprint.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Size {
	@Id
	private String idSize;
	
	
	private String nameSize;
	
	
	@OneToMany(mappedBy = "size", fetch = FetchType.EAGER)
	private Collection<ProductSize> productSizes;


	public String getIdSize() {
		return idSize;
	}


	public void setIdSize(String idSize) {
		this.idSize = idSize;
	}


	public String getNameSize() {
		return nameSize;
	}


	public void setNameSize(String nameSize) {
		this.nameSize = nameSize;
	}


	public Collection<ProductSize> getProductSizes() {
		return productSizes;
	}


	public void setProductSizes(Collection<ProductSize> productSizes) {
		this.productSizes = productSizes;
	}


	public Size(String idSize, String nameSize, Collection<ProductSize> productSizes) {
		this.idSize = idSize;
		this.nameSize = nameSize;
		this.productSizes = productSizes;
	}

	public Size() {

	}	
}
