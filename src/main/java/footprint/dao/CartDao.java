package footprint.dao;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.entity.Cart;

@Repository  
@Transactional
public class CartDao {
	@Autowired
	private SessionFactory sessionFactory; 
	
	
	
	public void addCart(Cart cart) { 
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(cart);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {	
			session.close();
		}
	}
	
	public Cart getCart(String idProduct,Integer idCustomer) {
		Session session = sessionFactory.openSession(); 
		String hql = "FROM Cart WHERE idCustomer = :idCustomer AND idProduct = :idProduct";
		Query query = session.createQuery(hql);
		query.setParameter("idCustomer", idCustomer);
		query.setParameter("idProduct", idProduct);
		Cart cart = (Cart) query.uniqueResult(); 
		session.close(); 
		return cart;
	}
	
	public void updateCart(Cart cart) { 
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(cart);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {	
			session.close();
		}
		
	}
	
	public Cart getCartWithId(Integer idCart) {
		Session session = sessionFactory.getCurrentSession(); 
		return (Cart) session.get(Cart.class,idCart);  
	}
	
	public void deleteCart(Integer idCart) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		Cart cart = (Cart)session.get(Cart.class, idCart); 
		try {
			session.delete(cart);
			transaction.commit();

		}
		catch (Exception e) { 
			transaction.rollback();
		}
	    finally {
			session.close();
		}
	}
	
	public List<Cart> getCartsWithIds(Integer [] idCarts) { 
		List<Cart> carts = new ArrayList<>(); 
		Session session = sessionFactory.getCurrentSession(); 
		
		for (Integer idCart :idCarts) { 
			Cart cart = (Cart)session.get(Cart.class, idCart);
			carts.add(cart);
		}
		return carts; 
	}
	
	
	
}
