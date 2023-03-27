package footprint.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import footprint.bean.UploadFile;
import footprint.dao.ProductDao;
import footprint.entity.Product;
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
	
	
	/*
	 * @Override public Product addProductAndSaveImage(Product product,
	 * MultipartFile imageProduct) { String nameImageProduct =
	 * uploadImageProduct.handleUploadFile(imageProduct);
	 * 
	 * // sử lý hình ảnh tại đây if (nameImageProduct == null) { return null; }
	 * product.setImageName(nameImageProduct); product.setCreateAt(new Date());
	 * product.setDisable(false); // sử lý lại chỗ này.
	 * 
	 * boolean sucessAddProdut = productDao.addProduct(product);
	 * 
	 * if (!sucessAddProdut) { // thực hiện xóa file tại đây. return null; } return
	 * product; }
	 */
	
	
	// hàm thêm sản phẩm + thumbnail vào đây
	@Override
	public boolean addProductAndThumbnails(Product product,MultipartFile imageProduct,Thumbnail [] thumbnails,MultipartFile [] imageThumbnails) {
		
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
		
		/*
		 * try {
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 */
		
		
		
		product.setImageName(nameImageProduct);
		product.setCreateAt(new Date());
		product.setDisable(false);
		
		System.out.println(product.getIdProduct());
		
		
		for (int i = 0; i < thumbnails.length;i++) {
			thumbnails[i] = new Thumbnail(); 
			thumbnails[i].setProduct(product);
			thumbnails[i].setName(successImageThumbnails.get(i)); 
		}
		
		boolean insertSuccess = productDao.addProductAndThumbnails(product,thumbnails);
		if (!insertSuccess) {
			System.out.println("Lỗi Thêm database");
			// Thực hiện xóa file
			return false;
		} 
		
		return true;
	}
	
	
	
}