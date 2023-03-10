package footprint.service;

import org.springframework.web.multipart.MultipartFile;

import footprint.entity.Product;

public interface ProductService {
	public boolean insert(Product product, MultipartFile file); 
}
