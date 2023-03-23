package footprint.dao.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;

import footprint.dao.AccountDao;
import footprint.entity.Account;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean insert(Account account) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			
			account.setCreateAt(new Date());
			account.setDisable(false);
	
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
	
	@Override
	public Account getAccountByUsername (String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Account where username = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		try {
			return (Account) query.list().get(0);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public Account getAccountByEmail(String email) { 
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Account where email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		try {
			return (Account) query.list().get(0);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	
	@Override
	public boolean update(Account account) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(account);
			transaction.commit();
			return true; 
		} catch (Exception e) {
			transaction.rollback();
			return false; 
		} finally {
			session.close();
		}
	}	
}
