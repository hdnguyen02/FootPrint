package footprint.dao;


import java.util.List;
import java.util.Map;

import footprint.entity.Product;
import footprint.entity.Size;
import footprint.entity.Thumbnail;

public interface ProductDao {
	public List<Product> getAllProducts (); 
	public boolean addProductThumbnailAndProductSize(Product product,Thumbnail [] thumbnails,List<Size> sizes,int [] sizesQuantity);
	public Product getProductWithId(Long idProduct);
	public List<Product> getProductsActive();
	public List<Product> searchProducts(String name);
	public List<Product> filterByCategory(long idCategory); 
	public boolean updateQuantityProducts(Product product, Map<Long,Integer> pSMap); 
	public Product getProductWithOpenSS(Long idProduct); 
}