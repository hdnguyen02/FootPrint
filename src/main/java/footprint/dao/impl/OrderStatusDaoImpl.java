package footprint.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.dao.OrderStatusDao;
import footprint.entity.OrderStatus;


@Repository
@Transactional
public class OrderStatusDaoImpl implements OrderStatusDao{
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public List<OrderStatus> getAllOrderStatus () {
		Session session = sessionFactory.getCurrentSession(); 
		String hql = "from OrderStatus";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<OrderStatus> orderStatus = query.list();
		return orderStatus;
	}
	
}	
