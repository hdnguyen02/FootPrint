package footprint.service;

import java.util.List;

import footprint.entity.ProductSize;

public interface ProductSizeService {
	public List<ProductSize> getProductSizeWithIdProduct(Long idProduct);
	public ProductSize getProductSize(Long idProduct,String idSize); 
	public ProductSize getProductSizeWithId(Long idProductSize);
}
