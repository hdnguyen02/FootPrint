package footprint.dao;

import java.util.List;

import footprint.entity.ProductSize;

public interface ProductSizeDao {
	// liệt kê ra tất cả product size của id giày
	public List<ProductSize> getProductSizeWithIdProduct(Long idProduct); 
	public ProductSize getProductSize(Long idProduct,String idSize); 
}
