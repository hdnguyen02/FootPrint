package footprint.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue
	@Column(name="idProduct")
	private Long idProduct; 
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="cost")
	private Float cost; 
	
	@Column(name="imageName")
	private String imageName; 
	  
	@Column(name="createAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@Column(name="updateAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateAt;
	
	@Column(name="disable")
	private Boolean disable; 
	
	
	// chứa khóa ngoại
	@ManyToOne
	@JoinColumn(name="idCategory")
	private Category category; 
		
	
	// được chứa khóa ngoại
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private Collection<Thumbnail> thumbnails;


	public Long getIdProduct() {
		return idProduct;
	}


	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Float getCost() {
		return cost;
	}


	public void setCost(Float cost) {
		this.cost = cost;
	}

	

	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
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


	public Boolean getDisable() {
		return disable;
	}


	public void setDisable(Boolean disable) {
		this.disable = disable;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	public Collection<Thumbnail> getThumbnails() {
		return thumbnails;
	}


	public void setThumbnails(Collection<Thumbnail> thumbnails) {
		this.thumbnails = thumbnails;
	}


	public Product(Long idProduct, String name, String description, Float cost, String imageName, Date createAt,
			Date updateAt, Boolean disable, Category category, Collection<Thumbnail> thumbnails) {
		this.idProduct = idProduct;
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.imageName =  imageName;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.disable = disable;
		this.category = category;
		this.thumbnails = thumbnails;
	}


	public Product() {
		
	} 
	
	
	
	
	
	
	
	
}
