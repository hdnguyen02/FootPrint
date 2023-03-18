package footprint.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import footprint.bean.UploadFile;
import footprint.dao.ProductDao;
import footprint.entity.Product;
import footprint.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired 
	private ProductDao productDao; 
	
	@Autowired
	@Qualifier("imageProduct")
	UploadFile uploadFile; 
	
	
	public boolean insert(Product product, MultipartFile imageProduct) {
		String imageName = uploadFile.handleUploadFile(imageProduct); 
		if (imageName == null) {
			return false; 
		}
		product.setImageName(imageName);
		return productDao.insert(product); 
	}
}
