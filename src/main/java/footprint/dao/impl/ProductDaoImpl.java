package footprint.dao.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.dao.ProductDao;
import footprint.entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	
	@Autowired
	SessionFactory sessionFactory; 
	
		
	@Override
	public boolean insert(Product product) {
		
		Session session = sessionFactory.openSession(); 
		Transaction transaction = session.beginTransaction(); 
		try { 
			product.setCreateAt(new Date());
			product.setDisable(false);
			session.save(product); 
			transaction.commit(); 
			return true; 
		}
		catch (Exception e) { 
			transaction.rollback();
			return false; 
		}
	    finally {
			session.close();
		}	
	}
}
