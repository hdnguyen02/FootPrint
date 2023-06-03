package footprint.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import footprint.entity.Category;




@Repository
@Transactional
public class CategoryDao {
	
	@Autowired 
	private SessionFactory sessionFactory;

	
	public List<Category> getAllCategories() {
		Session session = sessionFactory.openSession(); 
		String hql = "from Category";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> categorys = query.list();
		session.close(); 
		return categorys;
	}
	
	
	public boolean insert(Category category) {
		Session session = sessionFactory.openSession(); 
		Transaction transaction = session.beginTransaction(); 
		try { 
			session.save(category); 
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
	
	public boolean update(Category category) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();


		try {
			session.update(category);
			transaction.commit();
			return true; 
		} catch (Exception e) {
			transaction.rollback();
			return false; 
		} finally {
			session.close();
		}
	}
	
	
	public Category getCategoryWithId(String idCategory) { 
		Session session = sessionFactory.openSession();
		Category category = (Category) session.get(Category.class, idCategory);
		session.close();
		return category;
	}
	
	
	
}
