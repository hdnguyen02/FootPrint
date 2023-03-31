package footprint.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.dao.CartDao;
import footprint.entity.Cart;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addCart(Cart cart) { 
		Session session = sessionFactory.openSession(); 
		Transaction transaction = session.beginTransaction(); 
		try { 
			session.save(cart); 
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
