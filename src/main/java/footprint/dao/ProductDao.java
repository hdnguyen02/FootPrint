package footprint.dao;


import java.util.List;
import java.util.Map;

import footprint.entity.Product;
import footprint.entity.Size;
import footprint.entity.Thumbnail;

public interface ProductDao {
	/* public boolean addProduct(Product product); */
	public List<Product> getAllProducts (); 

	/*
	 * public boolean addProductThumbnails(Product product,Thumbnail [] thumbnails);
	 */
	public boolean addProductThumbnailAndProductSize(Product product,Thumbnail [] thumbnails,Map<Size,Integer> sizeQuantityMap);
	public Product getProductWithId(Long idProduct);
	/* public List<Thumbnail> getThumbnails(Product product); */
	
	
	
}