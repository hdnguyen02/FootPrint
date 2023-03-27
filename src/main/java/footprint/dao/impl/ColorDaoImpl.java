package footprint.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.dao.ColorDao;
import footprint.entity.Color;


@Repository
@Transactional
public class ColorDaoImpl implements ColorDao {
	
	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public List<Color> getAllColors() {
		Session session = sessionFactory.getCurrentSession(); 
		String hql = "from Color";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Color> colors = query.list();
		return colors;
	}
	

}
