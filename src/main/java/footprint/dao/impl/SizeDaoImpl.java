package footprint.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.dao.SizeDao;
import footprint.entity.Size;


@Repository
@Transactional
public class SizeDaoImpl implements SizeDao {
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public List<Size> getAllSizes() {
		 Session session = sessionFactory.getCurrentSession(); 
			String hql = "from Size";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Size> sizes = query.list();
			return sizes;
	}
}
