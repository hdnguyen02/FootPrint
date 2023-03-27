package footprint.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.dao.ThumbnailDao;
import footprint.entity.Thumbnail;


@Repository
@Transactional
public class ThumbnailDaoImpl implements ThumbnailDao {
	
	@Autowired
	private SessionFactory sessionFactory; 
	
		
	@Override
	public void insert(Thumbnail thumbnail) {
		Session session = sessionFactory.openSession(); 
		Transaction transaction = session.beginTransaction(); 
		try { 
			session.save(thumbnail); 
			transaction.commit();  
		}
		catch (Exception e) { 
			transaction.rollback(); 
		}
	    finally {
			session.close();
		}	
	}

}
