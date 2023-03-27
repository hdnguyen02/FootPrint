package footprint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import footprint.dao.ProductSizeDao;
import footprint.entity.ProductSize;

import footprint.service.ProductSizeService;


@Service
public class ProductSizeServiceImpl implements ProductSizeService {
   @Autowired
   private ProductSizeDao productSizeDao;
   
   
   @Override
   public List<ProductSize> getProductSizeWithIdProduct(Long idProduct) {
	   return productSizeDao.getProductSizeWithIdProduct(idProduct);
   }
}