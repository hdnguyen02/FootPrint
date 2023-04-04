package footprint.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footprint.dao.OrderDao;
import footprint.entity.OrderCT;
import footprint.entity.OrderDetail;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public boolean createOrderAndOrderDetail(OrderCT order,List<OrderDetail> ordersDetail) {
		
		Session session = sessionFactory.openSession(); 
		Transaction transaction = session.beginTransaction(); 
		
		
		try { 
			session.save(order);  
			for (OrderDetail orderDetail : ordersDetail) {
				session.save(orderDetail); 
			}
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
	

}
