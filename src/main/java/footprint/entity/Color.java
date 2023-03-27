package footprint.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Color {
	@Id
	private String idColor; 
	
	private String nameColor; 
	
	
	@OneToMany(mappedBy = "color", fetch = FetchType.EAGER)
	private Collection<Product> products;

	public String getIdColor() {
		return idColor;
	}

	public void setIdColor(String idColor) {
		this.idColor = idColor;
	}

	public String getNameColor() {
		return nameColor;
	}

	public void setNameColor(String nameColor) {
		this.nameColor = nameColor;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public Color(String idColor, String nameColor, Collection<Product> products) {
		this.idColor = idColor;
		this.nameColor = nameColor;
		this.products = products;
	}

	public Color() {
	
	}
	
}
