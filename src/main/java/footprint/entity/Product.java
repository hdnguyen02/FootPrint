package footprint.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	private String idProduct;

	private String name;

	private Float cost;

	private String size;

	private Integer quantity;

	private String description;

	private String color;

	private String image;

	private Boolean disable;

	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Collection<Thumbnail> thumbnails;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Collection<ImportDetail> importDetails;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Collection<ExportDetail> exportDetails;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Collection<Cart> carts;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Collection<OrderDetail> orderDetails;

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

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Collection<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Collection<Cart> carts) {
		this.carts = carts;
	}

	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Collection<ImportDetail> getImportDetails() {
		return importDetails;
	}

	public void setImportDetails(Collection<ImportDetail> importDetail) {
		this.importDetails = importDetail;
	}

	public Collection<ExportDetail> getExportDetails() {
		return exportDetails;
	}

	public void setExportDetails(Collection<ExportDetail> exportDetails) {
		this.exportDetails = exportDetails;
	}

	public Product() {

	}

	public Product(String idProduct, String name, Float cost, String size, Integer quantity, String description,
			String color, String image, Boolean disable, Category category, Collection<Thumbnail> thumbnails,
			Collection<ImportDetail> importDetails, Collection<ExportDetail> exportDetails, Collection<Cart> carts,
			Collection<OrderDetail> orderDetails) {
		this.idProduct = idProduct;
		this.name = name;
		this.cost = cost;
		this.size = size;
		this.quantity = quantity;
		this.description = description;
		this.color = color;
		this.image = image;
		this.disable = disable;
		this.category = category;
		this.thumbnails = thumbnails;
		this.importDetails = importDetails;
		this.exportDetails = exportDetails;
		this.carts = carts;
		this.orderDetails = orderDetails;
	}

}
