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
	
	// số lượng trên mỗi page
	private int productPerPage = 6; 
	
	@Override 
	public int totalPage() {
		int sizeCategies = this.productDao.getAllProducts().size(); 
		int totalPages = (int) Math.ceil((double) sizeCategies / productPerPage);
		return totalPages;
	}
	
	@Override
	public List<Product> getProductsPerPage(int curentPage) {  
		List<Product> categories = this.productDao.getAllProducts(); 
		int sizeCategies = categories.size(); 
		int startIndex = (curentPage - 1) * this.productPerPage;
		int endIndex = Math.min(startIndex + this.productPerPage, sizeCategies);
		return categories.subList(startIndex, endIndex);	
	}

	@Override
	public Product getProductWithId(Long idProduct) {
		return productDao.getProductWithId(idProduct);
	}
	

	// hàm thêm sản phẩm + thumbnail vào đây
	@Override
	public boolean addProductThumbnailsProductSize(Product product,MultipartFile imageProduct,Thumbnail [] thumbnails,MultipartFile [] imageThumbnails,Map<Size,Integer> sizeQuantityMap) {
		
		String nameImageProduct = uploadImageProduct.handleUploadFile(imageProduct);
	
		List<String> successImageThumbnails = new ArrayList<>(); 
		
		for (MultipartFile imageThumbnail : imageThumbnails) {
			String nameImageThumbnail = uploadImageThumbnail.handleUploadFile(imageThumbnail);
			
			if (nameImageThumbnail != null) { 
				successImageThumbnails.add(nameImageThumbnail);
			}
		}
		
		
		// Kiểm tra tất cả các file đã được lưu thành công hay chưa
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
		
		boolean insertSuccess = productDao.addProductThumbnailAndProductSize(product,thumbnails,sizeQuantityMap);
		if (!insertSuccess) {
			System.out.println("Lỗi Thêm database");
			// Thực hiện xóa file
			return false;
		} 
		
		return true;
	}
	
	
	
}