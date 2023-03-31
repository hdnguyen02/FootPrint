package footprint.dao.impl;


import java.util.List;

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
	public boolean addProductThumbnailAndProductSize(Product product,Thumbnail [] thumbnails,List<Size> sizes,int [] sizesQuantity) {
		
		Session session = sessionFactory.openSession(); 
		Transaction transaction = session.beginTransaction(); 
		
		try { 
			session.save(product);  
	
			for (Thumbnail thumbnail: thumbnails) { 
				session.save(thumbnail);
			}
			
			
			int index = 0; 
			for (Size size : sizes) { 
				int quantity = sizesQuantity[index]; 
				ProductSize productSize = new ProductSize(); 
				productSize.setProduct(product);
				productSize.setSize(size);
				productSize.setQuantity(quantity);
				session.save(productSize);
				index++; 
				
			}
			
			transaction.commit(); 
			return true;
		}
		catch (Exception e) {
			return false;
		}

	}

	
	@Override
	public Product getProductWithId(Long idProduct) {
		Session session = sessionFactory.getCurrentSession(); 

		String hql = "FROM Product WHERE idProduct = :idProduct";
		Query query = session.createQuery(hql);
		query.setParameter("idProduct", idProduct);
		Product product = (Product) query.uniqueResult();
		return product; 
	}
	
	@Override
	public List<Product> getProductsActive() {
		Session session = sessionFactory.getCurrentSession(); 
		String hql = "from Product WHERE disable = :disable"; 
		Query query = session.createQuery(hql);
		query.setParameter("disable", false); 
		@SuppressWarnings("unchecked")
		List<Product> products = query.list();
		return products;
	}
	
}