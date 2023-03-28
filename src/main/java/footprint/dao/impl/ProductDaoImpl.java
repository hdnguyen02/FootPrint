package footprint.dao.impl;


import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.dao.ProductDao;
import footprint.entity.Product;
import footprint.entity.ProductSize;
import footprint.entity.Size;
import footprint.entity.Thumbnail;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	
	
	@Override
	public List<Product> getAllProducts () {
		Session session = sessionFactory.getCurrentSession(); 
		String hql = "from Product";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> products = query.list();
		return products;
	}
	
	
	@Override
	public boolean addProductThumbnailAndProductSize(Product product,Thumbnail [] thumbnails,Map<Size,Integer> sizeQuantityMap) {
		
		Session session = sessionFactory.openSession(); 
		Transaction transaction = session.beginTransaction(); 
		
		try { 
			session.save(product);  
	
			for (Thumbnail thumbnail: thumbnails) { 
				session.save(thumbnail);
			}
			
	
			for (Map.Entry<Size, Integer> sizeQuantity : sizeQuantityMap.entrySet()) {
		
			    Size size = sizeQuantity.getKey();
			    int quantity = sizeQuantity.getValue();
			    ProductSize productSize = new ProductSize(); 
			    productSize.setProduct(product);
			    productSize.setSize(size);
			    productSize.setQuantity(quantity);
			    
			    session.save(productSize);
			    
			}
			
			transaction.commit(); 
			return true;
		}
		catch (Exception e) {
			return false;
		}

	}
	
	// nếu như thêm cả size vào ngay bây giờ rất rắc rối -> phải chác c
	
	@Override
	public Product getProductWithId(Long idProduct) {
		Session session = sessionFactory.getCurrentSession(); 

		String hql = "FROM Product WHERE idProduct = :idProduct";
		Query query = session.createQuery(hql);
		query.setParameter("idProduct", idProduct);
		Product product = (Product) query.uniqueResult();
		return product; 
	}


	
}