package footprint.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import footprint.bean.UploadFile;
import footprint.dao.ProductDao;
import footprint.entity.Product;
import footprint.entity.Size;
import footprint.entity.Thumbnail;
import footprint.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired 
	private ProductDao productDao; 
	
	@Autowired
	@Qualifier("imageProduct")
	private UploadFile uploadImageProduct; 
	
	@Autowired
	@Qualifier("imageThumbnail")
	private UploadFile uploadImageThumbnail; 


	@Override
	public Product getProductWithId(Long idProduct) {
		return productDao.getProductWithId(idProduct);
	}

	@Override
	public boolean addProductThumbnailsProductSize(Product product,MultipartFile imageProduct,Thumbnail [] thumbnails,MultipartFile [] imageThumbnails,List<Size> sizes,int [] sizesQuantity) {
		
		String nameImageProduct = uploadImageProduct.handleUploadFile(imageProduct);
	
		List<String> successImageThumbnails = new ArrayList<>(); 
		
		for (MultipartFile imageThumbnail : imageThumbnails) {
			String nameImageThumbnail = uploadImageThumbnail.handleUploadFile(imageThumbnail);
			
			if (nameImageThumbnail != null) { 
				successImageThumbnails.add(nameImageThumbnail);
			}
		}
		
		if (nameImageProduct == null || imageThumbnails.length != successImageThumbnails.size()) {
			// nếu không đây đủ file -> xóa hết file và không thêm gì vào database cả.
			System.out.println("Lỗi thêm file");
			return false;
		}
	

		product.setImageName(nameImageProduct);
		product.setCreateAt(new Date());


		for (int i = 0; i < thumbnails.length;i++) {
			thumbnails[i] = new Thumbnail(); 
			thumbnails[i].setProduct(product);
			thumbnails[i].setName(successImageThumbnails.get(i)); 
		}
		
		
		
		boolean insertSuccess = productDao.addProductThumbnailAndProductSize(product,thumbnails,sizes,sizesQuantity);
		if (!insertSuccess) {
			System.out.println("Lỗi Thêm database");
			// Thực hiện xóa file
			return false;
		} 
		
		return true;
	}
	
	public List<Product> getAllProduct() {
		return productDao.getAllProducts(); 
	}

	
	@Override
	public List<Product> getProductsActive() { 
		return productDao.getProductsActive();
	}
	
	
	@Override
	public int computedTotalPage(List<Product> products,int productPerPage) { 
		int sizeProducts = products.size(); 
		return (int) Math.ceil((double) sizeProducts / productPerPage);
	}
	
	@Override
	public List<Product> getProductPerPage(List<Product> products,int productPerPage,int curentPage) { 
		int sizeProducts = products.size(); 
		int startIndex = (curentPage - 1) * productPerPage;
		int endIndex = Math.min(startIndex + productPerPage, sizeProducts);
		return products.subList(startIndex, endIndex);	
	}
	
	@Override
	public List<Product> searchProducts(String name) {
		return productDao.searchProducts(name);
	}
	
	@Override
	public List<Product> filterByCategory(long idCategory) {
		return productDao.filterByCategory(idCategory);
	}
	
	@Override
	public boolean updateQuantityProducts(Product product, Map<Long,Integer> pSMap) { 
		return productDao.updateQuantityProducts(product,pSMap); 
	}
	@Override
	public Product getProductWithOpenSS(Long idProduct) { 
		return productDao.getProductWithOpenSS(idProduct); 
	}
}