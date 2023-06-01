package footprint.dao; 
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;

import footprint.entity.Customer;


@Repository
@Transactional
public class CustomerDao  {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Customer getCustomerWithId(Integer idCustomer) { 
		Session session = sessionFactory.getCurrentSession(); 
		Customer account = (Customer) session.get(Customer.class,idCustomer); 
		return account; 
	}
	
	
	public boolean insert(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			customer.setDisable(false);
	
			session.save(customer);
			transaction.commit();
			return true; 
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}
	

	public Customer getCustomerByEmail(String email) { 
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Customer where email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		try {
			return (Customer) query.list().get(0);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	

	public boolean update(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(customer);
			transaction.commit();
			return true; 
		} catch (Exception e) {
			transaction.rollback();
			return false; 
		} finally {
			session.close();
		}
	}	
	
	// kiểm tra xem 1 productSize có tồn tại chưua
	/*
	 * @Override public Cart getCart(Long idAccount,Long idProductSize) { Session
	 * session = sessionFactory.getCurrentSession(); String hql =
	 * "FROM Cart WHERE idAccount = :idAccount AND idProductSize = :idProductSize";
	 * Query query = session.createQuery(hql); query.setParameter("idAccount",
	 * idAccount); query.setParameter("idProductSize", idProductSize); return (Cart)
	 * query.uniqueResult(); }
	 */
	
	
}