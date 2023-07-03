package footprint.service;

import org.springframework.web.multipart.MultipartFile;

import footprint.entity.Product;
import footprint.entity.Thumbnail;

public interface ThumbnailService {
	public boolean insert(Thumbnail thumbbnail,MultipartFile file,Product product); // cần đưa vào khóa ngoại
	// thêm nhiều cái vào cùng lúc 
	
}
