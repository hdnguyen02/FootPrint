package footprint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ImportDetail {

	@Id
	@GeneratedValue
	private Integer IdImportDetail;

	private Integer quantity;
	
	private Float cost; // Giá nhập sp -> khác với giá bán.  
	

	@ManyToOne
	@JoinColumn(name = "idImport")
	private Import importEntity;

	@ManyToOne
	@JoinColumn(name = "idProduct")
	private Product product;

	public Integer getIdImportDetail() {
		return IdImportDetail;
	}

	public void setIdImportDetail(Integer idImportDetail) {
		IdImportDetail = idImportDetail;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Import getImportEntity() {
		return importEntity;
	}

	public void setImportEntity(Import importEntity) {
		this.importEntity = importEntity;
	}

	public Product getProduct() {
		return product;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public ImportDetail(Integer idImportDetail, Integer quantity, Float cost, Import importEntity, Product product) {
		IdImportDetail = idImportDetail;
		this.quantity = quantity;
		this.cost = cost;
		this.importEntity = importEntity;
		this.product = product;
	}

	public ImportDetail() { 
		
	}
	
	

}
