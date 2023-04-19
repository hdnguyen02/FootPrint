package footprint.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import footprint.entity.Product;
import footprint.entity.Size;
import footprint.entity.Thumbnail;

public interface ProductService {
	
	
	public Product getProductWithId(Long idProduct);
	public boolean addProductThumbnailsProductSize(Product product,MultipartFile imageProduct,Thumbnail [] thumbnails,MultipartFile [] imageThumbnails,List<Size> sizes,int [] sizesQuantity);
	public List<Product> getAllProduct(); 
	public List<Product> getProductsActive();
	public List<Product> searchProducts(String name);
	public List<Product> filterByCategory(long idCategory);
	
	// Phân trang
	public int computedTotalPage(List<Product> products,int productPerPage);
	public List<Product> getProductPerPage(List<Product> products,int productPerPage,int curentPage);
	
	
}
