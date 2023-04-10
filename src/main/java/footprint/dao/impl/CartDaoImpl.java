package footprint.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
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
	
	@Override
	public boolean updateCart(Cart cart) { 
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(cart);
			transaction.commit();
			return true; 
		} catch (Exception e) {
			transaction.rollback();
			return false; 
		} finally {	
			session.close();
		}
	}
	
	@Override
	public Cart getCart(Long idAccount,Long idProductSize) {
		Session session = sessionFactory.getCurrentSession(); 
		String hql = "FROM Cart WHERE idAccount = :idAccount AND idProductSize = :idProductSize";
		Query query = session.createQuery(hql);
		query.setParameter("idAccount", idAccount);
		query.setParameter("idProductSize", idProductSize);
		return (Cart) query.uniqueResult();
	}
	
	@Override
	public Cart getCartWithId(Long idCart) {
		Session session = sessionFactory.getCurrentSession(); 
		return (Cart) session.get(Cart.class,idCart);  
	}
	

	@Override
	public boolean deleteCart(Long idCart) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		// lấy ra entity 
		Cart cart = (Cart)session.get(Cart.class, idCart); 
		try {
			session.delete(cart);
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
	
	@Override
	public List<Cart> getCartsWithIds(Long [] idCarts) { 
		List<Cart> carts = new ArrayList<>(); 
		Session session = sessionFactory.getCurrentSession(); 
		
		for (Long idCart :idCarts) { 
			Cart cart = (Cart)session.get(Cart.class, idCart);
			carts.add(cart);
		}
		return carts; 
	}
	
	
}
