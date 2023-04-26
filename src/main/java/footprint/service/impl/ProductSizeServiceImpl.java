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
   @Override
   public ProductSize getProductSize(Long idProduct,String idSize) {
	   return productSizeDao.getProductSize(idProduct, idSize);
   }
   @Override
   public ProductSize getProductSizeWithId(Long idProductSize) {
	   return productSizeDao.getProductSizeWithId(idProductSize);
   }
   
   @Override
   public boolean updatesQuantity(Long [] idProductSizes,Integer [] quantityBuys)  {
		return productSizeDao.updatesQuantity(idProductSizes, quantityBuys); 
	}
}
