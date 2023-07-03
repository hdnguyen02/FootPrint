package footprint.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import footprint.dao.ThumbnailDao;
import footprint.entity.Product;
import footprint.entity.Thumbnail;
import footprint.service.ThumbnailService;

@Service
public class ThumbnailServiceImpl implements ThumbnailService{
	
	@Autowired
	ThumbnailDao thumbnaiDao;
	
	/*
	 * @Autowired
	 * 
	 * @Qualifier("thumbnailProduct") UploadFile uploadFile;
	 */
	
	@Override
	public boolean insert(Thumbnail thumbbnail,MultipartFile file,Product product) {	
		/*
		 * try { thumbbnail.setName(uploadFile.handleUploadFile(file));
		 * thumbbnail.setProduct(product); thumbnaiDao.insert(thumbbnail); return true;
		 * } catch(Exception e){ return false; }
		 */
		return true;
	}
}
