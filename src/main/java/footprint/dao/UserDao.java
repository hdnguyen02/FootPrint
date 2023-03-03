package footprint.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import footprint.dao.UserDao;
import footprint.entity.UserEntity;




@Repository
@Transactional
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	
	
	public List<UserEntity> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserEntity.class);
		@SuppressWarnings("unchecked")
		List<UserEntity> user = (List<UserEntity>) criteria.list();
		return user;
	}
}
