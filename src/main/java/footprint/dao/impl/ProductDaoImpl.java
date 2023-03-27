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
import footprint.entity.Thumbnail;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	
	@Autowired
	private SessionFactory sessionFactory; 
	
		
	/*
	 * @Override public boolean addProduct(Product product) { Session session =
	 * sessionFactory.openSession(); Transaction transaction =
	 * session.beginTransaction(); try { session.save(product);
	 * transaction.commit(); return true; } catch (Exception e) {
	 * transaction.rollback(); return false; } finally { session.close(); } }
	 */
	
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
	public boolean addProductAndThumbnails(Product product,Thumbnail [] thumbnails) {
		
		Session session = sessionFactory.openSession(); 
		Transaction transaction = session.beginTransaction(); 
		
		try { 
			session.save(product); 
			
			for (Thumbnail thumbnail: thumbnails) {
				session.save(thumbnail);
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
		String hql = "from Product where idProduct = :idProduct";
		Query query = session.createQuery(hql);
		query.setParameter("idProduct", idProduct);
		try {
			return (Product) query.list().get(0);
		}
		catch(Exception e) {
			return null;
		}
	}
	
}