package footprint.dao;


import java.util.List;

import footprint.entity.Product;
import footprint.entity.Thumbnail;

public interface ProductDao {
	/* public boolean addProduct(Product product); */
	public List<Product> getAllProducts (); 
	public boolean addProductAndThumbnails(Product product,Thumbnail [] thumbnails);
	public Product getProductWithId(Long idProduct);
	
}