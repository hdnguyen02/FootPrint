package footprint.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;

import footprint.dao.AccountDao;
import footprint.entity.Account;
import footprint.entity.Cart;
import footprint.entity.Role;

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
	public Account getAccountByUsername(String username) {
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
	
	@Override
	public Account getAccountWithId(Long idAccount) { 
		Session session = sessionFactory.getCurrentSession(); 
		Account account = (Account) session.get(Account.class,idAccount); 
		return account; 
	}
	
	@Override
	public List<Account> listAccountWithRole(EnumRoleID idRole) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From Account Where idRole = :role";
		Query query = session.createQuery(hql);
		query.setString("role", idRole.name()); 
		@SuppressWarnings("unchecked")
		List<Account> acc = query.list();
		return acc;
	}
	
	// kiểm tra xem 1 productSize có tồn tại chưa
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
	public boolean deleteAccount(Account account) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(account);
			t.commit();
			return true;

		} catch (Exception e) {
			t.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
		return false;
	}
	
	@Override
	public Role getRoleViaEnum(EnumRoleID role) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From Role Where idRole = :roleGetterID";
		Query query = session.createQuery(hql);
		query.setString("roleGetterID", role.toString());
		Role roleDB = null;

		try {
			roleDB = (Role) query.uniqueResult();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return roleDB;
	}
}
