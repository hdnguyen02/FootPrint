package footprint.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import footprint.bean.UploadFile;
import footprint.dao.ProductDao;
import footprint.entity.Product;
import footprint.entity.Thumbnail;

@Service
public class ProductService {
	
	
	@Autowired 
	private ProductDao productDao; 
	
	@Autowired
	@Qualifier("imageProduct")
	private UploadFile uploadImageProduct; 
	
	@Autowired
	@Qualifier("imageThumbnail")
	private UploadFile uploadImageThumbnail; 
	
	public List<Product> getAllProducts(){
		return productDao.getAllProducts(); 
		
	}
	
	public Product getProductWithId(String id) { 
		return productDao.getProductWithId(id); 
	}
	
	
	public Product getProductCurentSS(String id) { 
		return productDao.getProductCurentSS(id); 
	}
	
	public boolean update(Product product) { 
		return productDao.update(product); 
	}
	
	public List<Product> searchProducts(String name) {
		return productDao.searchProducts(name);
	}
	
	public List<Product> filterByCategory(String idCategory) {
		return productDao.filterByCategory(idCategory);
	}

	public List<Product> filterByPrice(float min, float max) {
		return productDao.filterByPrice(min, max);
	}
	
	public List<Product> filterByColor(String color) {
		return productDao.filterByColor(color);
	}
	
	public List<Product> filterBySize(String size) {
		return productDao.filterBySize(size);
	}
	
	public boolean addProductAndThumbnail(Product product,MultipartFile imageProduct,Thumbnail [] thumbnails,MultipartFile [] imageThumbnails) {
			
			String nameImageProduct = uploadImageProduct.handleUploadFile(imageProduct);
		
			List<String> successImageThumbnails = new ArrayList<>(); 
			
			for (MultipartFile imageThumbnail : imageThumbnails) {
				String nameImageThumbnail = uploadImageThumbnail.handleUploadFile(imageThumbnail);
				
				if (nameImageThumbnail != null) { 
					successImageThumbnails.add(nameImageThumbnail);
				}
			}
			
			if (nameImageProduct == null || imageThumbnails.length != successImageThumbnails.size()) {
				return false;
			}
			
			
		
			product.setImage(nameImageProduct);
		
			for (int i = 0; i < thumbnails.length;i++) {
				thumbnails[i] = new Thumbnail(); 
				thumbnails[i].setProduct(product);
				thumbnails[i].setName(successImageThumbnails.get(i)); 
			}
			
			return productDao.addProductAndThumbnail(product,thumbnails);
		
		}
	
	

		public List<Product> getProductsActive() {
			return productDao.getProductsActive(); 
		}
		
		// hàm phân trang
		
		
		public int computedTotalPage(List<Product> products,int productPerPage) { 
			int sizeProducts = products.size(); 
			return (int) Math.ceil((double) sizeProducts / productPerPage);
		} 
		public List<Product> getProductPerPage(List<Product> products,int productPerPage,int curentPage) { 
			int sizeProducts = products.size(); 
			int startIndex = (curentPage - 1) * productPerPage;
			int endIndex = Math.min(startIndex + productPerPage, sizeProducts);
			return products.subList(startIndex, endIndex);	
		}
} 
