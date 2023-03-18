package footprint.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.dao.CategoryDao;
import footprint.entity.Category;


@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getAllCategories() {
		Session session = sessionFactory.getCurrentSession(); 
		String hql = "from Category";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> categorys = query.list();
		return categorys;
	}
	
	
	
	public List<Category> getCategoriesInRange (int start, int end) { 
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Category");
        query.setFirstResult(start);
        query.setMaxResults(end - start + 1);
        @SuppressWarnings("unchecked")
        List<Category> categories = query.list();
        return categories;
	}
	
	public boolean insert(Category category) {
		Session session = sessionFactory.openSession(); 
		Transaction transaction = session.beginTransaction(); 
		try { 
			category.setCreateAt(new Date());
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
}

