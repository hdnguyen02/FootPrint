package footprint.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Category")
public class Category {
	@Id
	@GeneratedValue
	@Column(name="idCategory")
	private Long idCategory; 
	
	
	@Column(name="name")
	private String name; 
	
	@Column(name="disable")
	private Boolean disable; 
	
	@Column(name="createAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt; 
	
	
	@Column(name="updateAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateAt; 
	
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private Collection<Product> products;

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}
	
	

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Product> getProducts() {
		return products;
	}
	
	

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	

	

	public Category(Long idCategory, String name, Boolean disable, Date createAt, Date updateAt,
			Collection<Product> products) {
		this.idCategory = idCategory;
		this.name = name;
		this.disable = disable;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.products = products;
	}

	public Category() {
		
	}
	
	
	
	
	
	
	
}
