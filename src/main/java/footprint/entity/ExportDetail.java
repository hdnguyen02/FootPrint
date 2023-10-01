package footprint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ExportDetail {
	@Id
	@GeneratedValue
	private Integer idExportDetail;

	@ManyToOne
	@JoinColumn(name = "idExport")
	private Export export;

	@ManyToOne
	@JoinColumn(name = "idProduct")
	private Product product;

	private Float cost;
	private Integer quantity;

	public Integer getIdExportDetail() {
		return idExportDetail;
	}

	public void setIdExportDetail(Integer idExportDetail) {
		this.idExportDetail = idExportDetail;
	}

	public Export getExport() {
		return export;
	}

	public void setExport(Export export) {
		this.export = export;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ExportDetail(Integer idExportDetail, Export export, Product product, Float cost, Integer quantity) {
		this.idExportDetail = idExportDetail;
		this.export = export;
		this.product = product;
		this.cost = cost;
		this.quantity = quantity;
	}
	
	public ExportDetail() {
		
	}
	

}
