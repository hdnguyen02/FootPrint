package footprint.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;

import footprint.dao.UserDao;
import footprint.entity.Account;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean insert(Account account) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(account);
			transaction.commit();
			return true; 
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}
	
	
	
}
