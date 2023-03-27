package footprint.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import footprint.entity.Product;
import footprint.entity.Size;
import footprint.entity.Thumbnail;

public interface ProductService {
	
	public int totalPage();
	public List<Product> getProductsPerPage(int curentPage);
	public Product getProductWithId(Long idProduct);
	public boolean addProductThumbnailsProductSize(Product product,MultipartFile imageProduct,Thumbnail [] thumbnails,MultipartFile [] imageThumbnails,Map<Size,Integer> sizeQuantityMap);
	

}
