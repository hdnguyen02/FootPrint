package footprint.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import footprint.entity.Product;
import footprint.entity.Thumbnail;

public interface ProductService {
	/*
	 * public Product addProductAndSaveImage(Product product, MultipartFile file);
	 */
	public boolean addProductAndThumbnails(Product product,MultipartFile imageProduct,Thumbnail [] thumbnails,MultipartFile [] imageThumbnails);
	public int totalPage();
	public List<Product> getProductsPerPage(int curentPage);
	public Product getProductWithId(Long idProduct);
	/* public boolean addImageAndThumbnailProduct(); */
	
	// public boolean addProductWithThumbnail(Product product,MultipartFile imageProduct,List<Thumbnail> thumbnails,MultipartFile [] imageThumbnails);

}
