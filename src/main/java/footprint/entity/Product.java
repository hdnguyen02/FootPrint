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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long idProduct;

	private String name;

	private String description;

	private Float cost;

	private String imageName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@Column(name = "updateAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateAt;

	private Boolean disable;

	// chứa khóa ngoại
	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "idColor")
	private Color color;

	// được chứa khóa ngoại
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private Collection<Thumbnail> thumbnails;

	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private Collection<ProductSize> productSizes;

	public Collection<ProductSize> getProductSizes() {
		return productSizes;
	}

	public void setProductSizes(Collection<ProductSize> productSizes) {
		this.productSizes = productSizes;
	}

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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Product(Long idProduct, String name, String description, Float cost, String imageName, Date createAt,
			Date updateAt, Boolean disable, Category category, Color color, Collection<Thumbnail> thumbnails,
			Collection<ProductSize> productSizes) {
		this.idProduct = idProduct;
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.imageName = imageName;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.disable = disable;
		this.category = category;
		this.color = color;
		this.thumbnails = thumbnails;
		this.productSizes = productSizes;
	}

	public Product() {

	}
}
