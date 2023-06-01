package footprint.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import footprint.entity.Category;




@Repository
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
	
	
	
	
	
}
