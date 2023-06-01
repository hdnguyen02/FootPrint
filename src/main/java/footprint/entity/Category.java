package footprint.entity;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {
	@Id
	private String idCategory;

	private String name;
	

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private Collection<Product> products;


	public String getIdCategory() {
		return idCategory;
	}


	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Collection<Product> getProducts() {
		return products;
	}


	public void setProducts(Collection<Product> products) {
		this.products = products;
	}


	public Category(String idCategory, String name, Collection<Product> products) {
		this.idCategory = idCategory;
		this.name = name;
		this.products = products;
	}
	
	public Category() {
		
	}
	

	
	
	
	
}
